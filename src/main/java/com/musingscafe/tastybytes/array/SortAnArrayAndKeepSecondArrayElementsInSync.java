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

    /*
    in partitioning will take start element and try to find the point where it would reside, which means
    it should be at correct position after partitioning. Elements smaller than it should be at its left and elements
    greater than it should be at right.

    i = 0
    {4, 2, 8, 6} if we start with 4
    if we find any element which is greater than 4 then we increment i
    2 is not
    move to 8
    8 is greater than 4
     */

    private static int parition() {

        return 0;
    }
}
