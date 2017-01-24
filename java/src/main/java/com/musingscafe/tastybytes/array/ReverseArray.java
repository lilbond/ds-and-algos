package com.musingscafe.tastybytes.array;

/**
 * Created by ayadav on 12/28/16.
 */
public class ReverseArray {
    public static void main(String[] args) {
        int[] even = new int[] {1, 2, 3, 4, 5, 6};
        int[] odd = new int[] {1, 2, 3, 4, 5, 6, 7};

        print(even, 0);
        System.out.println();
        reverse(even, 0, 5);
        print(even, 0);
        System.out.println("\n\n-----------------------------------\n");
        print(odd, 0);
        System.out.println();
        reverse(odd, 0, 6);
        print(odd, 0);

    }

    private static void reverse(int[] array, int start, int end) {
        if (start >= end) return;

        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;

        reverse(array, start + 1, end - 1);
    }

    private static void print(int[] array, int start) {
        if (start >= array.length) return;

        System.out.print(array[start] + " ");
        print(array, start + 1);
    }
}
