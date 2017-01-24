package com.musingscafe.tastybytes.stack;

/**
 * Created by ayadav on 12/24/16.
 */
public class StackWithMinimumDriver {
    public static void main(String[] args) {
        StackWithMinimum stackWithMinimum = new StackWithMinimum();
        stackWithMinimum.push(3);
        stackWithMinimum.push(4);
        stackWithMinimum.push(5);
        stackWithMinimum.push(1);

        System.out.println(stackWithMinimum.getMin());
        stackWithMinimum.pop();

        System.out.println(stackWithMinimum.getMin());
        stackWithMinimum.pop();

        System.out.println(stackWithMinimum.getMin());
        stackWithMinimum.pop();
    }
}
