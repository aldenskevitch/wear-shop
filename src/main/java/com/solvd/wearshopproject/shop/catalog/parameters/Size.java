package com.solvd.wearshopproject.shop.catalog.parameters;

import com.solvd.wearshopproject.Buyer;

import java.util.Map;
import java.util.Objects;

public class Size {

    private Map<String, Integer> size;

    public Size(Buyer buyer) {
        this.size = buyer.getSizes();
    }

    @Override
    public String toString() {
        return "Size{" +
                "size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Size size1 = (Size) o;
        return Objects.equals(size, size1.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    public Map<String, Integer> getSize() {
        return size;
    }

    public void setSize(Map<String, Integer> size) {
        this.size = size;
    }
}