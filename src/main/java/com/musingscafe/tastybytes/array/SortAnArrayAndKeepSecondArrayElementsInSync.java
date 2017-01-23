package com.musingscafe.tastybytes.array;

import com.musingscafe.tastybytes.utility.Util;

/**
 * Created by ayadav on 1/17/17.
 */
public class SortAnArrayAndKeepSecondArrayElementsInSync {
    public static void main(String[] args) {
        int[] starts = new int[] {3, 1, 7, 5};
        int[] finishes = new int[] {4, 2, 8, 6};

        sort(starts, finishes);
    }

    //using bubble sort
    private static void sort(int[] starts, int[] finishes) {

        for (int i = 0; i < finishes.length; i++) {
            for (int j = 1; j < finishes.length; j++) {
                if (finishes[i] > finishes[j]) {
                    Util.swapArrayElement(finishes, i, j);
                    Util.swapArrayElement(starts, i, j);
                }
            }
        }

        Util.printArrayAndNewLine(finishes);
        Util.printArrayAndNewLine(starts);
    }
}
