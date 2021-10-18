package com.solvd.tacoursesolvd.homework.task7;

import com.solvd.tacoursesolvd.homework.task7.shop.Shop;
import com.solvd.tacoursesolvd.homework.task7.shop.ShoppingCart;
import com.solvd.tacoursesolvd.homework.task7.shop.catalog.Wear;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

import static com.solvd.tacoursesolvd.homework.task7.shop.Department.increaseProceeds;

public class Buyer implements WearSelectable, Buyable {

    private static final Logger LOGGER = LogManager.getLogger();

    private double money;
    private boolean isToShop;
    private Map<String, Integer> sizes;
    private List<Wear> wardrobe;

    public Buyer(Map<String, Integer> sizes, double money) {
        this.sizes = sizes;
        this.money = money;
    }

    @Override
    public boolean selectPants(Wear pants) {
        boolean selected = pants.getProductCost() < 150;
        if (selected) {
            LOGGER.debug("Pants is selected");
            this.wardrobe.add(pants);
        }
        return selected;
    }

    @Override
    public boolean selectOuterwear(Wear outerwear) {
        boolean selected = outerwear.getProductCost() < 300;
        if (selected) {
            LOGGER.debug("Outerwear is selected");
            this.wardrobe.add(outerwear);
        }
        return selected;
    }

    @Override
    public boolean selectShirt(Wear shirt) {
        boolean selected = shirt.getProductCost() < 100;
        if (selected) {
            LOGGER.debug("Shirt is selected");
            this.wardrobe.add(shirt);
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
    public void buy(ShoppingCart shoppingCart) {
        if (!this.isToShop) {
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
        return Double.compare(buyer.money, money) == 0 && isToShop == buyer.isToShop && sizes.equals(buyer.sizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, isToShop, sizes);
    }

    public double getMoney() {
        return money;
    }

    public boolean isToShop() {
        return isToShop;
    }

    public void setToShop(boolean toShop) {
        isToShop = toShop;
    }

    public Map<String, Integer> getSizes() {
        return sizes;
    }

    public void setSizes(Map<String, Integer> sizes) {
        this.sizes = sizes;
    }

    public void setMoney(double money) throws BuyerDataException {
        if (money < 0) {
            throw new BuyerDataException("Value less than zero");
        }
        this.money = this.money + money;
    }

    public List<Wear> getWardrobe() {
        return wardrobe;
    }

    public void setWardrobe(List<Wear> wardrobe) {
        this.wardrobe = wardrobe;
    }
}