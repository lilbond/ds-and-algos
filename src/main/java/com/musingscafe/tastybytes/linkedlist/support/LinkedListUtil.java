package com.musingscafe.tastybytes.linkedlist.support;

/**
 * Created by ayadav on 12/28/16.
 */
public class LinkedListUtil {
    public static Node getSampleLinkedList(int count) {
        return createList(null, 1, count);
    }

    private static Node createList(Node head, int start, int end) {
        if (start < 1 || start > end) return null;
        if (head == null) {
            head = new Node();
        }

        head.setValue(start);
        head.setNext(createList(new Node(), start + 1, end));
        return head;
    }

    public static void print(Node head) {
        if (head == null) return;

        System.out.println(head.getValue());
        print(head.getNext());
    }
}
