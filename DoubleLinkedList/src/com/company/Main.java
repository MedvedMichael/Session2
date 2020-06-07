package com.company;

public class Main {

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList(10);
        list.printList();
        System.out.println();
        list.restructureEvenItems();
        list.printList();
    }
}
