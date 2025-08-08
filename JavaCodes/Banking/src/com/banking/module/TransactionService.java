package com.banking.module;


public interface TransactionService {
    void deposit(int accountNumber, double amount);
    void withdraw(int accountNumber, double amount);
    void checkBalance(int accountNumber);
}
