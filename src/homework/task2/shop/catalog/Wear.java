package homework.task2.shop.catalog;

import homework.task2.shop.catalog.parameters.FabricParameter;
import homework.task2.shop.catalog.parameters.Size;

public class Wear {

    private String type;
    private Size size;
    private FabricParameter fabric;
    private double price;

    public Wear(String type, Size size, FabricParameter fabric, double price) {
        this.type = type;
        this.size = size;
        this.fabric = fabric;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Size getSizes() {
        return size;
    }

    public void setSizes(Size size) {
        this.size = size;
    }

    public FabricParameter getFabric() {
        return fabric;
    }

    public void setFabric(FabricParameter fabric) {
        this.fabric = fabric;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
