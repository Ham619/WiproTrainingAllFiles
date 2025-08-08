package Types;

public class Circle {
    static final double PI = 3.1416;

    void calculateArea(double radius) {
        double area = PI * radius * radius;
        System.out.println("Area: " + area);
    }

    public static void main(String[] args) {
        new Circle().calculateArea(5);
    }
}

