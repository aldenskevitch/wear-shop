package homework.task2.shop;

import homework.task2.shop.catalog.Wear;

public class ClothesSet {

    private Wear pants;
    private Wear shirt;
    private Wear outerwear;

    public Wear getPants() {
        return pants;
    }

    public void setPants(Wear pants) {
        this.pants = pants;
    }

    public Wear getShirt() {
        return shirt;
    }

    public void setShirt(Wear shirt) {
        this.shirt = shirt;
    }

    public Wear getOuterwear() {
        return outerwear;
    }

    public void setOuterwear(Wear outerwear) {
        this.outerwear = outerwear;
    }

    public double getTotalPrice() {
        return pants.getPrice() + shirt.getPrice() + outerwear.getPrice();
    }
}
