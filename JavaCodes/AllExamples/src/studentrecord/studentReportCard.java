package studentrecord;
import java.util.Scanner;

public class studentReportCard {
	 public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);

	        
	        System.out.print("Enter student name: ");
	        String name = input.nextLine();

	        System.out.print("Enter roll number: ");
	        int rollNo = input.nextInt();
	        
	        System.out.print("Enter student class");
	        String classNo = input.nextLine();

	        System.out.print("Enter Total Marks: ");
	        int marks = input.nextInt();
	        
	        System.out.print("Enter Mobile Number: ");
	        long mobileNo = input.nextInt();
	        
	        float percentage = marks/500;

	        
	        System.out.println("Student Report Card");
	        System.out.println("Name: " + name);
	        System.out.println("Roll No: " + rollNo);
	        System.out.println("Class NO: " + classNo);
	        System.out.println("Marks: " + marks);
	        System.out.println("Percentage: " + percentage);
	        System.out.println("Mobile No: " + mobileNo);
	        input.close();
	        
	    }
	
}
