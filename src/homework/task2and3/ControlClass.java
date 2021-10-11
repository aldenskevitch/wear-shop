package homework.task2and3;

import homework.task2and3.shop.Position;
import homework.task2and3.shop.catalog.Product;

public class ControlClass {

    public static void setDiscount(Product product, int percent) {
        product.setProductCost(product.getProductCost() / 100 * (100 - percent));
    }

    public static void changeAddress(Building building, String newStreet, String newHouseNumber) {
        System.out.print(building.getClass().getSimpleName() + " object address " + building.getAddress().toString() + " has been changed to: ");
        building.getAddress().setStreet(newStreet);
        building.getAddress().setHouseNumber(newHouseNumber);
        System.out.println(building.getAddress().toString());
    }

    public static void salaryChange(Position position, double salary) {
        if (salary > 0) {
            position.increaseSalary(salary);
            System.out.println("Salary increased by: " + salary);
        } else if (salary < 0) {
            position.decreaseSalary(salary);
            System.out.println("Salary decreased by: " + salary);
        }
        System.out.println("Salary value = " + position.getSalary());
    }
}