package examples;

import java.util.Scanner;


abstract class Payment {
    abstract void pay(double amount);
}


class CreditCardPayment extends Payment {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card ending with " + cardNumber);
    }
}


class UPIPayment extends Payment {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI ID: " + upiId);
    }
}


public class PaymentTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Payment payment;

        System.out.print("Enter payment method (credit/upi): ");
        String method = scanner.nextLine().toLowerCase();

        System.out.print("Enter amount to pay: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 

        if (method.equals("credit")) {
            System.out.print("Enter card number: ");
            String cardNumber = scanner.nextLine();
            payment = new CreditCardPayment(cardNumber);
            payment.pay(amount);
        } else if (method.equals("upi")) {
            System.out.print("Enter UPI ID: ");
            String upiId = scanner.nextLine();
            payment = new UPIPayment(upiId);
            payment.pay(amount);
        } else {
            System.out.println("Invalid payment method.");
        }

        scanner.close();
    }
}
