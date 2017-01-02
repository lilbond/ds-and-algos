package com.musingscafe.tastybytes.heap.drivers;

import com.musingscafe.tastybytes.heap.drivers.Task;

import java.util.Comparator;

/**
 * Created by ayadav on 1/2/17.
 */
public class TaskComparator implements Comparator<Task> {

    @Override
    public int compare(Task firstTask, Task secondTask) {
        if (firstTask.getPriority() < secondTask.getPriority()) {
            return -1;
        }
        else if (firstTask.getPriority() == secondTask.getPriority()) {
            return 0;
        }
        else {
            return 1;
        }
    }
}
