package homework.task2and3.shop;

import homework.task2and3.Buyer;
import homework.task2and3.Cashier;
import homework.task2and3.shop.catalog.Wear;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

import static homework.task2and3.shop.Department.increaseProceeds;

public class ShoppingCart {

    private double totalPrice;
    private Wear[] wears;

    public void add(Wear... wears) {
        this.wears = wears;
        for (Wear wear : this.wears) {
            this.totalPrice += wear.getProductCost();
        }
    }

    public void buy(Buyer buyer) {
        if (this.totalPrice < buyer.getMoney()) {
            System.out.println("Purchase made...");
            buyer.setMoney(-this.totalPrice);
            System.out.println("Balance at the moment " + new Date() + "....  " + buyer.getMoney());
            increaseProceeds(totalPrice);
        } else {
            System.out.println("Not enough money...");
        }
    }

    public void printCheck(Shop shop, Cashier cashier) {
        System.out.println("\n" + shop.getShopName());
        System.out.println(shop.getAddress().getStreet() + " " + shop.getAddress().getHouseNumber());
        System.out.println("Seller:" + shop.getDepartment().getEmployee(cashier).getName() + shop.getDepartment().getEmployee(cashier).getSurname());
        System.out.println("Date: " + LocalDateTime.now().toLocalDate());
        System.out.println("Time: " + LocalDateTime.now().toLocalTime().withNano(0));
        for (int i = 0; i < wears.length; i++) {
            System.out.println((i + 1) + ". ......" + wears[i].getProductCost());
        }
        System.out.println("Total...." + totalPrice + "\n\n\n");
    }

    public void printCheck() {
        System.out.println("Date: " + LocalDateTime.now().toLocalDate());
        System.out.println("Time: " + LocalDateTime.now().toLocalTime().withNano(0));
        for (int i = 0; i < wears.length; i++) {
            System.out.println((i + 1) + ". ......" + wears[i].getProductCost());
        }
        System.out.println("Total...." + totalPrice);
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