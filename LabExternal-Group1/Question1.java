package DAA;

public class stackLL {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node top = null;
    static int count = 0;
    static int MAX = 5;

    static boolean overflow() {
        return count == MAX;
    }

    static boolean underflow() {
        return count == 0;
    }

    static void push(int data) {
        if (overflow()) {
            System.out.println("Overflow");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        count++;
    }

    static void pop() {
        if (underflow()) {
            System.out.println("Underflow");
            return;
        }
        System.out.println("Popped: " + top.data);
        top = top.next;
        count--;
    }

    static void peek() {
        if (underflow()) {
            System.out.println("Underflow");
            return;
        }
        System.out.println("Top: " + top.data);
    }

    public static void main(String[] args) {
        push(10);
        push(20);
        push(30);
        push(40);
        push(50);
        push(60);

        peek();

        pop();
        pop();

        peek();
    }
}