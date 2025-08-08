package examples;

import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    double price;

    void inputDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book ID: ");
        id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        title = sc.nextLine();

        System.out.print("Enter Author: ");
        author = sc.nextLine();

        System.out.print("Enter Price: ");
        price = sc.nextDouble();
        
        sc.close();
    }

    void displayDetails() {
        System.out.println("\n--- Book Details ---");
        System.out.println("ID     : " + id);
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price  : " + price);
    }
}

public class BookDetails {
    public static void main(String[] args) {
        Book book = new Book();
        book.inputDetails();
        book.displayDetails();
    }
}
