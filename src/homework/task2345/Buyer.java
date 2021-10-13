package homework.task2345;

import homework.task2345.shop.Shop;
import homework.task2345.shop.ShoppingCart;
import homework.task2345.shop.catalog.Wear;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.Objects;

import static homework.task2345.shop.Department.increaseProceeds;

public class Buyer implements WearSelectable, Buyable {

    private static final Logger LOGGER = LogManager.getLogger();

    private int height;
    private int chest;
    private int waist;
    private double money;
    private boolean isToShop;

    public Buyer(int height, int chestSize, int waistSize, double money) {
        this.height = height;
        this.chest = chestSize;
        this.waist = waistSize;
        this.money = money;
    }

    @Override
    public boolean selectPants(Wear pants) {
        boolean selected = pants.getProductCost() < 150;
        if (selected) {
            LOGGER.debug("Pants is selected");
        }
        return selected;
    }

    @Override
    public boolean selectOuterwear(Wear outerwear) {
        boolean selected = outerwear.getProductCost() < 300;
        if (selected) {
            LOGGER.debug("Outerwear is selected");
        }
        return selected;
    }

    @Override
    public boolean selectShirt(Wear shirt) {
        boolean selected = shirt.getProductCost() < 100;
        if (selected) {
            LOGGER.debug("Shirt is selected");
        }
        return selected;
    }

    @Override
    public void comeToShop(Shop shop) throws ShopTimeException {
        if (!shop.isWorking()) {
            throw new ShopTimeException("Shop is close");
        }
        LOGGER.debug("You are in shop.");
        this.isToShop = true;
    }

    @Override
    public void leaveShop(Shop shop) {
        LOGGER.debug("You leave shop.");
        this.isToShop = false;
    }

    @Override
    public void buy(ShoppingCart shoppingCart) throws BuyerDataException, BuyerLocatedException {
        if (this.isToShop == false) {
            throw new BuyerLocatedException("Buyer is not in shop");
        }
        if (shoppingCart.getTotalPrice() > this.getMoney()) {
            throw new BuyerDataException("Not enough money...");
        } else {
            this.money = this.money - shoppingCart.getTotalPrice();
            increaseProceeds(shoppingCart.getTotalPrice());
            LOGGER.debug("Balance at the moment " + new Date() + "....  " + this.getMoney());
            LOGGER.debug("Purchase made...");
        }
    }

    @Override
    public String toString() {
        return "Buyer's money: " + money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return height == buyer.height && chest == buyer.chest && waist == buyer.waist && Double.compare(buyer.money, money) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, chest, waist, money);
    }

    public int getHeight() {
        return height;
    }

    public int getChest() {
        return chest;
    }

    public int getWaist() {
        return waist;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) throws BuyerDataException {
        if (money < 0) {
            throw new BuyerDataException("Value less than zero");
        }
        this.money = this.money + money;
    }
}