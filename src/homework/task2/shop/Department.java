package homework.task2.shop;

public class Department {

    private String name;
    private Position position;
    private static double proceeds;

    public Department(String name, Position position) {
        this.name = name;
        this.position=position;
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

    public void setPosition(Position position) {
        this.position = position;
    }

    public static double getProceeds() {
        return proceeds;
    }

    public static void setProceeds(double proceeds) {
        Department.proceeds = proceeds;
    }
}
