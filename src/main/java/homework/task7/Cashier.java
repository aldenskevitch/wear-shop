package homework.task7;

import homework.task7.shop.Position;

public class Cashier extends Position {

    public Cashier(Double salary) {
        super(salary);
        super.positionName = this.getClass().getSimpleName();
    }

    public void doSellOut() {
        System.out.println("Done!");
    }

    @Override
    public String toString() {
        return this.positionName;
    }
}