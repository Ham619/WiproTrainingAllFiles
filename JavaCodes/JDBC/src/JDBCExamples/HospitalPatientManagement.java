package JDBCExamples;

import java.sql.*;
import java.util.Scanner;

public class HospitalPatientManagement {

    private static final String URL = "jdbc:mysql://localhost:3306/HospitalDB";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";

    public static void main(String[] args) {
        try (
            Scanner scanner = new Scanner(System.in);
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected to the database.");

            while (true) {
                System.out.println("\n--- Hospital Patient Management ---");
                System.out.println("1. Register Patient");
                System.out.println("2. View All Patients");
                System.out.println("3. Search Patient by Name");
                System.out.println("4. Update Patient Info");
                System.out.println("5. Delete Patient");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        registerPatient(scanner, conn);
                        break;
                    case 2:
                        displayAllPatients(conn);
                        break;
                    case 3:
                        searchByName(scanner, conn);
                        break;
                    case 4:
                        updatePatient(scanner, conn);
                        break;
                    case 5:
                        deletePatient(scanner, conn);
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    private static void registerPatient(Scanner scanner, Connection conn) {
        String sql = "INSERT INTO patient (name, age, disease, admission_date, doctor_assigned) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Disease: ");
            String disease = scanner.nextLine();
            System.out.print("Admission Date (YYYY-MM-DD): ");
            String dateStr = scanner.nextLine();
            System.out.print("Doctor Assigned: ");
            String doctor = scanner.nextLine();

            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, disease);
            pstmt.setDate(4, Date.valueOf(dateStr));
            pstmt.setString(5, doctor);

            int rows = pstmt.executeUpdate();
            System.out.println(rows > 0 ? "Patient registered successfully." : "Registration failed.");
        } catch (SQLException e) {
            System.out.println("SQL Error while registering patient: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error during registration: " + e.getMessage());
        }
    }

    private static void displayAllPatients(Connection conn) {
        String sql = "SELECT * FROM patient";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Patient List:");
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String disease = rs.getString("disease");
                String admissionDate = rs.getDate("admission_date").toString();
                String doctor = rs.getString("doctor_assigned");

                System.out.println(name + " - " + age + " - " + disease + " - " + admissionDate + " - " + doctor);
            }

        } catch (SQLException e) {
            System.out.println("SQL Error while displaying patients: " + e.getMessage());
        }
    }

    private static void searchByName(Scanner scanner, Connection conn) {
        System.out.print("Enter patient name to search: ");
        String name = scanner.nextLine();
        String sql = "SELECT * FROM patient WHERE name LIKE ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + name + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.println("Found: " + rs.getString("name") + " - " +
                            rs.getInt("age") + " - " +
                            rs.getString("disease") + " - " +
                            rs.getDate("admission_date") + " - " +
                            rs.getString("doctor_assigned"));
                }
                if (!found) {
                    System.out.println("No patient found with name containing '" + name + "'");
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Error while searching patient: " + e.getMessage());
        }
    }

    private static void updatePatient(Scanner scanner, Connection conn) {
        System.out.print("Enter patient ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("New Disease: ");
        String disease = scanner.nextLine();
        System.out.print("New Doctor: ");
        String doctor = scanner.nextLine();

        String sql = "UPDATE patient SET disease=?, doctor_assigned=? WHERE id=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, disease);
            pstmt.setString(2, doctor);
            pstmt.setInt(3, id);
            int rows = pstmt.executeUpdate();
            System.out.println(rows > 0 ? "Patient updated." : "Patient ID not found.");
        } catch (SQLException e) {
            System.out.println("SQL Error while updating patient: " + e.getMessage());
        }
    }

    private static void deletePatient(Scanner scanner, Connection conn) {
        System.out.print("Enter patient ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        String sql = "DELETE FROM patient WHERE id=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            System.out.println(rows > 0 ? "Patient deleted." : "Patient ID not found.");
        } catch (SQLException e) {
            System.out.println("SQL Error while deleting patient: " + e.getMessage());
        }
    }
}
