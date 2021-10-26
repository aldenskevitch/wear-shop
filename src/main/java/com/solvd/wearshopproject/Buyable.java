package com.solvd.wearshopproject;

import com.solvd.wearshopproject.shop.Shop;
import com.solvd.wearshopproject.shop.ShoppingCart;

public interface Buyable {

    void comeToShop(Shop shop) throws ShopTimeException;

    void leaveShop(Shop shop);

    void buy(ShoppingCart shoppingCart) throws BuyerDataException;

}