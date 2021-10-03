package homework.task2;

import homework.task2.shop.catalog.legs.Pants;
import homework.task2.shop.catalog.outerwear.Outerwear;
import homework.task2.shop.catalog.shirt.Shirt;

public class Buyer {
    protected final static int HEIGHT = 170;
    protected final static int CHEST = 80;
    protected final static int WAIST = 50;
    protected static double money = 600.00;

    public static double getMoney() {
        return money;
    }

    public static void setMoney(double money) {
        Buyer.money = money;
    }

    public static boolean selectPants(Pants pants) {
        if (pants.getPrice() < 150) {
            System.out.println("Pants is selected");
            return true;
        }
        return false;
    }

    public static boolean selectOuterwear(Outerwear outerwear) {
        if (outerwear.getPrice() < 300) {
            System.out.println("Outerwear is selected");
            return true;
        }
        return false;
    }

    public static boolean selectShirt(Shirt shirt) {
        if (shirt.getPrice() < 100) {
            System.out.println("Shirt is selected");
            return true;
        }
        return false;
    }
}

