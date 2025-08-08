package IOExamples;

import java.io.*;
import java.util.*;

class Patient implements Serializable {
//    private static final long serialVersionUID = 1L;
    int id;
    String name;
    String disease;
    int age;

    public Patient(int id, String name, String disease, int age) {
        this.id = id;
        this.name = name;
        this.disease = disease;
        this.age = age;
    }

    public String toString() {
        return id + " - " + name + " - " + disease + " - " + age;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class SerealizeExample {
    static final String FILE_NAME = "patients.dat";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Patient> patients = loadPatients();

        while (true) {
            System.out.println("\n--- Patient Management ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient by ID");
            System.out.println("4. Delete Patient by ID");
            System.out.println("5. Update Patient");
            System.out.println("6. Export to patients.txt");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    boolean exists = false;
                    for (int i = 0; i < patients.size(); i++) {
                        if (patients.get(i).getId() == id) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("ID already exists!");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Disease: ");
                    String disease = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    if (age <= 0 || name.isEmpty() || disease.isEmpty()) {
                        System.out.println("Invalid input.");
                        break;
                    }

                    patients.add(new Patient(id, name, disease, age));
                    savePatients(patients);
                    System.out.println("Patient added.");
                    break;

                case 2:
                    System.out.println("\nAll Patients:");
                    for (int i = 0; i < patients.size(); i++) {
                        System.out.println(patients.get(i));
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int sid = sc.nextInt();
                    sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < patients.size(); i++) {
                        if (patients.get(i).getId() == sid) {
                            System.out.println(patients.get(i));
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    sc.nextLine();
                    boolean removed = false;
                    for (int i = 0; i < patients.size(); i++) {
                        if (patients.get(i).getId() == did) {
                            patients.remove(i);
                            removed = true;
                            break;
                        }
                    }
                    if (removed) {
                        savePatients(patients);
                        System.out.println("Patient deleted.");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    boolean updated = false;
                    for (int i = 0; i < patients.size(); i++) {
                        if (patients.get(i).getId() == uid) {
                            System.out.print("Enter new name: ");
                            String newName = sc.nextLine();
                            System.out.print("Enter new disease: ");
                            String newDisease = sc.nextLine();
                            System.out.print("Enter new age: ");
                            int newAge = sc.nextInt();
                            sc.nextLine();

                            patients.get(i).setName(newName);
                            patients.get(i).setDisease(newDisease);
                            patients.get(i).setAge(newAge);

                            savePatients(patients);
                            System.out.println("Patient updated.");
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 6:
                    exportToText(patients);
                    System.out.println("Exported to patients.txt");
                    break;

                case 7:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static ArrayList<Patient> loadPatients() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Patient>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<Patient>();
        }
    }

    static void savePatients(List<Patient> patients) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(patients);
        } catch (IOException e) {
            logError(e);
        }
    }

    static void exportToText(List<Patient> patients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("patients.txt"))) {
            for (int i = 0; i < patients.size(); i++) {
                writer.write(patients.get(i).toString());
                writer.newLine();
            }
        } catch (IOException e) {
            logError(e);
        }
    }

    static void logError(Exception e) {
        try (PrintWriter log = new PrintWriter(new FileWriter("error.log", true))) {
            log.println("[" + new Date() + "] " + e);
        } catch (IOException ignored) {
        }
    }
}
