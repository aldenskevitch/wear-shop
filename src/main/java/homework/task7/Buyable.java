package homework.task7;

import homework.task7.shop.Shop;
import homework.task7.shop.ShoppingCart;

public interface Buyable {

    void comeToShop(Shop shop) throws ShopTimeException;

    void leaveShop(Shop shop);

    void buy(ShoppingCart shoppingCart) throws BuyerDataException;

}