package homework.task7;

import homework.task7.shop.Address;

import java.util.Objects;

public class Building {

    private String buildingType;
    private Address<?> addresses;

    public Building(Address<?> address) {
        this.addresses = address;
    }

    @Override
    public String toString() {
        return "Buildings located: " + addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return Objects.equals(buildingType, building.buildingType) && Objects.equals(addresses, building.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buildingType, addresses);
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public Address<?> getAddresses() {
        return addresses;
    }

    public void setAddresses(Address<?> addresses) {
        this.addresses = addresses;
    }
}