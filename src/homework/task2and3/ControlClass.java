package homework.task2and3;

import homework.task2and3.shop.Position;
import homework.task2and3.shop.catalog.Product;

public class ControlClass {

    public static void controlProduct(Product product) {
        System.out.println(product.toString());
    }

    public static void controlBuilding(Building building) {
        System.out.println(building.toString());
    }

    public static void controlPosition(Position position) {
        System.out.println(position.toString());
    }
}
