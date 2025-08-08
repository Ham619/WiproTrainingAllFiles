package examples;

import java.util.ArrayList;
import java.util.Scanner;

class Patients {
    private static int idCounter = 1;
    private int id;
    private String name;
    private int age;
    private String disease;

    public Patients(String name, int age, String disease) {
        this.id = idCounter++;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void updateDetails(String newName, int newAge, String newDisease) {
        this.name = newName;
        this.age = newAge;
        this.disease = newDisease;
    }

    public void displayDetails() {
        System.out.println("Patient ID: " + id);
        System.out.println("Name     : " + name);
        System.out.println("Age      : " + age);
        System.out.println("Disease  : " + disease);
        System.out.println("-------------");
    }
}

public class HospitalOpd {
    public static void main(String[] args) {
        ArrayList<Patients> patientList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Sample data
        patientList.add(new Patients("Vinay Bhat", 45, "Fever"));
        patientList.add(new Patients("Sonali Langar", 40, "Cough"));
        patientList.add(new Patients("Renu Sai", 30, "Pain"));

        while (true) {
            System.out.println("\n--- Hospital OPD Menu ---");
            System.out.println("1. Add New Patient");
            System.out.println("2. Display All Patients");
            System.out.println("3. Search Patient by Name");
            System.out.println("4. Update Patient Details");
            System.out.println("5. Delete Patient");
            System.out.println("6. Total Patient Count");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                System.out.print("Enter patient name: ");
                String name = scanner.nextLine();
                System.out.print("Enter patient age: ");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter disease: ");
                String disease = scanner.nextLine();

                patientList.add(new Patients(name, age, disease));
                System.out.println("Patient added successfully.");

            } else if (choice == 2) {
                if (patientList.isEmpty()) {
                    System.out.println("No patients registered.");
                } else {
                    System.out.println("All Registered Patients:");
                    for (Patients p : patientList) {
                        p.displayDetails();
                    }
                }

            } else if (choice == 3) {
                System.out.print("Enter patient name to search: ");
                String searchName = scanner.nextLine();
                boolean found = false;

                for (Patients p : patientList) {
                    if (p.getName().equalsIgnoreCase(searchName)) {
                        p.displayDetails();
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("No patient found with name: " + searchName);
                }

            } else if (choice == 4) {
                System.out.print("Enter patient name to update: ");
                String nameToUpdate = scanner.nextLine();
                boolean found = false;

                for (Patients p : patientList) {
                    if (p.getName().equalsIgnoreCase(nameToUpdate)) {
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new age: ");
                        int newAge = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter new disease: ");
                        String newDisease = scanner.nextLine();

                        p.updateDetails(newName, newAge, newDisease);
                        System.out.println("Patient details updated.");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("No patient found with name: " + nameToUpdate);
                }

            } else if (choice == 5) {
                System.out.print("Enter patient name to delete: ");
                String nameToDelete = scanner.nextLine();
                boolean removed = false;

                for (int i = 0; i < patientList.size(); i++) {
                    if (patientList.get(i).getName().equalsIgnoreCase(nameToDelete)) {
                        patientList.remove(i);
                        System.out.println("Patient deleted successfully.");
                        removed = true;
                        break;
                    }
                }

                if (!removed) {
                    System.out.println("No patient found with name: " + nameToDelete);
                }

            } else if (choice == 6) {
                System.out.println("Total number of patients: " + patientList.size());

            } else if (choice == 7) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
