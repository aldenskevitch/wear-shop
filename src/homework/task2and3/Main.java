package homework.task2and3;

import homework.task2and3.shop.*;
import homework.task2and3.shop.catalog.MenWear;
import homework.task2and3.shop.catalog.parameters.FabricParameter;
import homework.task2and3.shop.catalog.parameters.Size;

import java.util.Date;

class Main {

    public static void main(String[] args) {
        Date date = new Date();

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

        MenWear pants = new MenWear("pants", 100.00, size, pantsFabric);
        MenWear outerwear = new MenWear("outerwear", 200.00, size, outerwearFabric);
        MenWear shirt = new MenWear("shirt", 50.00, size, shirtFabric);

        FittingRoom fitting = new FittingRoom();
        ShoppingCart shoppingCart = new ShoppingCart();

        System.out.println("Current date and time: " + date);

        if (Buyer.selectPants(pants)) {
            System.out.println(fitting.tryOn(pants));
        }
        if (Buyer.selectOuterwear(outerwear)) {
            System.out.println(fitting.tryOn(outerwear));
        }
        if (Buyer.selectShirt(shirt)) {
            System.out.println(fitting.tryOn(shirt));
        }
        System.out.println(fitting.tryOn(pants, shirt, outerwear));

        shoppingCart.add(pants, outerwear, shirt);
        shoppingCart.buy(buyer);
        shoppingCart.printCheck(shop);

        ControlClass.controlBuilding(shop);
        ControlClass.controlPosition(cashier);
        ControlClass.controlProduct(pants);
    }
}