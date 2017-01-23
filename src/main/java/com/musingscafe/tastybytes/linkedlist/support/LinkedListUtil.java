package com.musingscafe.tastybytes.linkedlist.support;

import java.util.Random;

/**
 * Created by ayadav on 12/28/16.
 */
public class LinkedListUtil {
    public static Node getSampleLinkedList(int count) {
        return createList(null, 1, count);
    }

    public static Node getSample01LinkedList(int count) {
        Node head = createList(null, 1, count);

        Random random = new Random(100);

        Node temp = head;
        while (temp != null) {
            int rand = random.nextInt();
            if (rand % 2 == 0)
                temp.setValue(0);
            else
                temp.setValue(1);

            temp = temp.getNext();
        }

        return head;
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

        System.out.print(head.getValue() + " ");
        print(head.getNext());
    }
}
