package homework.task2and3;

import homework.task2and3.shop.*;
import homework.task2and3.shop.catalog.Glasses;
import homework.task2and3.shop.catalog.MenWear;
import homework.task2and3.shop.catalog.Wear;
import homework.task2and3.shop.catalog.parameters.FabricParameter;
import homework.task2and3.shop.catalog.parameters.Size;

import java.util.Date;

class Main {

    public static void main(String[] args) {
        Date date = new Date();

        Consultant consultant = new Consultant(800.00);
        Cashier cashier = new Cashier(1000.00);
        Employee employee = new Employee("Ivan", "Ivanov", cashier);
        Department department = new Department("Sport wear", employee);
        Address shopAddress = new Address("Independence Avenue", "100");
        Shop shop = new Shop(shopAddress, "Trade object", "Clothes for all family", department);

        Buyer buyer = new Buyer(170, 80, 50, 600.00);
        Size size = new Size(buyer);
        FabricParameter pantsFabric = new FabricParameter("gray", "jeans");
        FabricParameter outerwearFabric = new FabricParameter("brown", "leather");
        FabricParameter shirtFabric = new FabricParameter("gray", "cotton");

        Wear pants = new MenWear("pants", 100.00, size, pantsFabric);
        Wear outerwear = new MenWear("outerwear", 200.00, size, outerwearFabric);
        Wear shirt = new MenWear("shirt", 50.00, size, shirtFabric);
        Glasses glasses = new Glasses("SunGlasses", 50.00);

        FittingRoom fitting = new FittingRoom();
        ShoppingCart shoppingCart = new ShoppingCart();

        System.out.println("Current date and time: " + date);

        if (buyer.selectPants(pants)) {
            System.out.println(fitting.tryOn(pants));
        }
        if (buyer.selectOuterwear(outerwear)) {
            System.out.println(fitting.tryOn(outerwear));
        }
        if (buyer.selectShirt(shirt)) {
            System.out.println(fitting.tryOn(shirt));
        }
        System.out.println(fitting.tryOn(pants, shirt, outerwear));

        shoppingCart.add(pants, outerwear, shirt);

        ShopService shopService = new ShopServiceImpl();
        shopService.startWork(shop);
        shopService.getConsultation(consultant);
        shopService.tryOnWear(glasses);
        shopService.tryOnWear(pants);
        shopService.tryOnWear(outerwear);
        shopService.tryOnWear(shirt);
        shopService.goToCashier(shoppingCart);
        shopService.finishWork(shop);

        buyer.buy(shoppingCart);
        shoppingCart.printCheck(shop, cashier);

        ControlClass.changeAddress(shop, "Mayakovskogo", "25");
        ControlClass.salaryChange(cashier, 200);
        ControlClass.setDiscount(pants, 20);
    }
}