package examples;

import java.util.Scanner;

public class ExamScore {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        
        int[][] scores = new int[students][];

        
        for (int i = 0; i < students; i++) {
            System.out.print("Enter number of subjects for Student " + (i + 1) + ": ");
            int subjects = sc.nextInt();

            scores[i] = new int[subjects];

            System.out.println("Enter marks for Student " + (i + 1) + ":");
            for (int j = 0; j < subjects; j++) {
                System.out.print("Subject " + (j + 1) + ": ");
                scores[i][j] = sc.nextInt();
            }
        }

        // Display scores and average for each student
        System.out.println("\nExam Scores Summary:");
        for (int i = 0; i < students; i++) {
            int total = 0;
            System.out.print("Student " + (i + 1) + " scores: ");
            for (int j = 0; j < scores[i].length; j++) {
                System.out.print(scores[i][j] + " ");
                total += scores[i][j];
            }
            double avg = (double) total / scores[i].length;
            System.out.println("Total: " + total + " | Average: " + avg);
        }

        sc.close();
    }
}
