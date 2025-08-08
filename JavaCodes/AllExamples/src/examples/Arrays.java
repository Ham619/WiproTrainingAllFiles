package examples;
import java.util.*;

public class Arrays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        char[] attendance = new char[7];
 
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        System.out.println("Mark attendance for the week (P = Present, A = Absent):");

        
        for (int i = 0; i < 7; i++) {
            char status;
            while (true) {
                System.out.print(days[i] + ": ");
                status = sc.next().toUpperCase().charAt(0);
                if (status == 'P' || status == 'A') {
                    break;
                } else {
                    System.out.println("Invalid input! Please enter P or A.");
                }
            }
            attendance[i] = status;
        }

       
        System.out.println("\nAttendance Summary:");
        
        int presentCount = 0, absentCount = 0;

        for (int i = 0; i < 7; i++) {
            System.out.println(days[i] + ": " + (attendance[i] == 'P' ? "Present" : "Absent"));
            if (attendance[i] == 'P') presentCount++;
            else absentCount++;
        }

        System.out.println("\nTotal Present Days: " + presentCount);
        System.out.println("Total Absent Days: " + absentCount);

        sc.close();
    }
}
