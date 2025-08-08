package examples;

import java.util.Scanner;


abstract class Remote {
    abstract void turnOn();
    abstract void turnOff();
}


class TVRemote extends Remote {
    
    void turnOn() {
        System.out.println("TV is turned ON.");
    }

  
    void turnOff() {
        System.out.println("TV is turned OFF.");
    }
}


class ACRemote extends Remote {
   
    void turnOn() {
        System.out.println("AC is turned ON.");
    }

    
    void turnOff() {
        System.out.println("AC is turned OFF.");
    }
}


public class RemoteTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Remote remote;

        System.out.println("Choose device to control:");
        System.out.println("1. TV");
        System.out.println("2. AC");
        int choice = scanner.nextInt();

        if (choice == 1) {
            remote = new TVRemote();
        } else if (choice == 2) {
            remote = new ACRemote();
        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }

        System.out.println("Choose action:");
        System.out.println("1. Turn ON");
        System.out.println("2. Turn OFF");
        int action = scanner.nextInt();

        if (action == 1) {
            remote.turnOn();
        } else if (action == 2) {
            remote.turnOff();
        } else {
            System.out.println("Invalid action.");
        }

        scanner.close();
    }
}
