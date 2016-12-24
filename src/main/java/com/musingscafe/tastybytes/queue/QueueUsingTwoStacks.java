package com.musingscafe.tastybytes.queue;

import java.util.Stack;

/**
 * Created by ayadav on 12/24/16.
 */
public class QueueUsingTwoStacks {
    Stack<Integer> firstStack = new Stack<Integer>();
    Stack<Integer> secondStack = new Stack<Integer>();

    public void enqueue(int value) {
        firstStack.push(value);
    }

    public int dequeue() throws Exception {
        if (secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }

        if (secondStack.isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return secondStack.pop();
    }

    public boolean isEmpty() {
        return (firstStack.isEmpty() && secondStack.isEmpty());
    }

    public static void main(String[] args) throws Exception {
        QueueUsingTwoStacks queueUsingTwoStacks = new QueueUsingTwoStacks();
        queueUsingTwoStacks.enqueue(1);
        queueUsingTwoStacks.enqueue(2);
        queueUsingTwoStacks.enqueue(3);
        queueUsingTwoStacks.enqueue(4);

        System.out.println(queueUsingTwoStacks.isEmpty());

        System.out.println(queueUsingTwoStacks.dequeue());
        System.out.println(queueUsingTwoStacks.dequeue());
        System.out.println(queueUsingTwoStacks.dequeue());
        System.out.println(queueUsingTwoStacks.dequeue());

        //answer should 1->2->3->4

        System.out.println(queueUsingTwoStacks.isEmpty());

        //this will throw
        try {
            System.out.println(queueUsingTwoStacks.dequeue());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
