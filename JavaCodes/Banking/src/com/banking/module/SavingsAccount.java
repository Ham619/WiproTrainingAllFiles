package com.banking.module;

public class SavingsAccount extends Account {
    public SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public void displayAccountType() {
        System.out.println("Savings Account");
    }
}
