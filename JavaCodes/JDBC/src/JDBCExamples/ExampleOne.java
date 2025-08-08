package JDBCExamples;

import java.sql.*;
import java.util.Scanner;

public class ExampleOne {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Hospital1"; 
        String username = "root"; 
        String password = "12345"; 

        
//        Object[][] patients = {
//            {"Rajiv", 23, "Fever"},
//            {"Roham", 28, "Cold"},
//            {"ajay", 35, "Cough"},
//            {"Raj", 30, "Oral"}
//        };
        
//        Object[][] updates = {
//                {"Manjeera", "Ravi"},
//                {"Ayaan", "ajay"},
//                {"Ragini", "Sara"}
//            };
        
        


        try {
        	Scanner scanner = new Scanner(System.in);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database.");

            String sql = "INSERT INTO patient(name, age, disease) VALUES (?, ?, ?)";
            
            String sqlUpdate = "UPDATE patient SET name=? WHERE name=?";
            
            
            
            PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
            
            
            
            for (Object[] update : updates) {
                pstmt.setString(1, (String) update[0]); 
                pstmt.setString(2, (String) update[1]); 
                int rows = pstmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("Updated " + update[1] + " to " + update[0]);
                } else {
                    System.out.println("No record found for " + update[1]);
                }
            }

            
//            pstmt.executeUpdate();

//            for (Object[] patient : patients) {
//                pstmt.setString(1, (String) patient[0]);       
//                pstmt.setInt(2, (Integer) patient[1]);        
//                pstmt.setString(3, (String) patient[2]);       
//                pstmt.executeUpdate();
//                System.out.println("Inserted: " + patient[0]);
//            }

            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Exception occurred.");
            e.printStackTrace();
        }
    }
}
