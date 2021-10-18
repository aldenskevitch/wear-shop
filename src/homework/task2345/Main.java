package homework.task2345;

import homework.task2345.shop.*;
import homework.task2345.shop.catalog.Glasses;
import homework.task2345.shop.catalog.MenWear;
import homework.task2345.shop.catalog.Wear;
import homework.task2345.shop.catalog.parameters.FabricParameter;
import homework.task2345.shop.catalog.parameters.Size;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Main {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {

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
        Buyer buyer = new Buyer(sizes, 600.00);
        Size size = new Size(buyer);

        FabricParameter pantsFabric = new FabricParameter("gray", "jeans");
        FabricParameter outerwearFabric = new FabricParameter("brown", "leather");
        FabricParameter shirtFabric = new FabricParameter("gray", "cotton");

        Wear pants = new MenWear("pants", 100.00, size, pantsFabric);
        Wear outerwear = new MenWear("outerwear", 200.00, size, outerwearFabric);
        Wear shirt = new MenWear("shirt", 50.00, size, shirtFabric);
        Glasses glasses = new Glasses("SunGlasses", 50.00);

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
        if (buyer.selectPants(pants)) {
            LOGGER.debug(fitting.tryOn(pants));
            wears.add(pants);
        }
        if (buyer.selectOuterwear(outerwear)) {
            LOGGER.debug(fitting.tryOn(outerwear));
            wears.add(outerwear);
        }
        if (buyer.selectShirt(shirt)) {
            LOGGER.debug(fitting.tryOn(shirt));
            wears.add(shirt);
        }
        LOGGER.debug(fitting.tryOn(pants, shirt, outerwear));

        shoppingCart.addWears(wears);
        shoppingCart.calculatedTotalPrice();

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
        ControlClass.salaryChange(cashier, 200);
        ControlClass.setDiscount(pants, 20);

        try {
            buyer.setMoney(-700.00);
        } catch (BuyerDataException e) {
            LOGGER.debug(e.getMessage());
        } catch (Exception e) {
            LOGGER.debug("Other exception");
        } finally {
            LOGGER.debug("Operation is completed");
        }
    }
}