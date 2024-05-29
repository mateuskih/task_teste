package com.example;

/**
 * Task here is to write a list. Each element must know the element before and
 * after it. Print out your list and them remove the element in the middle of
 * the list. Print out again.
 *
 */

class Node<T> {
    T data;
    Node<T> prev;
    Node<T> next;

    Node(T data) {
        this.data = data;
    }
}

public class TASK2 {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("Original list:");
        list.printList();

        list.removeMiddle();

        System.out.println("List after removing middle element:");
        list.printList();
    }
}

class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void removeMiddle() {
        if (head == null || head == tail) {
            head = null;
            tail = null;
        } else {
            Node<T> middle = findMiddle();
            if (middle.prev != null) {
                middle.prev.next = middle.next;
            } else {
                head = middle.next;
            }
            if (middle.next != null) {
                middle.next.prev = middle.prev;
            } else {
                tail = middle.prev;
            }
        }
    }

    private Node<T> findMiddle() {
        Node<T> slow = head;
        Node<T> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
