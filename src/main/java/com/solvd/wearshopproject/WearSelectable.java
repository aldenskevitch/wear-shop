package com.solvd.wearshopproject;

import com.solvd.wearshopproject.shop.catalog.Wear;

public interface WearSelectable {

    boolean selectPants(Wear pants);

    boolean selectOuterwear(Wear outerwear);

    boolean selectShirt(Wear shirt);

}