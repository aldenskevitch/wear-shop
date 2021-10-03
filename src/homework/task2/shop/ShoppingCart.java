package homework.task2.shop;

import homework.task2.Buyer;
import homework.task2.shop.catalog.legs.Pants;
import homework.task2.shop.catalog.outerwear.Outerwear;
import homework.task2.shop.catalog.shirt.Shirt;

import java.time.LocalDateTime;
import java.util.Date;

public class ShoppingCart {
    private double totalPrice;
    private Pants pants;
    private Shirt shirt;
    private Outerwear outerwear;


    public void add(Pants pants) {
        this.pants = pants;
        totalPrice = totalPrice + pants.getPrice();
        System.out.println("Pants is added...");
    }

    public void add(Outerwear outerwear) {
        this.outerwear = outerwear;
        totalPrice = totalPrice + outerwear.getPrice();
        System.out.println("Outerwear is added...");
    }

    public void add(Shirt shirt) {
        this.shirt = shirt;
        totalPrice = totalPrice + shirt.getPrice();
        System.out.println("Shirt is added...");
    }

    public void buy(ClothesSet clothesSet) {
        if (clothesSet.getTotalPrice() < Buyer.getMoney()) {
            System.out.println("Purchase made...");
            Buyer.setMoney(Buyer.getMoney() - clothesSet.getTotalPrice());
            System.out.println("Balance at the moment " + new Date() + "....  " + Buyer.getMoney());
        } else {
            System.out.println("Not enough money...");
        }
    }

    public void printCheck() {
        System.out.println("\n\nClothing store");
        System.out.println("Date: " + LocalDateTime.now().toLocalDate());
        System.out.println("Time: " + LocalDateTime.now().toLocalTime().withNano(0));
        System.out.println("1. ......" + pants.getPrice());
        System.out.println("2. ......" + outerwear.getPrice());
        System.out.println("3. ......" + shirt.getPrice());
        System.out.println("Total...." + totalPrice);

    }


}
