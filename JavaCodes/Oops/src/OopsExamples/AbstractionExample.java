package OopsExamples;



abstract class Vehicle {
 
 public abstract void start();

 
 public void fuelType() {
     System.out.println("Most vehicles use petrol or diesel.");
 }
}

class Car extends Vehicle {
 @Override
 public void start() {
     System.out.println("Car starts with a key or push-button.");
 }
}

class Bike extends Vehicle {
 @Override
 public void start() {
     System.out.println("Bike starts with a kick or self-start.");
 }
}

public class AbstractionExample {
 public static void main(String[] args) {
     Vehicle v1 = new Car();
     Vehicle v2 = new Bike();

     v1.start();       
     v1.fuelType();

     System.out.println();

     v2.start();       
     v2.fuelType();
 }
}
