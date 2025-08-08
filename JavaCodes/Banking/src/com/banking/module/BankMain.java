package com.banking.module;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankServiceImpl bank = new BankServiceImpl();

        System.out.println("Create New Account");
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        sc.nextLine(); 
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        System.out.print("Enter Account Type (1 - Savings, 2 - Current): ");
        int type = sc.nextInt();

        if (type == 1) {
            bank.addAccount(new SavingsAccount(accNo, name, bal));
        } else if (type == 2) {
            bank.addAccount(new CurrentAccount(accNo, name, bal));
        } else {
            System.out.println("Invalid account type. Exiting.");
            sc.close();
            return;
        }

     
        while (true) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 4) {
                System.out.println("Thank you for using our bank!");
                break;
            }

            System.out.print("Enter Account Number: ");
            int inputAccNo = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter amount to deposit: ");
                double amt = sc.nextDouble();
                bank.deposit(inputAccNo, amt);
            } else if (choice == 2) {
                System.out.print("Enter amount to withdraw: ");
                double amt = sc.nextDouble();
                bank.withdraw(inputAccNo, amt);
            } else if (choice == 3) {
                bank.checkBalance(inputAccNo);
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}
