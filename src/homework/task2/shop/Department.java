package homework.task2.shop;

public class Department {

    private static double proceeds;

    private String name;
    private Position position;

    public Department(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public static double increaseProceeds(double value) {
        proceeds += value;
        return proceeds;
    }
}