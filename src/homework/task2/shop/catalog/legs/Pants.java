package homework.task2.shop.catalog.legs;

import homework.task2.shop.catalog.parameters.FabricParameters;
import homework.task2.shop.catalog.parameters.Sizes;

public class Pants {
    private Sizes sizes;
    private FabricParameters fabric;
    private double price;

    public Pants(Sizes sizes, FabricParameters fabric, double price) {
        this.sizes = sizes;
        this.fabric = fabric;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
