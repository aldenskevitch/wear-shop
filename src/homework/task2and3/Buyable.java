package homework.task2and3;

import homework.task2and3.shop.ShoppingCart;

public interface Buyable {
    void comeToShop(Buyer buyer);

    void leaveShop(Buyer buyer);

    void buy(ShoppingCart shoppingCart);
}
