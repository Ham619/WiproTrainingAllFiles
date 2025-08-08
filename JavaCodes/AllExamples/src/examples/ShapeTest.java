package examples;

import java.util.Scanner;


abstract class Shape {
    abstract double area();
}


class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}


class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}


public class ShapeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shape shape;

        System.out.print("Enter the shape (circle/rectangle): ");
        String choice = scanner.nextLine().toLowerCase();

        switch (choice) {
            case "circle":
                System.out.print("Enter radius: ");
                double radius = scanner.nextDouble();
                shape = new Circle(radius);
                System.out.println("Circle Area: " + shape.area());
                break;

            case "rectangle":
                System.out.print("Enter length: ");
                double length = scanner.nextDouble();
                System.out.print("Enter width: ");
                double width = scanner.nextDouble();
                shape = new Rectangle(length, width);
                System.out.println("Rectangle Area: " + shape.area());
                break;

            default:
                System.out.println("Invalid shape type entered.");
        }

        scanner.close();
    }
}
