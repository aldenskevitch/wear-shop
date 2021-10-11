package homework.task2and3;

import homework.task2and3.shop.Position;

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