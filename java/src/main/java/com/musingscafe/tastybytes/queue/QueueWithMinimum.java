package com.musingscafe.tastybytes.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ayadav on 12/23/16.
 */
public class QueueWithMinimum {
    Queue<Integer> queue = new LinkedList<Integer>();
    LinkedList<Integer> minQueue = new LinkedList<Integer>();

    public void enqueue(int value) {
        queue.add(value);
        if (minQueue.isEmpty() || value < minQueue.get(minQueue.size() - 1)) {
            minQueue.add(value);
        }
    }

    //these methods will throw up if queue is empty
    public int dequeue() {
        int value = queue.remove();

        if (value == minQueue.get(0)) {
            minQueue.remove(0);
        }

        if (minQueue.isEmpty() || queue.peek() < minQueue.get(minQueue.size() - 1)) {
            minQueue.add(queue.peek());
        }

        return value;
    }

    public int min() {
        return minQueue.get(minQueue.size() - 1);
    }

    public static void main(String[] args) {
        QueueWithMinimum queueWithMinimum = new QueueWithMinimum();
        queueWithMinimum.enqueue(3);
        queueWithMinimum.enqueue(2);
        queueWithMinimum.enqueue(4);
        //queueWithMinimum.enqueue(1);

        System.out.println(queueWithMinimum.min());
        queueWithMinimum.dequeue();

        System.out.println(queueWithMinimum.min());
        queueWithMinimum.dequeue();

        System.out.println(queueWithMinimum.min());
        queueWithMinimum.dequeue();
    }
}
