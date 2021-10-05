package homework.task2and3.shop;

import java.util.Objects;

public class Position {

    protected Double salary;

    public Position(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "It is class Position";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return salary.equals(position.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary);
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}