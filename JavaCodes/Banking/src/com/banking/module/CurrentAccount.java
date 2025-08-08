package com.banking.module;


public class CurrentAccount extends Account {
    public CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public void displayAccountType() {
        System.out.println("Current Account");
    }
}
