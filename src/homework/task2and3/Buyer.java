package homework.task2and3;

import homework.task2and3.shop.catalog.Wear;

public class Buyer {

    private int height;
    private int chest;
    private int waist;
    private double money;

    public Buyer(int height, int chestSize, int waistSize, double money) {
        this.height = height;
        this.chest = chestSize;
        this.waist = waistSize;
        this.money = money;
    }

    public static boolean selectPants(Wear pants) {
        boolean selected = pants.getProductCost() < 150;
        if (selected) {
            System.out.println("Pants is selected");
        }
        return selected;
    }

    public static boolean selectOuterwear(Wear outerwear) {
        boolean selected = outerwear.getProductCost() < 300;
        if (selected) {
            System.out.println("Outerwear is selected");
        }
        return selected;
    }

    public static boolean selectShirt(Wear shirt) {
        boolean selected = shirt.getProductCost() < 100;
        if (selected) {
            System.out.println("Shirt is selected");
        }
        return selected;
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
        this.money = this.money + money;
    }
}