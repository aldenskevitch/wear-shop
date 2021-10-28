package com.solvd.wearshopproject.shop.catalog;

import com.solvd.wearshopproject.shop.catalog.parameters.FabricParameter;
import com.solvd.wearshopproject.shop.catalog.parameters.Size;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WomenWear extends Wear {

    private static final Logger LOGGER = LogManager.getLogger();

    public WomenWear(ProductTypes productName, Double productCost, Size size, FabricParameter fabric) {
        super(productName, size, fabric);
    }

    @Override
    public void doPrepareForSale() {
        LOGGER.debug("The women's wear is ready for sale");
    }

    @Override
    public String toString() {
        return "It is class WomenWear";
    }
}