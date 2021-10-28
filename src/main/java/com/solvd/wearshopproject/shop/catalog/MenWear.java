package com.solvd.wearshopproject.shop.catalog;

import com.solvd.wearshopproject.shop.catalog.parameters.FabricParameter;
import com.solvd.wearshopproject.shop.catalog.parameters.Size;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MenWear extends Wear {

    private static final Logger LOGGER = LogManager.getLogger();

    public MenWear(ProductTypes productName, Size size, FabricParameter fabric) {
        super(productName, size, fabric);
    }

    @Override
    public void doPrepareForSale() {
        LOGGER.debug("The men's wear is ready for sale");
    }

    @Override
    public String toString() {
        return "It is class MenWear";
    }
}