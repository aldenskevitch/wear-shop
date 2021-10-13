package homework.task2345.shop;

import homework.task2345.Cashier;
import homework.task2345.shop.catalog.Product;
import homework.task2345.shop.catalog.Wear;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.Arrays;

public class ShoppingCart implements Sellable {

    private static final Logger LOGGER = LogManager.getLogger();

    private double totalPrice;
    private Wear[] wears;

    public void add(Wear... wears) {
        this.wears = wears;
        for (Product wear : this.wears) {
            this.totalPrice += wear.getProductCost();
        }
    }

    public void printCheck(Shop shop, Cashier cashier) {
        LOGGER.debug("\n" + shop.getShopName());
        LOGGER.debug(shop.getAddress().getStreet() + " " + shop.getAddress().getHouseNumber());
        LOGGER.debug("Seller:" + shop.getDepartment().getEmployee(cashier).getName() + shop.getDepartment().getEmployee(cashier).getSurname());
        LOGGER.debug("Date: " + LocalDateTime.now().toLocalDate());
        LOGGER.debug("Time: " + LocalDateTime.now().toLocalTime().withNano(0));
        for (int i = 0; i < wears.length; i++) {
            LOGGER.debug((i + 1) + ". ......" + wears[i].getProductCost());
        }
        LOGGER.debug("Total...." + totalPrice + "\n\n\n");
    }

    @Override
    public void printCheck() {
        LOGGER.debug("Date: " + LocalDateTime.now().toLocalDate());
        LOGGER.debug("Time: " + LocalDateTime.now().toLocalTime().withNano(0));
        for (int i = 0; i < wears.length; i++) {
            LOGGER.debug((i + 1) + ". ......" + wears[i].getProductCost());
        }
        LOGGER.debug("Total...." + totalPrice);
    }

    @Override
    public String toString() {
        return "Total price: " + totalPrice + " for " + Arrays.toString(wears);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}