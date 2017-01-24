package com.musingscafe.tastybytes.stack;

import java.util.Stack;

/**
 * Created by ayadav on 12/24/16.
 */
public class StackWithMinimum {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int value) {
        stack.push(value);

        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    public int pop() {
        int value = stack.pop();

        if (minStack.peek() == value) {
            minStack.pop();
        }
        return value;
    }

    public int getMin() {
        return minStack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
