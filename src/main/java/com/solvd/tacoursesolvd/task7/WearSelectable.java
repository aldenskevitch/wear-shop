package com.solvd.tacoursesolvd.task7;

import com.solvd.tacoursesolvd.task7.shop.catalog.Wear;

public interface WearSelectable {

    boolean selectPants(Wear pants);

    boolean selectOuterwear(Wear outerwear);

    boolean selectShirt(Wear shirt);

}