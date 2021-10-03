package homework.task2.shop.catalog.outerwear;

import homework.task2.shop.catalog.parameters.FabricParameters;
import homework.task2.shop.catalog.parameters.Sizes;

public class Outerwear {
    private Sizes sizes;
    private FabricParameters fabric;
    private double price;

    public Outerwear(Sizes sizes, FabricParameters fabric, double price) {
        this.sizes = sizes;
        this.fabric = fabric;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
