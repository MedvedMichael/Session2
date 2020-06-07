package com.company;

public class DoubleLinkedList {
    ListItem first, last;
    int size;

    DoubleLinkedList(int numberOfElements) {
        this.size = numberOfElements;
        generateList();
    }

    void generateList() {
        first = new ListItem(Math.random() * 100);
        last = first;
        for (int i = 0; i < size - 1; i++) {
            ListItem newItem = new ListItem(Math.random() * 100);
            last.next = newItem;
            newItem.previous = last;
            last = newItem;
        }
    }

    void restructureEvenItems() {
        ListItem current = first;
        for (int i = 0; i < size; i += 2) {
            ListItem prevItem = current.previous, nextItem = current.next;
            nextItem.previous = prevItem;
            if (prevItem != null)
                prevItem.next = nextItem;
            last.next = current;
            current.previous = last;
            current.next = null;
            last = current;

            if(i==0)
                first = nextItem;
            
            current = nextItem.next;
        }
    }

    void printList() {
        ListItem current = first;
        for (int i = 0; i < size; i++) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}

class ListItem {
    double value;
    ListItem previous, next;

    ListItem(double value) {
        this.value = value;
    }
}
