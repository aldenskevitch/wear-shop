package homework.task7.shop.catalog;

import java.util.List;
import java.util.Objects;

public class Basket<E extends Product> {

    private List<E> product;

    public List<E> getProduct() {
        return product;
    }

    public void setProduct(List<E> product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket<?> basket = (Basket<?>) o;
        return Objects.equals(product, basket.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }
}
