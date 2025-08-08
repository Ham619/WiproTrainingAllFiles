package examples;

import java.util.LinkedList;
import java.util.Scanner;

public class PatientQueueDemo {
    public static void main(String[] args) {

        LinkedList<String> patientQueue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Hospital Patient Queue Menu ---");
            System.out.println("1. Add New Patient (Normal)");
            System.out.println("2. Add Emergency Patient");
            System.out.println("3. Remove Patient from Front");
            System.out.println("4. View All Patients");
            System.out.println("5. View First and Last Patient");
            System.out.println("6. Search Patient");
            System.out.println("7. Get Total Patients");
            System.out.println("8. Check if a Patient Exists");
            System.out.println("9. Display Patients with Index");
            System.out.println("10. Remove Patient by Name");
            System.out.println("11. Clear Entire Queue");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String patient = sc.nextLine();
                    patientQueue.addLast(patient);
                    System.out.println("Patient added to the queue.");
                    break;

                case 2:
                    System.out.print("Enter emergency patient name: ");
                    String emergencyPatient = sc.nextLine();
                    patientQueue.addFirst(emergencyPatient);
                    System.out.println("Emergency patient added to the front of the queue.");
                    break;

                case 3:
                    if (!patientQueue.isEmpty()) {
                        String removed = patientQueue.removeFirst();
                        System.out.println("Removed patient: " + removed);
                    } else {
                        System.out.println("No patients in the queue.");
                    }
                    break;

                case 4:
                    System.out.println("Current Queue: " + patientQueue);
                    break;

                case 5:
                    if (!patientQueue.isEmpty()) {
                        System.out.println("First Patient: " + patientQueue.getFirst());
                        System.out.println("Last Patient: " + patientQueue.getLast());
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;

                case 6:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    if (patientQueue.contains(searchName)) {
                        System.out.println(searchName + " is in the queue.");
                    } else {
                        System.out.println(searchName + " not found in the queue.");
                    }
                    break;

                case 7:
                    System.out.println("Total number of patients: " + patientQueue.size());
                    break;

                case 8:
                    System.out.print("Enter patient name to check: ");
                    String nameCheck = sc.nextLine();
                    if (patientQueue.contains(nameCheck)) {
                        System.out.println(nameCheck + " exists in the queue.");
                    } else {
                        System.out.println(nameCheck + " does not exist in the queue.");
                    }
                    break;

                case 9:
                    System.out.println("Patients with Index:");
                    for (int i = 0; i < patientQueue.size(); i++) {
                        System.out.println(i + ": " + patientQueue.get(i));
                    }
                    break;

                case 10:
                    System.out.print("Enter patient name to remove: ");
                    String nameToRemove = sc.nextLine();
                    if (patientQueue.remove(nameToRemove)) {
                        System.out.println("Removed patient: " + nameToRemove);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 11:
                    patientQueue.clear();
                    System.out.println("All patient records cleared.");
                    break;

                case 12:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 12);

        sc.close();
    }
}
