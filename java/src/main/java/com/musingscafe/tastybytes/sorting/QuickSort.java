package com.musingscafe.tastybytes.sorting;

import com.musingscafe.tastybytes.utility.Util;

/**
 * Created by ayadav on 1/1/17.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 1, 3, 7, 9, 2};
        //int[] array = new int[]{10, 8, 7, 4, 0, 1, -1};

        Util.printArray(array);
        Util.newLine();

        quickSort(array, 0, array.length - 1);

    }

    private static void quickSort(int[] array, int start, int end) {
        if (start < 0 || start > end || end < 0) return;
        if (start == end) return;

        int i = partition(array, start, end);

        quickSort(array, start, i - 1);
        quickSort(array, i + 1, end);

    }

    private static int partition(int[] array, int start, int end) {
        int i = start - 1;
        int j = start;
        int pivot = array[start];

        for (; j <= end; j++) {
            if (pivot >= array[j]) {
                i++;
                Util.swapArrayElement(array, i, j);
            }
        }

        if (i > 0)
            Util.swapArrayElement(array, i , start);

        Util.printArray(array);
        Util.newLine();
        return i;
    }
}
