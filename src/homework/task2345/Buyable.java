package homework.task2345;

import homework.task2345.shop.Shop;
import homework.task2345.shop.ShoppingCart;

public interface Buyable {

    void comeToShop(Shop shop) throws ShopTimeException;

    void leaveShop(Shop shop);

    void buy(ShoppingCart shoppingCart) throws BuyerDataException;

}