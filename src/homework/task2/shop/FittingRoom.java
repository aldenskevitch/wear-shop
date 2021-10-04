package homework.task2.shop;

import homework.task2.shop.catalog.Wear;

public class FittingRoom {

    public String tryOn(Wear wearType1) {
        return "Trying on " + wearType1.getType() + "...";
    }

    public String tryOn(Wear wearType1, Wear wearType2) {
        return "Trying on " + wearType1.getType() + "with" + wearType2.getType();
    }

    public String tryOn(Wear wearType1, Wear wearType2, Wear wearType3) {
        return "Trying on " + wearType1.getType() + "with" + wearType2.getType() + " and" + wearType3.getType();
    }
}
