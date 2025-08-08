package examples;

class Employee {
    private String name;
    private int id;
    private double salary;  

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        setSalary(salary); 
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary! Salary cannot be negative.");
        }
    }

    public void displayInfo() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }




    public static void main(String[] args) {
        Employee emp = new Employee("Hammad", 101, 50000);

        emp.displayInfo();

        System.out.println("Current Salary: " + emp.getSalary());

        emp.setSalary(-10000); 
        emp.setSalary(60000);

        emp.displayInfo();
    }
    }

