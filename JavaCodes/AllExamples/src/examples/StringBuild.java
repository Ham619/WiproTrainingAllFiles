package examples;

import java.util.Scanner;

public class StringBuild {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        StringBuffer report = new StringBuffer();
        report.append("---- EMPLOYEE PROFILE REPORT ------\n\n");

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter details for Employee " + i);

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("Department: ");
            String dept = sc.nextLine();

            System.out.print("Designation: ");
            String desg = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine(); // Consume newline

            report.append("Employee #" + i + "\n");
            report.append("Name       : " + name + "\n");
            report.append("ID         : " + id + "\n");
            report.append("Department : " + dept + "\n");
            report.append("Designation: " + desg + "\n");
            report.append("Salary     : " + salary + "\n");
            report.append("----------\n");
        }

        // Print full report
        System.out.println("\n" + report.toString());

        sc.close();
    }
}

