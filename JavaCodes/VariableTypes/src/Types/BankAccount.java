package Types;

public class BankAccount {
    
    // instance variable
	int balance = 5000;

    void deposit(int amount) {
    	// local variable
        int newBalance = balance + amount; 
        
        System.out.println("Deposited: " + amount);
        System.out.println("New Balance: " + newBalance);
    }

    public static void main(String[] args) {
        BankAccount b = new BankAccount();
        b.deposit(1500);
    }
}