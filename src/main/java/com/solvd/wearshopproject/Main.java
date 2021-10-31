package com.solvd.wearshopproject;

import com.solvd.wearshopproject.shop.*;
import com.solvd.wearshopproject.shop.catalog.*;
import com.solvd.wearshopproject.shop.catalog.parameters.Color;
import com.solvd.wearshopproject.shop.catalog.parameters.Fabric;
import com.solvd.wearshopproject.shop.catalog.parameters.FabricParameter;
import com.solvd.wearshopproject.shop.catalog.parameters.Size;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.solvd.wearshopproject.Buyer.createBuyer;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {

        BiFunction<Product, Integer, Double> discount = (pants, percent) -> {
            pants.setProductCost(pants.getProductCost() / 100 * (100 - percent));
            return pants.getProductCost();
        };
        BiConsumer<Position, Double> salary = (position, money) -> {
            if (money > 0) {
                position.increaseSalary(money);
                LOGGER.debug("Salary increased by: " + money);
            } else if (money < 0) {
                position.decreaseSalary(money);
                LOGGER.debug("Salary decreased by: " + money);
            }
        };
        Function<String, String> symbolDeleter = (data) -> {
            data = data.replaceAll(",", "");
            data = data.replaceAll("\\.", "");
            data = data.replaceAll(";", "");
            data = data.replaceAll(":", "");
            data = data.replaceAll("\\(", "");
            data = data.replaceAll("\\)", "");
            data = data.replaceAll("\"", "");
            data = data.replaceAll("\\[", "");
            data = data.replaceAll("]", "");
            data = data.replaceAll(" - ", "");
            data = data.replaceAll(" &", "");
            return data;
        };
        Function<Map<String, Integer>, Map<String, Integer>> mapSorter = (source) -> {
            Map<String, Integer> result = new LinkedHashMap<>();
            source.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                    .forEach(e -> result.put(e.getKey(), e.getValue()));
            return result;
        };

        Date date = new Date();
        Consultant consultant = new Consultant(800.00);
        Cashier cashier = new Cashier(1000.00);
        Employee employee1 = new Employee("Ivan", "Ivanov", cashier);
        Employee employee2 = new Employee("Petya", "Petrov", consultant);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        Department department = new Department("Sport wear", employees);
        Address<String> shopAddress = new Address<>("Independence Avenue", "100");
        Shop shop = new Shop(shopAddress, "Trade object", "Clothes for all family", department);

        try (ShopInfo shopInfo = new ShopInfo()) {
            shopInfo.writeToFile(shopInfo.getFILEPATH());
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
        }

        Map<String, Integer> sizes = new HashMap<>();
        sizes.put("height", 170);
        sizes.put("chest", 80);
        sizes.put("waist", 50);
        Buyer buyer = createBuyer(sizes, 600.00);
        Size size = new Size(buyer);

        FabricParameter pantsFabric = new FabricParameter(Color.BLUE, Fabric.JEANS);
        FabricParameter outerwearFabric = new FabricParameter(Color.BROWN, Fabric.LEATHER);
        FabricParameter shirtFabric = new FabricParameter(Color.GREEN, Fabric.COTTON);

        Wear pants = new MenWear(ProductType.PANTS, size, pantsFabric);
        Wear outerwear = new MenWear(ProductType.OUTERWEAR, size, outerwearFabric);
        Wear shirt = new MenWear(ProductType.SHIRT, size, shirtFabric);
        Glasses glasses = new Glasses(ProductType.SUNGLASSES);

        FittingRoom fitting = new FittingRoom();

        ShoppingCart<Position> shoppingCart = new ShoppingCart<>();

        LOGGER.debug("Current date and time: " + date);
        try {
            buyer.comeToShop(shop);
        } catch (ShopTimeException e) {
            LOGGER.debug(e.getMessage());
        } finally {
            LOGGER.debug("Operation is completed");
        }

        List<Wear> wears = new ArrayList<>();
        if (buyer.selectProduct(pants)) {
            LOGGER.debug(fitting.tryOn(pants));
            wears.add(pants);
        }
        if (buyer.selectProduct(outerwear)) {
            LOGGER.debug(fitting.tryOn(outerwear));
            wears.add(outerwear);
        }
        if (buyer.selectProduct(shirt)) {
            LOGGER.debug(fitting.tryOn(shirt));
            wears.add(shirt);
        }
        LOGGER.debug(fitting.tryOn(pants, shirt, outerwear));

        shoppingCart.addWears(wears);
        shoppingCart.calculatedTotalPrice();

        List<Wear> wearList = null;

        Wear myWear = wears.stream()
                .filter(wear -> wear.getProductCost() <= 100)
                .findFirst()
                .orElseThrow(() -> new RuntimeException());

        employees.stream()
                .filter(employee -> employee.getPosition().equals(consultant))
                .forEach(employee -> LOGGER.debug(employee.getName()));

        wearList = wearList.stream()
                .peek(wear -> wear.setProductCost(wear.getProductCost() * 0.5))
                .collect(Collectors.toList());

        List<Integer> s = wears.stream()
                .map(wear -> wear.getSize())
                .flatMap(size1 -> size1.getSize().values().stream())
                .collect(Collectors.toList());

        Wear searchedWear = wearList.stream()
                .filter(wear -> wear.getFabric().equals(Fabric.LEATHER))
                .findAny()
                .orElse(null);

        LOGGER.debug("REFLECTION START");

        ShopService service;
        String name;

        try {
            Class<?> serviceClass = Class.forName("com.solvd.wearshopproject.ShopServiceImpl");
            service = (ShopServiceImpl) serviceClass.newInstance();

            Field field = service.getClass().getDeclaredField("nameField");
            field.setAccessible(true);
            field.set(service, "SERVICE");
            name = (String) field.get(service);
            LOGGER.debug(name);

            Method startWorkMethod = serviceClass.getMethod("startWork", Workable.class);
            Method finishWorkMethod = serviceClass.getMethod("finishWork", Workable.class);
            Method goToCashierMethod = serviceClass.getMethod("goToCashier", Sellable.class);
            Method tryOnWearMethod = serviceClass.getMethod("tryOnWear", TryableOn.class);
            Method getConsultationMethod = serviceClass.getMethod("getConsultation", Consultantable.class);

            startWorkMethod.invoke(service, shop);
            getConsultationMethod.invoke(service, consultant);
            tryOnWearMethod.invoke(service, glasses);
            tryOnWearMethod.invoke(service, pants);
            tryOnWearMethod.invoke(service, outerwear);
            tryOnWearMethod.invoke(service, shirt);
            goToCashierMethod.invoke(service, shoppingCart);
            finishWorkMethod.invoke(service, shop);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException |
                InstantiationException e) {
            LOGGER.debug(e.getMessage());
        } finally {
            LOGGER.debug("REFLECTION END");
        }

        ShopService shopService = new ShopServiceImpl();
        shopService.startWork(shop);
        shopService.getConsultation(consultant);
        shopService.tryOnWear(glasses);
        shopService.tryOnWear(pants);
        shopService.tryOnWear(outerwear);
        shopService.tryOnWear(shirt);
        shopService.goToCashier(shoppingCart);
        shopService.finishWork(shop);

        try {
            buyer.buy(shoppingCart);
        } catch (BuyerLocatedException e) {
            LOGGER.debug(e.getMessage());
        } finally {
            LOGGER.debug("Operation is completed");
        }
        shoppingCart.printCheck(shop, cashier);
        Address<Integer> shopAddress2 = new Address<>("Mayakovskogo", 25);
        ControlClass.changeAddress(shop, shopAddress2);
        ControlClass.salaryChange(salary, cashier, 200.00);
        ControlClass.setDiscount(discount, pants, 20);

        try {
            buyer.setMoney(-700.00);
        } catch (BuyerDataException e) {
            LOGGER.debug(e.getMessage());
        } catch (Exception e) {
            LOGGER.debug("Other exception");
        } finally {
            LOGGER.debug("Operation is completed");
        }

        String filePath = "src/main/resources/article.txt";
        WordCount wordCount = new WordCount(filePath);
        try {
            wordCount.calculateWords(symbolDeleter,mapSorter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}