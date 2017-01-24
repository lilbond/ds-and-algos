package com.musingscafe.tastybytes.sorting;

import com.musingscafe.tastybytes.utility.Util;

import java.util.Random;

public class CountingSort {
    //numbers from 1 to 10
    public static void main(String[] args) {
        int k = 20;
        int[] array = new int[k];
        Random random = new Random(10);
        for (int i = 0; i < k; i++) {
            array[i] = random.nextInt(10);
        }

        Util.printArrayAndNewLine(array);

        array = countSort(array, 10);

        Util.printArrayAndNewLine(array);
    }

    private static int[] countSort(int[] array, int n) {
        int[] sorted = new int[array.length];
        int[] range = new int[n];

        for (int i = 0; i < array.length; i++) {
            range[array[i]] += 1;
        }

        for (int i = 1; i < n; i++) {
            range[i] += range[i - 1];
        }

        for (int i = 0; i < array.length; ++i) {
            sorted[range[array[i]] - 1] = array[i];
            --range[array[i]];
        }

        return sorted;
    }
}
