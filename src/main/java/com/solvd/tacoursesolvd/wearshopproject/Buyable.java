package com.solvd.tacoursesolvd.wearshopproject;

import com.solvd.tacoursesolvd.wearshopproject.shop.Shop;
import com.solvd.tacoursesolvd.wearshopproject.shop.ShoppingCart;

public interface Buyable {

    void comeToShop(Shop shop) throws ShopTimeException;

    void leaveShop(Shop shop);

    void buy(ShoppingCart shoppingCart) throws BuyerDataException;

}