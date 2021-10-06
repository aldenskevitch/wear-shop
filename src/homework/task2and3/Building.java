package homework.task2and3;

import homework.task2and3.shop.Address;

import java.util.Objects;

public class Building {

    protected String buildingType;
    protected Address address;

    public Building(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Building located: " + address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return address.equals(building.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
