package homework.task2.shop;

import homework.task2.Buyer;

import java.time.LocalDateTime;
import java.util.Date;

public class ShoppingCart {

    private double totalPrice;
    private ClothesSet selectedClothes;

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ClothesSet getSelectedClothes() {
        return selectedClothes;
    }

    public void setSelectedClothes(ClothesSet selectedClothes) {
        this.selectedClothes = selectedClothes;
    }

    public void add(ClothesSet selectedClothes) {
        this.selectedClothes = selectedClothes;
        totalPrice = totalPrice + selectedClothes.getTotalPrice();
        System.out.println("Wear is added...");
    }

    public void buy(ClothesSet clothesSet, Buyer buyer) {
        if (clothesSet.getTotalPrice() < buyer.getMoney()) {
            System.out.println("Purchase made...");
            buyer.setMoney(buyer.getMoney() - clothesSet.getTotalPrice());
            System.out.println("Balance at the moment " + new Date() + "....  " + buyer.getMoney());
            Department.setProceeds(Department.getProceeds() + totalPrice);
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
        System.out.println("1. ......" + selectedClothes.getPants().getPrice());
        System.out.println("2. ......" + selectedClothes.getOuterwear().getPrice());
        System.out.println("3. ......" + selectedClothes.getShirt().getPrice());
        System.out.println("Total...." + totalPrice);
    }
    public void printCheck() {
        System.out.println("Date: " + LocalDateTime.now().toLocalDate());
        System.out.println("Time: " + LocalDateTime.now().toLocalTime().withNano(0));
        System.out.println("1. ......" + selectedClothes.getPants().getPrice());
        System.out.println("2. ......" + selectedClothes.getOuterwear().getPrice());
        System.out.println("3. ......" + selectedClothes.getShirt().getPrice());
        System.out.println("Total...." + totalPrice);
    }
}
