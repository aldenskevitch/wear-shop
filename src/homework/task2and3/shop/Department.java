package homework.task2and3.shop;

import java.util.Objects;

public class Department {

    private static double proceeds = 0;

    private String nameDepartment;
    private Employee employee;

    public Department(String nameDepartment, Employee employee) {
        this.nameDepartment = nameDepartment;
        this.employee = employee;
    }

    public static double increaseProceeds(double value) {
        proceeds += value;
        return proceeds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return nameDepartment.equals(that.nameDepartment) && employee.equals(that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameDepartment, employee);
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}