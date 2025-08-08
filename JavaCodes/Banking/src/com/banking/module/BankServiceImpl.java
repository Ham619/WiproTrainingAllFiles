package com.banking.module;


public class BankServiceImpl implements TransactionService {
    private Account[] accounts = new Account[10];
    private int count = 0;

    public void addAccount(Account account) {
        if (count < accounts.length) {
            accounts[count++] = account;
            System.out.println("Account added: " + account.getHolderName());
        } else {
            System.out.println("Bank is full. Cannot add more accounts.");
        }
    }

    private Account findAccount(int accNo) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accNo) {
                return accounts[i];
            }
        }
        return null;
    }

    @Override
    public void deposit(int accNo, double amount) {
        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.balance += amount;
            System.out.println(amount + " deposited to account " + accNo);
        } else {
            System.out.println("Account not found.");
        }
    }

    @Override
    public void withdraw(int accNo, double amount) {
        Account acc = findAccount(accNo);
        if (acc != null) {
            if (acc.balance >= amount) {
                acc.balance -= amount;
                System.out.println(amount + " withdrawn from account " + accNo);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    @Override
    public void checkBalance(int accNo) {
        Account acc = findAccount(accNo);
        if (acc != null) {
            System.out.println("Account Balance for " + acc.getHolderName() + ": " + acc.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
}
