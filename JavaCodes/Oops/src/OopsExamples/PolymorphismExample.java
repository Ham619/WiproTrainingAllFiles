package OopsExamples;


class Animal {
 public void sound() {
     System.out.println("Animal makes a sound");
 }
}

class Dog extends Animal {
 @Override
 public void sound() {
     System.out.println("Dog barks");
 }
}

class Cat extends Animal {
 @Override
 public void sound() {
     System.out.println("Cat meows");
 }
}

//Compile-time (method overloading)
class Calculator {
 public int add(int a, int b) {
     return a + b;
 }

 public double add(double a, double b) {
     return a + b;
 }
}

public class PolymorphismExample {
 public static void main(String[] args) {
     // Runtime 
     Animal a1 = new Dog();
     Animal a2 = new Cat();

     a1.sound(); 
     a2.sound();  

     System.out.println();

     // Compile-time 
     Calculator calc = new Calculator();
     System.out.println("Sum of ints: " + calc.add(5, 3));
     System.out.println("Sum of doubles: " + calc.add(2.5, 4.3));
 }
}
