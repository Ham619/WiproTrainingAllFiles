package examples;

import java.util.Scanner;

public class ArrayListExamples {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your age:");
		String ageInput = sc.nextLine();

		System.out.println("Enter your monthly salary:");
		String salaryInput = sc.nextLine();

		System.out.print("Do you confirm the details? (true/false): ");
		String confirmInput = sc.nextLine();

		int age = Integer.parseInt(ageInput);
		if (age < 18 || age > 100) {
			System.out.println("Invalid age. Must be between 18 and 100.");
		} else {
			System.out.println("Valid age: " + age);
		}

		double salary = Double.parseDouble(salaryInput);
		if (salary < 0) {
			System.out.println("Salary cannot be negative.");
		} else {
			System.out.println("Valid salary: " + salary);
		}

		boolean isConfirmed = Boolean.parseBoolean(confirmInput);
		if (isConfirmed) {
			System.out.println("Form submitted successfully.");
		} else {
			System.out.println("Form submission not confirmed.");
		}
	}

}
