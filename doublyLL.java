import java.util.*;

public class doublyLL {

    public static class node {
        int data;
        node next;
        node prev;

        node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static node head;

    public static void insertAtEnd(int data) {
        node newNode = new node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    public static void printLinkList() {
        if (head == null) {
            return;
        }
        node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void deleteNode(int data) {
        if (head == null)
            return;

        node temp = head;

        if (head.data == data) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        while (temp != null && temp.data != data) {
            temp = temp.next;
        }

        if (temp != null) {
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        insertAtEnd(10);
        insertAtEnd(20);
        insertAtEnd(30);
        printLinkList();
        deleteNode(10);
        printLinkList();
    }
}
