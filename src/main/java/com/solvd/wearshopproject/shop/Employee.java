package com.solvd.wearshopproject.shop;

import java.util.Objects;

public class Employee {

    private String name;
    private String surname;
    private Position position;

    public Employee(String name, String surname, Position position) {
        this.name = name;
        this.surname = surname;
        this.position = position;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name) && surname.equals(employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}