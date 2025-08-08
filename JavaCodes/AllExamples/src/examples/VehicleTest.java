package examples;

import java.util.Scanner;


abstract class Vehicle {
    abstract void startEngine(); 
}


class Auto extends Vehicle {
    @Override
    void startEngine() {
        System.out.println("Auto engine started with key ignition.");
    }
}


class Bike extends Vehicle {
    @Override
    void startEngine() {
        System.out.println("Bike engine started with self-start.");
    }
}


public class VehicleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle vehicle;

        System.out.println("Choose a vehicle to start:");
        System.out.println("1. Auto");
        System.out.println("2. Bike");
        
        int choice = scanner.nextInt();

        if (choice == 1) {
            vehicle = new Auto();
        } else if (choice == 2) {
            vehicle = new Bike();
        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }

        vehicle.startEngine();
        scanner.close();
    }
}
