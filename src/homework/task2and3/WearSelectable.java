package homework.task2and3;

import homework.task2and3.shop.catalog.Wear;

public interface WearSelectable {

    boolean selectPants(Wear pants);

    boolean selectOuterwear(Wear outerwear);

    boolean selectShirt(Wear shirt);

}