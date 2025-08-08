package OopsExamples;


class BankAccount {
 
 private String accountHolder;
 private String accountNumber;
 private double balance;

 
 public BankAccount(String accountHolder, String accountNumber, double balance) {
     this.accountHolder = accountHolder;
     this.accountNumber = accountNumber;
     this.balance = balance;
 }


 public String getAccountHolder() {
     return accountHolder;
 }

 public void setAccountHolder(String name) {
     this.accountHolder = name;
 }

 public String getAccountNumber() {
     return "XXXX-XXXX-" + accountNumber.substring(8); 
 }

 public double getBalance() {
     return balance;
 }

 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposited ₹" + amount);
     } else {
         System.out.println("Invalid deposit amount!");
     }
 }

 public void withdraw(double amount) {
     if (amount <= balance && amount > 0) {
         balance -= amount;
         System.out.println("Withdrew ₹" + amount);
     } else {
         System.out.println("Insufficient balance or invalid amount!");
     }
 }

 public void showDetails() {
     System.out.println("Account Holder: " + accountHolder);
     System.out.println("Account Number: " + getAccountNumber());
     System.out.println("Balance: ₹" + balance);
 }
}

public class EncapsulationExample {
 public static void main(String[] args) {
    
     BankAccount account = new BankAccount("Rohit Mehra", "123456789012", 5000.0);

  
     System.out.println("Account Details:");
     account.showDetails();

     System.out.println("\nTransactions:");
     account.deposit(1500);
     account.withdraw(2000);
     account.withdraw(6000); 

     System.out.println("\nUpdated Account Details:");
     account.showDetails();
 }
}
