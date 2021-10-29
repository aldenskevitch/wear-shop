package com.solvd.wearshopproject;

import com.solvd.wearshopproject.shop.Address;
import com.solvd.wearshopproject.shop.Position;
import com.solvd.wearshopproject.shop.catalog.Product;
import com.solvd.wearshopproject.shop.catalog.Wear;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;


public class ControlClass<E> {

    private static final Logger LOGGER = LogManager.getLogger();

    public static Double setDiscount(BiFunction<Product, Integer, Double> discount, Product product, Integer percent) {
        LOGGER.debug(product.getProductType().getDescription() + " new price: " + discount.apply(product, percent));
        return discount.apply(product, percent);
    }

    public static void changeAddress(Building building, Address<?> address) {
        LOGGER.debug(building.getClass().getSimpleName() + " object address " + building.getAddresses().toString() + " has been changed to: ");
        building.setAddresses(address);
        LOGGER.debug(building.getAddresses().toString());
    }

    public static void salaryChange(BiConsumer<Position, Double> consumer, Position position, Double salary) {
        consumer.accept(position, salary);
        LOGGER.debug("Salary value = " + position.getSalary());
    }
}