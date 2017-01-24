package com.musingscafe.tastybytes.array;

/**
 * Created by ayadav on 12/27/16.
 */
/*
Given a sorted array of n elements, possibly with duplicates. Find the number of occurrences of a given number.
 */
public class CountOccurrence {
    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 3, 4, 5, 6, 6, 6, 6, 6};

        System.out.println(count(array, 6, 0));
        System.out.println(countOptimal(array, 6, 0, array.length - 1));
    }

    private static int count(int[] array, int n, int start) {
        if (start < 0 || start > array.length - 1) return 0;

        int value = 0;
        if (array[start] == n) value = 1;

        return count(array, n, start + 1) + value;
    }

    private static int countOptimal(int[] array, int n, int start, int end) {
        int index = find(array, n, 0, array.length - 1);

        if (index >= 0) {
            int previous = countBackward(array, n, index - 1);
            int next = count(array, n, index + 1);

            return previous + 1 + next;
        }

        return 0;
    }

    private static int find(int[] array, int n, int start, int end) {
        if (start > array.length - 1 || end < 0) return -1;

        int mid = start + (end - start) / 2;

        if (array[mid] == n) return mid;
        else if (array[mid] < n) return find(array, n, mid + 1, end);
        else return find(array, n, start, mid - 1);
    }

    private static int countBackward(int[] array, int n, int start) {
        //no upper limit check, no current index check
        if (start < 0) return 0;

        int value = 0;
        if (array[start] == n) value = 1;

        return countBackward(array, n, start - 1) + value;
    }
}
