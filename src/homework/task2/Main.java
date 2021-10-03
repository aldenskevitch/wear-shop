package homework.task2;

import homework.task2.shop.ClothesSet;
import homework.task2.shop.FittingRoom;
import homework.task2.shop.ShoppingCart;
import homework.task2.shop.catalog.legs.Pants;
import homework.task2.shop.catalog.outerwear.Outerwear;
import homework.task2.shop.catalog.parameters.FabricParameters;
import homework.task2.shop.catalog.parameters.Sizes;
import homework.task2.shop.catalog.shirt.Shirt;

import java.util.Date;

class Main {
    public static void main(String[] args) {
        Date date = new Date();
        Sizes sizes = new Sizes(Buyer.HEIGHT, Buyer.CHEST, Buyer.WAIST);
        FabricParameters pantsFabric = new FabricParameters("gray", "jeans");
        FabricParameters outerwearFabric = new FabricParameters("brown", "leather");
        FabricParameters shirtFabric = new FabricParameters("gray", "cotton");

        Pants pants = new Pants(sizes, pantsFabric, 100.00);
        Outerwear outerwear = new Outerwear(sizes, outerwearFabric, 200.00);
        Shirt shirt = new Shirt(sizes, shirtFabric, 50.00);

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
        System.out.println(fitting.tryOn(outerwear));
        System.out.println(fitting.tryOn(shirt));

        shoppingCart.add(pants);
        shoppingCart.add(outerwear);
        shoppingCart.add(shirt);
        shoppingCart.buy(selectedClothes);
        shoppingCart.printCheck();
    }
}
