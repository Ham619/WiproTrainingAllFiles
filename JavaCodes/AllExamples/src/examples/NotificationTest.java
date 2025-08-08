package examples;

import java.util.Scanner;


abstract class Notification {
    abstract void send(String message);
}


class EmailNotification extends Notification {
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}


class SMSNotification extends Notification {
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}


class PushNotification extends Notification {
    public void send(String message) {
        System.out.println("Push Notification sent: " + message);
    }
}


public class NotificationTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Notification notification;

        System.out.print("What notification type do you want? (email/sms/push): ");
        String type = scanner.nextLine().toLowerCase();

        System.out.print("Enter your message: ");
        String message = scanner.nextLine();

        if (type.equals("email")) {
            notification = new EmailNotification();
        } else if (type.equals("sms")) {
            notification = new SMSNotification();
        } else if (type.equals("push")) {
            notification = new PushNotification();
        } else {
            System.out.println("Invalid notification type.");
            scanner.close();
            return;
        }

        notification.send(message);
        scanner.close();
    }
}
