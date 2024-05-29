package com.example;

import org.junit.Test;

public class TASK2Test {

    @Test
    public void testAddAndPrintList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("Original list:");
        list.printList();
    }

    @Test
    public void testRemoveMiddle() {
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
