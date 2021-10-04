package homework.task2.shop;

import homework.task2.Buyer;
import homework.task2.shop.catalog.Wear;

import java.time.LocalDateTime;
import java.util.Date;

import static homework.task2.shop.Department.increaseProceeds;

public class ShoppingCart {

    private double totalPrice;
    private Wear[] wears;

    public void add(Wear... wears) {
        this.wears = new Wear[wears.length];
        this.wears = wears;
        for (Wear wear : this.wears) {
            this.totalPrice += wear.getPrice();
        }
    }

    public void buy(Buyer buyer) {
        if (this.totalPrice < buyer.getMoney()) {
            System.out.println("Purchase made...");
            buyer.setMoney(this.totalPrice);
            System.out.println("Balance at the moment " + new Date() + "....  " + buyer.getMoney());
            increaseProceeds(totalPrice);
        } else {
            System.out.println("Not enough money...");
        }
    }

    public void printCheck(Shop shop) {
        System.out.println("\n" + shop.getName());
        System.out.println(shop.getAddress());
        System.out.println("Seller:" + shop.getDepartment().getPosition().getEmployee().getName() + shop.getDepartment().getPosition().getEmployee().getSurname());
        System.out.println("Date: " + LocalDateTime.now().toLocalDate());
        System.out.println("Time: " + LocalDateTime.now().toLocalTime().withNano(0));
        for (int i = 0; i < wears.length; i++) {
            System.out.println((i + 1) + ". ......" + wears[i].getPrice());
        }
        System.out.println("Total...." + totalPrice);
    }

    public void printCheck() {
        System.out.println("Date: " + LocalDateTime.now().toLocalDate());
        System.out.println("Time: " + LocalDateTime.now().toLocalTime().withNano(0));
        for (int i = 0; i < wears.length; i++) {
            System.out.println((i + 1) + ". ......" + wears[i].getPrice());
        }
        System.out.println("Total...." + totalPrice);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}