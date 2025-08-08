package examples;
import java.util.*;

public class ATMCashTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        int[] denominations = {2000, 500, 200, 100};
        int days = 3; 

        
        int[][] cash = new int[days][denominations.length];

        
        System.out.println("Enter cash count for each denomination for " + days + " days:");

        for (int i = 0; i < days; i++) {
            System.out.println("\nDay " + (i + 1) + ":");
            for (int j = 0; j < denominations.length; j++) {
                System.out.print("Number of " + denominations[j] + " notes: ");
                cash[i][j] = sc.nextInt();
            }
        }

       
        System.out.println("\nATM Cash Summary:");
        for (int i = 0; i < days; i++) {
            int total = 0;
            System.out.println("\nDay " + (i + 1) + ":");
            for (int j = 0; j < denominations.length; j++) {
                int amount = cash[i][j] * denominations[j];
                System.out.println(denominations[j] + " x " + cash[i][j] + " = ₹" + amount);
                total += amount;
            }
            System.out.println("Total cash for Day " + (i + 1) + ": ₹" + total);
        }

        sc.close();
    }
}
