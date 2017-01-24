package com.musingscafe.tastybytes.heap.drivers;

/**
 * Created by ayadav on 1/2/17.
 */
public class Task {
    private final int priority;
    private final String name;

    public Task(int priority, String name) {
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
    public String toString() {
        return String.valueOf(this.getPriority());
    }
}
