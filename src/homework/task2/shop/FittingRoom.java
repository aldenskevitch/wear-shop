package homework.task2.shop;

import homework.task2.shop.catalog.Wear;

public class FittingRoom {

    public String tryOn(Wear firstWear) {
        return "Trying on " + firstWear.getType() + "...";
    }

    public String tryOn(Wear firstWear, Wear secondWear) {
        return "Trying on " + firstWear.getType() + "with" + secondWear.getType();
    }

    public String tryOn(Wear firstWear, Wear secondWear, Wear third) {
        return "Trying on " + firstWear.getType() + " with " + secondWear.getType() + " and " + third.getType();
    }
}
