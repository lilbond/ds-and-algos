package com.musingscafe.tastybytes.queue;

import com.musingscafe.tastybytes.stack.StackWithMinimum;

/**
 * Created by ayadav on 12/24/16.
 */
public class QueueWithMinimumWithTwoStacks {
    StackWithMinimum first = new StackWithMinimum();
    StackWithMinimum second = new StackWithMinimum();

    public void enqueue(int value) {
        first.push(value);
    }

    //these methods will throw up if queue is empty
    public int dequeue() throws Exception {
        if (second.isEmpty()) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
        }

        if (second.isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return second.pop();
    }

    public int min() {
        if (first.isEmpty()) {
            return second.getMin();
        }
        else if (second.isEmpty()){
            return first.getMin();
        }
        return first.getMin() < second.getMin() ? first.getMin() : second.getMin();
    }

    public static void main(String[] args) throws Exception {
        QueueWithMinimumWithTwoStacks queueWithMinimumWithTwoStacks = new QueueWithMinimumWithTwoStacks();
        queueWithMinimumWithTwoStacks.enqueue(3);
        queueWithMinimumWithTwoStacks.enqueue(2);
        queueWithMinimumWithTwoStacks.enqueue(4);

        System.out.println(queueWithMinimumWithTwoStacks.min());
        queueWithMinimumWithTwoStacks.dequeue();

        System.out.println(queueWithMinimumWithTwoStacks.min());
        queueWithMinimumWithTwoStacks.dequeue();

        System.out.println(queueWithMinimumWithTwoStacks.min());
        queueWithMinimumWithTwoStacks.dequeue();
    }
}
