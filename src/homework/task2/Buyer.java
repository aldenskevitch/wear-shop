package homework.task2;

import homework.task2.shop.catalog.Wear;

public class Buyer {

    private final int height;
    private final int chest;
    private final int waist;
    private double money;

    Buyer(int height, int chestSize, int waistSize, double money) {
        this.height = height;
        this.chest = chestSize;
        this.waist = waistSize;
        this.money = money;
    }

    public int getHeight() {
        return height;
    }

    public int getChest() {
        return chest;
    }

    public int getWaist() {
        return waist;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money -= money;
    }

    public static boolean selectPants(Wear pants) {
        boolean selected = pants.getPrice() < 150;
        if (selected) {
            System.out.println("Pants is selected");
        }
        return selected;
    }

    public static boolean selectOuterwear(Wear outerwear) {
        boolean selected = outerwear.getPrice() < 300;
        if (selected) {
            System.out.println("Outerwear is selected");
        }
        return selected;
    }

    public static boolean selectShirt(Wear shirt) {
        boolean selected = shirt.getPrice() < 100;
        if (selected) {
            System.out.println("Shirt is selected");
        }
        return selected;
    }
}

