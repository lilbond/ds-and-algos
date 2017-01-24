package com.musingscafe.tastybytes.linkedlist;

import com.musingscafe.tastybytes.linkedlist.support.LinkedListUtil;
import com.musingscafe.tastybytes.linkedlist.support.Node;

/**
 * Created by ayadav on 12/28/16.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        Node even = LinkedListUtil.getSampleLinkedList(13);

        LinkedListUtil.print(even);
        System.out.println();
        Node temp = reverse(even);
        LinkedListUtil.print(temp);
    }

    private static Node reverse(Node head) {
        if (head == null) return null;

        return reverse(head, null);
    }

    private static Node reverse(Node head, Node reverseHead) {
        if (head == null) return reverseHead;

        Node temp = head;
        Node currentNext = head.getNext();
        temp.setNext(reverseHead);
        return reverse(currentNext, temp);
    }
}
