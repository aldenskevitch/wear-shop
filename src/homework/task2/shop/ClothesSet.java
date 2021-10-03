package homework.task2.shop;

import homework.task2.shop.catalog.legs.Pants;
import homework.task2.shop.catalog.outerwear.Outerwear;
import homework.task2.shop.catalog.shirt.Shirt;

public class ClothesSet {
    private Pants pants;
    private Shirt shirt;
    private Outerwear outerwear;

    public void setPants(Pants pants) {
        this.pants = pants;
    }

    public void setShirt(Shirt shirt) {
        this.shirt = shirt;
    }

    public void setOuterwear(Outerwear outerwear) {
        this.outerwear = outerwear;
    }

    public double getTotalPrice() {
        return pants.getPrice() + shirt.getPrice() + outerwear.getPrice();
    }
}
