package homework.task2and3.shop.catalog;

import homework.task2and3.shop.catalog.parameters.FabricParameter;
import homework.task2and3.shop.catalog.parameters.Size;

public class MenWear extends Wear {

    public MenWear(String productName, Double productCost, Size size, FabricParameter fabric) {
        super(productName, productCost, size, fabric);
    }

    @Override
    public void doPrepareForSale() {
        System.out.println("The men's wear is ready for sale");
    }

    @Override
    public String toString() {
        return "It is class MenWear";
    }
}
