import java.io.*;
import java.util.*;

public class Main {
    
    static final Scanner scanner = new Scanner(System.in);
    static final Queue<Integer> queue = new Queue<>();
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        menu();
    }
    
    public static void menu() {
        System.out.println("Enter number of queries: ");
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            
            String menu = """
                -- Menu --
                1- Add element
                2- Remove head
                3- Print head
            """;

            System.out.println(menu);
            
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> addElement();
                case 2 -> removeHead();
                case 3 -> printHead();
            }
        }
    }
    
    public static void addElement() {
        int element = scanner.nextInt();
        queue.addElement(element);
    }
    
    public static void removeHead() {
        queue.removeHead();
    }
    
    public static void printHead() {
        queue.printHead();
    }
}

class Queue<T> {
    Node<T> head;
    Node<T> tail;
    
    public Queue() {
        this.head = null;
        this.tail = null;
    }
    
    public void addElement(T element) {
        Node<T> node = new Node<T>(element);
        if (head == null) {
            this.head = node;
        } else {
            this.tail.setNext(node);
        }
        
        this.tail = node;
    }
    
    public void removeHead() {
        this.head = this.head.getNext();
    }
    
    public void printHead() {
        System.out.println(this.head);
    }
}

class Node<T> {
    private T data;
    private Node<T> next;
    
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    
    public T getData() { return this.data; }
    public Node<T> getNext() { return this.next; }
    public void setNext(Node<T> node) { this.next = node; }
    
    @Override
    public String toString() {
        return data.toString();
    }
}
