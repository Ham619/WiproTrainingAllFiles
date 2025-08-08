//package helloworld;
//
//import java.util.HashSet;
//import java.util.Scanner;
//
//class Doctor {
//    private String licenseNumber;
//    private String name;
//    private String department;
//
//    public Doctor(String licenseNumber, String name, String department) {
//        this.licenseNumber = licenseNumber;
//        this.name = name;
//        this.department = department;
//    }
//
//    public String getLicenseNumber() {
//        return licenseNumber;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    
//    public boolean equals(Object obj) {
//          if (this == obj) return true;
//          if (!(obj instanceof Doctor)) return false;
//          Doctor other = (Doctor) obj;
//          return this.licenseNumber.equals(other.licenseNumber);
//    }
//
//    
//    public int hashCode() {
//        return licenseNumber.hashCode();
//    }
//
//    @Override
//    public String toString() {
//        return "Doctor [License: " + licenseNumber + ", Name: " + name + ", Department: " + department + "]";
//    }
//}
//
//public class DoctorRegistration {
//    public static void main(String[] args) {
//        HashSet<Doctor> doctors = new HashSet<>();
//        Scanner scanner = new Scanner(System.in);
//        int choice;
//
//        do {
//            System.out.println("\n===== Hospital Doctor Registration =====");
//            System.out.println("1. Register New Doctor");
//            System.out.println("2. View All Doctors");
//            System.out.println("3. Exit");
//            System.out.print("Enter your choice: ");
//            choice = Integer.parseInt(scanner.nextLine());
//
//            switch (choice) {
//                case 1:
//                    System.out.print("Enter License Number: ");
//                    String license = scanner.nextLine();
//
//                    Doctor newDoctor = new Doctor(license, "", "");
//                    if (doctors.contains(newDoctor)) {
//                        System.out.println("Doctor with this license number already exists.");
//                    } else {
//                        System.out.print("Enter Name: ");
//                        String name = scanner.nextLine();
//                        System.out.print("Enter Department: ");
//                        String department = scanner.nextLine();
//                        doctors.add(new Doctor(license, name, department));
//                        System.out.println("Doctor registered successfully.");
//                    }
//                    break;
//
//                case 2:
//                    if (doctors.isEmpty()) {
//                        System.out.println("No doctors registered yet.");
//                    } else {
//                        System.out.println("\n--- Registered Doctors ---");
//                        for (Doctor d : doctors) {
//                            System.out.println(d);
//                        }
//                    }
//                    break;
//
//                case 3:
//                    System.out.println("Exiting system. Goodbye!");
//                    break;
//
//                default:
//                    System.out.println("Invalid choice. Try again.");
//            }
//        } while (choice != 3);
//
//        scanner.close();
//    }
//}
package examples;


