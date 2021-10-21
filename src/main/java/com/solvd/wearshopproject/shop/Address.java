package com.solvd.tacoursesolvd.wearshopproject.shop;

import java.util.Objects;

public class Address<T> {

    private String street;
    private T houseNumber;

    public Address(String street, T houseNumber) {
        this.street = street;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return street + " " + houseNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address<?> address = (Address<?>) o;
        return Objects.equals(street, address.street) && Objects.equals(houseNumber, address.houseNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, houseNumber);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public T getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(T houseNumber) {
        this.houseNumber = houseNumber;
    }
}

