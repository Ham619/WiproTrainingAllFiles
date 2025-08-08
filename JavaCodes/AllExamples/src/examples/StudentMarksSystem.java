package examples;

import java.util.Scanner;

public class StudentMarksSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter number of subjects: ");
        int subjectCount = scanner.nextInt();

      
        String[] subjects = new String[subjectCount];
        Integer[] marks = new Integer[subjectCount];

        
        for (int i = 0; i < subjectCount; i++) {
            System.out.print("Enter subject name " + (i + 1) + ": ");
            subjects[i] = scanner.next();

            System.out.print("Enter marks in " + subjects[i] + ": ");
            marks[i] = scanner.nextInt();
        }

        
        int total = 0;
        for (Integer mark : marks) {
            total += mark; 
        }

        Double average = total / (double) subjectCount;

        
        String grade;
        if (average >= 90) {
            grade = "A+";
        } else if (average >= 75) {
            grade = "A";
        } else if (average >= 60) {
            grade = "B";
        } else if (average >= 40) {
            grade = "C";
        } else {
            grade = "F (Fail)";
        }

       
        System.out.println("\n--- Student Report ---");
        System.out.println("Name: " + name);
        for (int i = 0; i < subjectCount; i++) {
            System.out.println(subjects[i] + ": " + marks[i]);
        }
        System.out.println("Total Marks: " + total);
        System.out.println("Average Marks: " + average);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
