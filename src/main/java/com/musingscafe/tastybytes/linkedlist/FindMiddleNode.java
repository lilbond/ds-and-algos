package com.musingscafe.tastybytes.linkedlist;

import com.musingscafe.tastybytes.linkedlist.support.LinkedListUtil;
import com.musingscafe.tastybytes.linkedlist.support.Node;

/**
 * Created by ayadav on 12/28/16.
 */
public class FindMiddleNode {
    public static void main(String[] args) {
        Node even = LinkedListUtil.getSampleLinkedList(20);
        Node odd = LinkedListUtil.getSampleLinkedList(15);

        Node slow = null;
        Node fast = null;

        slow = findMiddle(odd, slow, fast);

        if (slow != null) {
            System.out.println(slow.getValue());
        }

        slow = null;
        slow = findMiddle(even, slow, fast);

        if (slow != null) {
            System.out.println(slow.getValue());
        }
    }

    private static Node findMiddle(Node head, Node slow, Node fast) {
        if (head == null) return null;
        if (slow == null) {
            slow = head;
            fast = head;
        }

        if (fast.getNext() == null || fast.getNext().getNext() == null) {
            return slow;
        }

        return findMiddle(head, slow.getNext(), fast.getNext().getNext());
    }
}
