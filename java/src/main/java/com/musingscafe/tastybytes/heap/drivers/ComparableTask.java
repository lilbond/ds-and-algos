package com.musingscafe.tastybytes.heap.drivers;

/**
 * Created by ayadav on 1/2/17.
 */
public class ComparableTask implements Comparable <ComparableTask> {
    private final int priority;
    private final String name;

    public ComparableTask(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(ComparableTask task) {
        if (this.getPriority() < task.getPriority()) {
            return -1;
        }
        else if (this.getPriority() == task.getPriority()) {
            return 0;
        }
        else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.getPriority());
    }
}
