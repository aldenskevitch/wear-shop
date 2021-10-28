package com.solvd.wearshopproject.shop.catalog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Glasses extends Product implements TryableOn {

    private static final Logger LOGGER = LogManager.getLogger();

    public Glasses(ProductTypes productName) {
        super(productName);
    }

    @Override
    public void doPrepareForSale() {
        LOGGER.debug("The glasses is ready for sale");
    }

    @Override
    public void tryOn() {
        LOGGER.debug("Trying on " + this.getProductName() + "...");
    }
}