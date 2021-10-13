package homework.task2345.shop;

import java.util.Arrays;
import java.util.Objects;

public class Department {

    private static double proceeds = 0;

    private String nameDepartment;
    private Employee[] employees;

    public Department(String nameDepartment, Employee... employees) {
        this.nameDepartment = nameDepartment;
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        this.employees = Arrays.copyOf(this.employees, this.employees.length + 1);
        this.employees[this.employees.length - 1] = employee;
    }

    public static double increaseProceeds(double value) {
        proceeds += value;
        return proceeds;
    }

    public Employee getEmployee(Position position) {
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i].getPosition().equals(position))
                return employees[i];
        }
        return null;
    }

    @Override
    public String toString() {
        return nameDepartment + "Employees: " + Arrays.toString(employees);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return nameDepartment.equals(that.nameDepartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameDepartment);
    }

    public static double getProceeds() {
        return proceeds;
    }

    public static void setProceeds(double proceeds) {
        Department.proceeds = proceeds;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee... employees) {
        this.employees = employees;
    }
}