package Types;

public class Employee {
	// static variable
    static String company = "TCS"; 
    // instance variable
    String name; 

    Employee(String name) {
        this.name = name;
    }

    void display() {
        System.out.println(name + " works at " + company);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Ravi");
        e1.display();
    }
}

