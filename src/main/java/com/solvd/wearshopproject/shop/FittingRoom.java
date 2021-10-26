package com.solvd.wearshopproject.shop;

import com.solvd.wearshopproject.shop.catalog.Wear;

public class FittingRoom {

    public String tryOn(Wear firstWear) {
        return "Trying on " + firstWear.getProductName() + "...";
    }

    public String tryOn(Wear firstWear, Wear secondWear) {
        return "Trying on " + firstWear.getProductName() + "with" + secondWear.getProductName();
    }

    public String tryOn(Wear firstWear, Wear secondWear, Wear third) {
        return "Trying on " + firstWear.getProductName() + " with " + secondWear.getProductName() + " and " + third.getProductName();
    }
}