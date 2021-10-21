package com.solvd.tacoursesolvd.wearshopproject.shop;

import java.util.Objects;

public class Position {

    protected Double salary;
    protected String positionName;

    public Position(Double salary) {
        this.salary = salary;
    }

    public void increaseSalary(Double value) {
        this.salary += value;
    }

    public void decreaseSalary(Double value) {
        this.salary -= value;
    }

    @Override
    public String toString() {
        return "Position " + positionName + ", salary: " + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return positionName.equals(position.positionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionName);
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}