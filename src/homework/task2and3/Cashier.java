package homework.task2and3;

import homework.task2and3.shop.Position;

public class Cashier extends Position {

    public Cashier(Double salary) {
        super(salary);
    }

    public void doSellOut() {
        System.out.println("Done!");
    }

    @Override
    public String toString() {
        return "It is class Cashier";
    }
}
