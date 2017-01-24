package com.musingscafe.tastybytes.heap.drivers;

import com.musingscafe.tastybytes.heap.generic.BinaryComparableHeap;
import com.musingscafe.tastybytes.heap.generic.BinaryHeap;
import com.musingscafe.tastybytes.heap.generic.BinaryHeapWithComparator;

/**
 * Created by ayadav on 1/2/17.
 */
public class BinaryHeapDriver {
    public static void main(String[] args) {
        BinaryHeap<Task> tasks = new BinaryHeapWithComparator<>(false, new TaskComparator());
        BinaryHeap<ComparableTask> comparableTasks = new BinaryComparableHeap<>(false);

        tasks.insert(new Task(12, "12"));
        tasks.printLinear();

        tasks.insert(new Task(2, "2"));
        tasks.printLinear();

        tasks.insert(new Task(11, "11"));
        tasks.printLinear();

        tasks.insert(new Task(1, "11"));
        tasks.printLinear();

        comparableTasks.insert(new ComparableTask(12, "12"));
        comparableTasks.printLinear();

        comparableTasks.insert(new ComparableTask(2, "2"));
        comparableTasks.printLinear();

        comparableTasks.insert(new ComparableTask(11, "11"));
        comparableTasks.printLinear();

        comparableTasks.insert(new ComparableTask(1, "11"));
        comparableTasks.printLinear();

        System.out.println("--------test find--------\n");

        System.out.println(tasks.peek());
        System.out.println(comparableTasks.peek());

        System.out.println("-------Test delete-------\n");

        System.out.println(tasks.delete());
        System.out.println(comparableTasks.delete());

        tasks.printLinear();
        comparableTasks.printLinear();

        System.out.println(tasks.delete());
        System.out.println(comparableTasks.delete());

        tasks.printLinear();
        comparableTasks.printLinear();
    }
}
