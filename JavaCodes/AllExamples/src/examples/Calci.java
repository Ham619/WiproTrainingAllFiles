package examples;

import java.util.Scanner;

public class Calci {

   
    interface Calculator {
        int operation(int a, int b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        Calculator add = (a, b) -> a + b;
        Calculator sub = (a, b) -> a - b;
        Calculator mul = (a, b) -> a * b;
        Calculator div = (a,b) -> a/b;


        System.out.print("Enter first number: ");
        int x = sc.nextInt();

        System.out.print("Enter second number: ");
        int y = sc.nextInt();

        System.out.println("Addition: " + add.operation(x, y));
        System.out.println("Subtraction: " + sub.operation(x, y));
        System.out.println("Multiplication: " + mul.operation(x, y));
        System.out.println("Division: " + div.operation(x, y));

        sc.close();
    }
}

