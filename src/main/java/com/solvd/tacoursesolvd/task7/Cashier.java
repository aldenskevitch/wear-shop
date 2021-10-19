package com.solvd.tacoursesolvd.task7;

import com.solvd.tacoursesolvd.task7.shop.Position;

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