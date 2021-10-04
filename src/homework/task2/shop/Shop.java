package homework.task2.shop;

public class Shop {

    private String name;
    private String address;
    private Department department;
    private static double proceeds;

    public Shop(String name, String address, Department department) {
        this.name = name;
        this.address = address;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
