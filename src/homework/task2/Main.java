package homework.task2;

import homework.task2.shop.*;
import homework.task2.shop.catalog.Wear;
import homework.task2.shop.catalog.parameters.FabricParameter;
import homework.task2.shop.catalog.parameters.Size;

import java.util.Date;

class Main {

    public static void main(String[] args) {
        Date date = new Date();
        Employee employee = new Employee("Ivan", "Ivanov");
        Position position = new Position("cashier", employee);
        Department department = new Department("Men's clothing", position);
        Address shopAddress = new Address("Independence Avenue", "100");
        Shop shop = new Shop("Clothing Store", shopAddress, department);

        Buyer buyer = new Buyer(170, 80, 50, 600.00);
        Size size = new Size(buyer);
        FabricParameter pantsFabric = new FabricParameter("gray", "jeans");
        FabricParameter outerwearFabric = new FabricParameter("brown", "leather");
        FabricParameter shirtFabric = new FabricParameter("gray", "cotton");

        Wear pants = new Wear("pants", size, pantsFabric, 100.00);
        Wear outerwear = new Wear("outerwear", size, outerwearFabric, 200.00);
        Wear shirt = new Wear("shirt", size, shirtFabric, 50.00);

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
    }
}
