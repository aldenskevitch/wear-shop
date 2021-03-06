package com.solvd.wearshopproject;

import com.solvd.wearshopproject.shop.Position;

public class Consultant extends Position implements Consultantable {

    public Consultant(Double salary) {
        super(salary);
        super.positionName = this.getClass().getSimpleName();
    }

    @Override
    public void advise() {
        System.out.println("Help with the choice...");
    }

    @Override
    public String toString() {
        return this.positionName;
    }
}