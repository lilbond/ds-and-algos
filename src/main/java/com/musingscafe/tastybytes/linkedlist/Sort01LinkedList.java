package com.musingscafe.tastybytes.linkedlist;

import com.musingscafe.tastybytes.linkedlist.support.LinkedListUtil;
import com.musingscafe.tastybytes.linkedlist.support.Node;

/**
 * Sort a linked with only zeros and ones
 */
public class Sort01LinkedList {
    public static void main(String[] args) {
        Node head = LinkedListUtil.getSample01LinkedList(20);

        LinkedListUtil.print(head);

        head = sortLinear(head);

        System.out.println();
        LinkedListUtil.print(head);
    }

    private static Node sortNonLinear(Node head) {
        Node zeroHead = null;
        Node oneHead = null;

        if (head == null) return head;

        Node temp = head;
        while (temp != null) {
            Node next = temp.getNext();
            temp.setNext(null);
            if (temp.getValue() == 0) {
                zeroHead = append(zeroHead, temp);
            }
            else if (temp.getValue() == 1) {
                oneHead = append(oneHead, temp);
            }
            else {
                throw new IllegalArgumentException("Expects 0s and 1s only");
            }
            temp = next;
        }

        if (zeroHead == null) head = oneHead;
        else {
            head = zeroHead;
        }

        return append(head, oneHead);
    }

    private static Node append(Node appendTo, Node newNode) {
        Node temp = appendTo;

        if (temp == null) {
            appendTo = newNode;
        }
        else {
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }

            temp.setNext(newNode);
        }

        return appendTo;
    }

    private static Node sortLinear(Node head) {
        Node zeroHead = null;
        Node oneHead = null;
        Node zeroTemp = zeroHead;
        Node oneTemp = oneHead;

        if (head == null) return head;

        Node temp = head;

        while (temp != null) {
            Node next = temp.getNext();
            temp.setNext(null);

            if (temp.getValue() == 0) {
                if (zeroTemp == null) {
                    zeroTemp = temp;
                    zeroHead = zeroTemp;
                }
                else {
                    zeroTemp.setNext(temp);
                    zeroTemp = zeroTemp.getNext();
                }
            }
            else if (temp.getValue() == 1) {
                if (oneTemp == null) {
                    oneTemp = temp;
                    oneHead = oneTemp;
                }
                else {
                    oneTemp.setNext(temp);
                    oneTemp = oneTemp.getNext();
                }
            }
            else {
                throw new IllegalArgumentException("Expects 0s and 1s only");
            }
            temp = next;
        }

        if (zeroHead == null) head = oneHead;
        else {
            zeroTemp.setNext(oneHead);
            head = zeroHead;
        }

        return head;
    }
}
