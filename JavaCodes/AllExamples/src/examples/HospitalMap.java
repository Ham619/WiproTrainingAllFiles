package examples;

import java.util.HashMap;
import java.util.Scanner;

class Doctor {
    private int licenseNumber;
    private String name;
    private String department;

    public Doctor(int licenseNumber, String name, String department) {
        this.licenseNumber = licenseNumber;
        this.name = name;
        this.department = department;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    public String toString() {
        return "Doctor ID: " + licenseNumber + ", Name: " + name + ", Department: " + department;
    }
}

public class HospitalMap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Doctor> doctorMap = new HashMap<>();
        int choice;

        do {
            System.out.println("\n--- Hospital Doctor Management ---");
            System.out.println("1. Register Doctor");
            System.out.println("2. View All Doctors");
            System.out.println("3. View Doctor by ID");
            System.out.println("4. Remove Doctor");
            System.out.println("5. Update Doctor Details");
            System.out.println("6. Total Doctors");
            System.out.println("7. Clear All Records");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Doctor License Number (unique): ");
                    int license = sc.nextInt();
                    sc.nextLine();

                    if (doctorMap.containsKey(license)) {
                        System.out.println("Doctor with this license already exists.");
                    } else {
                        System.out.print("Enter Doctor Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();

                        doctorMap.put(license, new Doctor(license, name, dept));
                        System.out.println("Doctor registered successfully.");
                    }
                    break;

                case 2:
                    if (doctorMap.isEmpty()) {
                        System.out.println("No doctors registered.");
                    } else {
                        System.out.println("\nList of Registered Doctors:");
                        for (int id : doctorMap.keySet()) {
                            System.out.println(doctorMap.get(id).toString());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Doctor License Number: ");
                    int idToView = sc.nextInt();
                    if (doctorMap.containsKey(idToView)) {
                        System.out.println(doctorMap.get(idToView));
                    } else {
                        System.out.println("Doctor not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter License Number to remove: ");
                    int idToRemove = sc.nextInt();
                    Doctor removed = doctorMap.remove(idToRemove);
                    if (removed != null) {
                        System.out.println("Removed Doctor: " + removed);
                    } else {
                        System.out.println("Doctor not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter License Number to update: ");
                    int idToUpdate = sc.nextInt();
                    sc.nextLine();

                    if (doctorMap.containsKey(idToUpdate)) {
                        Doctor doc = doctorMap.get(idToUpdate);

                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new department: ");
                        String newDept = sc.nextLine();

                        doc.setName(newName);
                        doc.setDepartment(newDept);

                        doctorMap.replace(idToUpdate, doc);
                        System.out.println("Doctor details updated.");
                    } else {
                        System.out.println("Doctor not found.");
                    }
                    break;

                case 6:
                    System.out.println("Total Doctors: " + doctorMap.size());
                    break;

                case 7:
                    doctorMap.clear();
                    System.out.println("All doctor records cleared.");
                    break;

                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);

        sc.close();
    }
}
