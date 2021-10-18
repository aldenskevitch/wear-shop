package homework.task2345;

import homework.task2345.shop.Address;
import homework.task2345.shop.Position;
import homework.task2345.shop.catalog.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ControlClass<E> {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void setDiscount(Product product, int percent) {
        product.setProductCost(product.getProductCost() / 100 * (100 - percent));
    }

    public static void changeAddress(Building building, Address<?> address) {
        LOGGER.debug(building.getClass().getSimpleName() + " object address " + building.getAddresses().toString() + " has been changed to: ");
        building.setAddresses(address);
        LOGGER.debug(building.getAddresses().toString());
    }

    public static void salaryChange(Position position, double salary) {
        if (salary > 0) {
            position.increaseSalary(salary);
            System.out.println("Salary increased by: " + salary);
        } else if (salary < 0) {
            position.decreaseSalary(salary);
            System.out.println("Salary decreased by: " + salary);
        }
        LOGGER.debug("Salary value = " + position.getSalary());
    }
}