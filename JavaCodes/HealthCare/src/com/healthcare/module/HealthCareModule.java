package com.healthcare.module;

import java.util.Scanner;

public class HealthCareModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientService service = new patientServiceImpl();

        System.out.print("Enter number of patients to register: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Patient " + (i + 1) + ":");

            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Illness: ");
            String illness = scanner.nextLine();

            Patient patient = new Patient(id, name, age, illness);
            service.registerPatient(patient);
        }

        System.out.println("\n--- View Patient Details ---");
        char choice;
        do {
            System.out.print("Enter patient ID to view: ");
            int searchId = scanner.nextInt();
            service.showPatientDetails(searchId);

            System.out.print("Do you want to check another patient? (y/n): ");
            choice = scanner.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');

       
      

        scanner.close();
    }
}
