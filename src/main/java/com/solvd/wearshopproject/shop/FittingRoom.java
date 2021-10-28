package com.solvd.wearshopproject.shop;

import com.solvd.wearshopproject.shop.catalog.Wear;

public class FittingRoom {

    public String tryOn(Wear firstWear) {
        return "Trying on " + firstWear.getProductType() + "...";
    }

    public String tryOn(Wear firstWear, Wear secondWear) {
        return "Trying on " + firstWear.getProductType() + "with" + secondWear.getProductType();
    }

    public String tryOn(Wear firstWear, Wear secondWear, Wear third) {
        return "Trying on " + firstWear.getProductType() + " with " + secondWear.getProductType() + " and " + third.getProductType();
    }
}