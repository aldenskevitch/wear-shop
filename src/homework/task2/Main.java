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
        Shop shop = new Shop("Clothing Store", "Independence Avenue 100", department);

        Buyer buyer = new Buyer();
        Size size = new Size(buyer);
        FabricParameter pantsFabric = new FabricParameter("gray", "jeans");
        FabricParameter outerwearFabric = new FabricParameter("brown", "leather");
        FabricParameter shirtFabric = new FabricParameter("gray", "cotton");

        Wear pants = new Wear("pants", size, pantsFabric, 100.00);
        Wear outerwear = new Wear("outerwear", size, outerwearFabric, 200.00);
        Wear shirt = new Wear("shirt", size, shirtFabric, 50.00);

        ClothesSet selectedClothes = new ClothesSet();
        FittingRoom fitting = new FittingRoom();
        ShoppingCart shoppingCart = new ShoppingCart();

        System.out.println("Current date and time: " + date);

        if (Buyer.selectPants(pants)) {
            selectedClothes.setPants(pants);
        }
        if (Buyer.selectOuterwear(outerwear)) {
            selectedClothes.setOuterwear(outerwear);
        }
        if (Buyer.selectShirt(shirt)) {
            selectedClothes.setShirt(shirt);
        }
        System.out.println(fitting.tryOn(pants));
        System.out.println(fitting.tryOn(pants, shirt));
        System.out.println(fitting.tryOn(pants, shirt, outerwear));

        shoppingCart.add(selectedClothes);
        shoppingCart.buy(selectedClothes, buyer);
        shoppingCart.printCheck(shop);
    }
}
