package homework.task2and3.shop;

import homework.task2and3.PublicBuilding;

import java.util.Objects;

public class Shop extends PublicBuilding {

    private String shopName;
    private Department department;

    public Shop(Address address, String publicPurpose, String shopName, Department department) {
        super(address, publicPurpose);
        this.shopName = shopName;
        this.department = department;
    }

    @Override
    public String toString() {
        return "It is class Shop";
    }

    @Override
    public void getStarted() {
        System.out.println("Shop is opened");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Shop shop = (Shop) o;
        return shopName.equals(shop.shopName) && department.equals(shop.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shopName, department);
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
}