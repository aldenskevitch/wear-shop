package com.solvd.tacoursesolvd.wearshopproject.shop.catalog;

import com.solvd.tacoursesolvd.wearshopproject.shop.catalog.parameters.FabricParameter;
import com.solvd.tacoursesolvd.wearshopproject.shop.catalog.parameters.Size;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Wear extends Product implements TryableOn {

    private static final Logger LOGGER = LogManager.getLogger();

    private Size size;
    private FabricParameter fabric;

    public Wear(String productName, Double productCost, Size size, FabricParameter fabric) {
        super(productName, productCost);
        this.size = size;
        this.fabric = fabric;
    }

    @Override
    public void doPrepareForSale() {
        LOGGER.debug("The wear is ready for sale");
    }

    @Override
    public void tryOn() {
        LOGGER.debug("Trying on " + this.getProductName() + "...");
    }

    @Override
    public String toString() {
        return size.toString() + fabric.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Wear wear = (Wear) o;
        return size.equals(wear.size) && fabric.equals(wear.fabric);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size, fabric);
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public FabricParameter getFabric() {
        return fabric;
    }

    public void setFabric(FabricParameter fabric) {
        this.fabric = fabric;
    }
}