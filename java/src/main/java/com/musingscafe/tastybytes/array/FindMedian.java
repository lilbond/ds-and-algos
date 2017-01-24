package com.musingscafe.tastybytes.array;

import com.musingscafe.tastybytes.utility.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ayadav on 12/31/16.
 */
public class FindMedian {
    public static void main(String[] args) {
        //int[] array = new int[]{10, 8, 7, 4, 0, 1, 3};
        int[] array = new int[]{10, 8, 7, 4, 0, 1, -1};

        System.out.println(selection(array, array.length / 2, 0, array.length - 1));
    }

    private static int selection(int[] array, int k, int start, int end) {
        if (start == end) return array[start];

        int i = partition(array, start, end);

        if (k == i) {
            return array[i];
        }
        else if (k < i) {
            return selection(array, k, start, i - 1);
        }
        else {
            return selection(array, k, i + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int i = start - 1;
        int j = start;
        int pivot = array[end];

        for (j = start; j <= end; j++) {
            if (pivot >= array[j]) {
                i++;
                Util.swapArrayElement(array, i, j);
            }
        }
        return i;
    }
}
