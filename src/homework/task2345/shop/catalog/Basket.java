package homework.task2345.shop.catalog;

import java.util.Arrays;

public class Basket<E extends Product> {

    private E[] product;

    public E[] getProduct() {
        return product;
    }

    public void setProduct(E[] product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket<?> basket = (Basket<?>) o;
        return Arrays.equals(product, basket.product);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(product);
    }
}
