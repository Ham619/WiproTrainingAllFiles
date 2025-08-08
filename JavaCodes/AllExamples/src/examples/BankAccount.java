package examples;

public class BankAccount {
	
	private String name;
	private int balance;
	
	public BankAccount(String name,int balance) {
		this.name = name;
		this.balance = balance;
	}
	
	public void deposit(int amount) {
		if(amount > 0) {
			balance += amount;
			System.out.println("Deposite amount"+amount);
		}else {
			System.out.println("Invalid depost anount");
		}
	}
	
	public void withdraw(int amount) {
		if(amount <=0) {
			System.out.println("Invalid amount");
		}else if(amount>balance) {
			System.out.println("Insufficient balance");
		}else {
			balance -= amount;
			System.out.println("Withdrawn amount"+ amount);
		}
	}
	
	public void displayDetails() {
		System.out.println("Account holder name"+name);
		System.out.println("Account balance"+balance);
	}
	
	
	    public static void main(String[] args) {
	        BankAccount myAccount = new BankAccount("Hammad", 5000);

	        myAccount.displayDetails();
	        myAccount.deposit(2000);
	        myAccount.withdraw(1000);
	         

	        myAccount.displayDetails();
	    }
	
}
