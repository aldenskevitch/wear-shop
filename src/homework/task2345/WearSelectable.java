package homework.task2345;

import homework.task2345.shop.catalog.Wear;

public interface WearSelectable {

    boolean selectPants(Wear pants);

    boolean selectOuterwear(Wear outerwear);

    boolean selectShirt(Wear shirt);

}