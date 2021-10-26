package com.solvd.wearshopproject.shop;

import java.util.List;
import java.util.Objects;

public class Department {

    private static double proceeds = 0;

    private String nameDepartment;
    private List<Employee> employees;
    private List<Position> positions;

    public Department(String nameDepartment, List<Employee> employees) {
        this.nameDepartment = nameDepartment;
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void addPosition(Position position) {
        this.positions.add(position);
    }


    public static double increaseProceeds(double value) {
        proceeds += value;
        return proceeds;
    }

    public Employee getEmployee(Position position) {
        for (Employee employee : this.employees) {
            if (employee.getPosition().equals(position))
                return employee;
        }
        return null;
    }

    @Override
    public String toString() {
        return nameDepartment + "Employees: " + employees;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }
}