package examples;

import java.util.*;

class SinglyLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public SinglyLinkedList(Node head) {
        this.head = head;
    }

    // Add new node at the end of list
    public void add(Node node) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    // Reverse the linked list
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node nextNode;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        head = prev;
    }

    // Print the linked list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class ExampleOne {

    public static void main(String[] args) {
        // Create head node
        SinglyLinkedList.Node head = new SinglyLinkedList.Node(10);
        SinglyLinkedList list = new SinglyLinkedList(head);

        // Add more nodes
        list.add(new SinglyLinkedList.Node(20));
        list.add(new SinglyLinkedList.Node(30));
        list.add(new SinglyLinkedList.Node(40));

        // Print original list
        System.out.println("Original List:");
        list.print();

        // Reverse and print the list
        list.reverse();
        System.out.println("Reversed List:");
        list.print();
    }
}
