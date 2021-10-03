package homework.task2.shop;


import homework.task2.shop.catalog.legs.Pants;
import homework.task2.shop.catalog.outerwear.Outerwear;
import homework.task2.shop.catalog.shirt.Shirt;

public class FittingRoom {

    public String tryOn(Pants pants) {
        return "Trying on pants...";
    }

    public String tryOn(Outerwear outerwear) {
        return "Trying on outerwear...";
    }

    public String tryOn(Shirt shirt) {
        return "Trying on shirt...";
    }

}
