package examples;

import java.util.HashSet;
import java.util.Scanner;

class Patient {
    private String id;
    private String name;

    public Patient(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Patient) {
            Patient p = (Patient) obj;
            return this.id.equals(p.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode(); 
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

public class AdvancePatienntHashset {
    public static void main(String[] args) {
        HashSet<Patient> patients = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Smart Hospital Set System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Remove Patient by ID");
            System.out.println("3. Check if Patient Exists");
            System.out.println("4. View All Patients");
            System.out.println("5. Show Total Patients");
            System.out.println("6. Clear All Records");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    Patient newPatient = new Patient(id, name);

                    if (patients.contains(newPatient)) {
                        System.out.println("Patient already exists!");
                    } else {
                        patients.add(newPatient);
                        System.out.println("Patient added.");
                    }
                    break;

                case 2:
                    System.out.print("Enter ID to remove: ");
                    String removeId = sc.nextLine();
                    boolean removed = false;

                    for (Patient p : patients) {
                        if (p.getId().equals(removeId)) {
                            patients.remove(p);
                            System.out.println("Patient removed.");
                            removed = true;
                            break;
                        }
                    }

                    if (!removed) {
                        System.out.println("No patient found with that ID.");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to check: ");
                    String checkId = sc.nextLine();
                    boolean exists = false;

                    for (Patient p : patients) {
                        if (p.getId().equals(checkId)) {
                            exists = true;
                            break;
                        }
                    }

                    System.out.println(exists ? "Patient exists." : " Not found.");
                    break;

                case 4:
                    if (patients.isEmpty()) {
                        System.out.println("No patients found.");
                    } else {
                        for (Patient p : patients) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Total Patients: " + patients.size());
                    break;

                case 6:
                    patients.clear();
                    System.out.println("All records cleared.");
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}
