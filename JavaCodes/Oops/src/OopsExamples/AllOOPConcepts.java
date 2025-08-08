package OopsExamples;

//AllOOPConcepts.java

//Abstraction using abstract class
abstract class Employee {
 private String name;
 private int id;

 
 public Employee(String name, int id) {
     this.name = name;
     this.id = id;
 }

 
 public String getName() {
     return name;
 }

 public int getId() {
     return id;
 }

 // Abstract method 
 public abstract double calculateSalary();

 public void displayInfo() {
     System.out.println("Employee ID: " + id);
     System.out.println("Name: " + name);
 }
}

//Inheritance 
class FullTimeEmployee extends Employee {
 private double monthlySalary;

 public FullTimeEmployee(String name, int id, double monthlySalary) {
     super(name, id);
     this.monthlySalary = monthlySalary;
 }

 @Override
 public double calculateSalary() {
     return monthlySalary;
 }
}

//Inheritance 
class PartTimeEmployee extends Employee {
 private int hoursWorked;
 private double hourlyRate;

 public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
     super(name, id);
     this.hoursWorked = hoursWorked;
     this.hourlyRate = hourlyRate;
 }

 @Override
 public double calculateSalary() {
     return hoursWorked * hourlyRate;
 }
}

//Polymorphism example with method overloading
class SalaryCalculator {
 public double calculateBonus(double salary) {
     return salary * 0.10;
 }

 public double calculateBonus(double salary, double percentage) {
     return salary * (percentage / 100);
 }
}

public class AllOOPConcepts {
 public static void main(String[] args) {
     // Polymorphism 
     Employee emp1 = new FullTimeEmployee("Riya Kapoor", 101, 50000);
     Employee emp2 = new PartTimeEmployee("Aman Joshi", 102, 120, 250);

     // Display info
     emp1.displayInfo();
     System.out.println("Salary: ₹" + emp1.calculateSalary());
     System.out.println();

     emp2.displayInfo();
     System.out.println("Salary: ₹" + emp2.calculateSalary());
     System.out.println();

     // Method Overloading - Polymorphism
     SalaryCalculator calc = new SalaryCalculator();
     double bonus1 = calc.calculateBonus(emp1.calculateSalary());
     double bonus2 = calc.calculateBonus(emp2.calculateSalary(), 15);

     System.out.println(emp1.getName() + "'s Bonus (10%): ₹" + bonus1);
     System.out.println(emp2.getName() + "'s Bonus (15%): ₹" + bonus2);
 }
}
