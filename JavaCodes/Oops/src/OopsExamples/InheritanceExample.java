package OopsExamples;


class Person {
 String name;
 int age;

 
 public Person(String name, int age) {
     this.name = name;
     this.age = age;
     System.out.println("Person constructor called.");
 }

 
 public void displayInfo() {
     System.out.println("Name: " + name + ", Age: " + age);
 }
}


class Employee extends Person {
 int employeeId;
 double salary;

 
 public Employee(String name, int age, int employeeId, double salary) {
     super(name, age); 
     this.employeeId = employeeId;
     this.salary = salary;
     System.out.println("Employee constructor called.");
 }

 
 @Override
 public void displayInfo() {
     super.displayInfo(); 
     System.out.println("Employee ID: " + employeeId + ", Salary: ₹" + salary);
 }
}


class Manager extends Employee {
 String department;

 public Manager(String name, int age, int employeeId, double salary, String department) {
     super(name, age, employeeId, salary);
     this.department = department;
     System.out.println("Manager constructor called.");
 }

 @Override
 public void displayInfo() {
     super.displayInfo(); 
     System.out.println("Department: " + department);
 }
}


public class InheritanceExample {
 public static void main(String[] args) {
     System.out.println("Creating Manager object...\n");

     Manager m = new Manager("Amit Sharma", 40, 1001, 95000, "IT");

     System.out.println("\nDisplaying Manager Info:");
     m.displayInfo(); 
 }
}
