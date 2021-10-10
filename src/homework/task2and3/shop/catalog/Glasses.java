package homework.task2and3.shop.catalog;

public class Glasses extends Product implements TryableOn {

    public Glasses(String productName, Double productCost) {
        super(productName, productCost);
    }

    @Override
    public void doPrepareForSale() {
        System.out.println("The glasses is ready for sale");
    }

    @Override
    public void tryOn() {
        System.out.println("Trying on " + this.getProductName() + "...");
    }
}
