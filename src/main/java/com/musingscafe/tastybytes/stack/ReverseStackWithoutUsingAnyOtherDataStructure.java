package com.musingscafe.tastybytes.stack;

import java.util.Stack;

/**
 * Created by ayadav on 12/22/16.
 */
public class ReverseStackWithoutUsingAnyOtherDataStructure {

    public static void main(String[] args) {
        Stack<Character> chars = new Stack<Character>();
        chars.push('e');
        chars.push('d');
        chars.push('c');
        chars.push('b');
        chars.push('a');

        printStack(chars);
        System.out.println();
        reverseStack(chars);
        printStack(chars);

        System.out.println();
        slideBubble(chars);
        printStack(chars);
    }

    private static void reverseStack(Stack<Character> chars) {
        if (chars.isEmpty()) return;
        int length = chars.size();
        for (int i = 0; i < length - 1; i++) {
            char top = chars.pop();
            reverseStackUtil(chars, top, length - 1 - i);
        }
    }

    private static void reverseStackUtil(Stack<Character> chars, char top, int count) {
        if (count == 0) {
            chars.push(top);
            return;
        }

        char current = chars.pop();
        reverseStackUtil(chars, top, count - 1);
        chars.push(current);
    }

    private static void printStack(Stack<Character> chars) {
        if (chars.isEmpty()) return;

        char top = chars.pop();
        System.out.print(top + " ");
        printStack(chars);
        chars.push(top);
    }

    private static void slideBubble(Stack<Character> chars) {
        int n = chars.size();
        for (int i = 1; i < n; i++) {
            slide(1, n-i+1, chars);
        }

    }
    private static void slide(int start, int end, Stack<Character> stack) {
        if (end == start)
            return;
        Character first = stack.pop();
        Character second = stack.pop();
        stack.push(first);
        slide(start + 1, end, stack);
        stack.push(second);
    }

}
