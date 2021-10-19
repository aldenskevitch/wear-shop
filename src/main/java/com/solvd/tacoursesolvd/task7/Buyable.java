package com.solvd.tacoursesolvd.task7;

import com.solvd.tacoursesolvd.task7.shop.Shop;
import com.solvd.tacoursesolvd.task7.shop.ShoppingCart;

public interface Buyable {

    void comeToShop(Shop shop) throws ShopTimeException;

    void leaveShop(Shop shop);

    void buy(ShoppingCart shoppingCart) throws BuyerDataException;

}