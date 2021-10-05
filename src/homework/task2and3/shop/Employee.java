package homework.task2and3.shop;

public class Employee {

    private String name;
    private String surname;
    private Position position;

    public Employee(String name, String surname, Position position) {
        this.name = name;
        this.surname = surname;
        this.position = position;
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
}