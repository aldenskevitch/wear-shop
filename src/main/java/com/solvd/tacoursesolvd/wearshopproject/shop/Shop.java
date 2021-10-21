package com.solvd.tacoursesolvd.wearshopproject.shop;

import com.solvd.tacoursesolvd.wearshopproject.PublicBuilding;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Shop extends PublicBuilding implements Workable {

    private static final Logger LOGGER = LogManager.getLogger();

    private String shopName;
    private Department department;
    private boolean isWorking;

    public Shop(Address<?> address, String publicPurpose, String shopName, Department department) {
        super(address, publicPurpose);
        this.shopName = shopName;
        this.department = department;
    }

    @Override
    public void startWork() {
        LOGGER.debug("Shop is opened!");
        isWorking = true;
    }

    @Override
    public void finishWork() {
        LOGGER.debug("Shop is close.");
        isWorking = false;
    }

    @Override
    public String toString() {
        return shopName + " have " + department + "department";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Shop shop = (Shop) o;
        return shopName.equals(shop.shopName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shopName);
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }
}