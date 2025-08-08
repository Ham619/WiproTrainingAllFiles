package ColletionExamples;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Appointment {
    private int appointmentId;
    private String patientName;
    private String doctorName;
    private String appointmentTime;

    public Appointment(int appointmentId, String patientName, String doctorName, String appointmentTime) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.appointmentTime = appointmentTime;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    
    public String toString() {
        return "Appointment ID: " + appointmentId +
               ", Patient: " + patientName +
               ", Doctor: " + doctorName +
               ", Time: " + appointmentTime;
    }
}

public class AppointmentSheduler {
    public static void main(String[] args) {
        TreeMap<Integer, Appointment> appointments = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---- Hospital Appointment Scheduler ----");
            System.out.println("1. Add Appointment");
            System.out.println("2. View All Appointments (Sorted)");
            System.out.println("3. Remove Appointment");
            System.out.println("4. Reschedule Appointment");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Appointment ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Patient Name: ");
                    String patient = sc.nextLine();
                    System.out.print("Enter Doctor Name: ");
                    String doctor = sc.nextLine();
                    System.out.print("Enter Appointment Time (e.g., 10:30 AM): ");
                    String time = sc.nextLine();

                    Appointment appt = new Appointment(id, patient, doctor, time);
                    appointments.put(id, appt);
                    System.out.println("Appointment added successfully.");
                    break;

                case 2:
                    if (appointments.isEmpty()) {
                        System.out.println("No appointments scheduled.");
                    } else {
                        System.out.println("\n-- Scheduled Appointments --");
                        for (Map.Entry<Integer, Appointment> entry : appointments.entrySet()) {
                            System.out.println(entry.getValue());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Appointment ID to remove: ");
                    int removeId = sc.nextInt();
                    Appointment removed = appointments.remove(removeId);
                    if (removed != null) {
                        System.out.println("Appointment removed: " + removed);
                    } else {
                        System.out.println("Appointment not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Appointment ID to reschedule: ");
                    int rescheduleId = sc.nextInt();
                    sc.nextLine();
                    Appointment existing = appointments.get(rescheduleId);
                    if (existing != null) {
                        System.out.print("Enter new time: ");
                        String newTime = sc.nextLine();
                        existing.setAppointmentTime(newTime);
                        appointments.put(rescheduleId, existing);
                        System.out.println("Appointment rescheduled.");
                    } else {
                        System.out.println("Appointment not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
