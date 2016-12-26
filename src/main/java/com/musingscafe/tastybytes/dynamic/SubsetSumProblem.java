package com.musingscafe.tastybytes.dynamic;

import java.util.Arrays;

/**
 * Created by ayadav on 12/26/16.
 */
public class SubsetSumProblem {
    /*
    Given an array {2, 3, 7, 8 , 10} we need to find if a subset exists which will sum up to a given number, say 11.

    0 1 2 3 4 5 6 ...11

    if we can sum up to 2
    then if there exists a number or sub set which can give 11 by adding 2 then we have solution

    we can not use a number multiple times
     */

    public static void main(String[] args) {
        subSetSum(new int[]{2, 4} , 6);
    }

    private static void subSetSum(int[] array, int n) {
        int rows = array.length;
        int cols = n + 1;
        int[][] cache = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            cache[row][0] = 1;
        }
        Arrays.sort(array);

        for (int row = 0; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (col >= array[row]) {
                    if (col == array[row]) {
                        cache[row][col] = 1;
                    }
                    else if (row - 1 >= 0) {
                        if (cache[row - 1][col - array[row]] == 1) {
                            cache[row][col] = 1;
                        }
                    }
                    else {
                        cache[row][col] = 0;
                    }
                }
                else {
                    cache[row][col] = 0;
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(cache[row][col] + "\t");
            }

            System.out.println();
        }

        System.out.println(cache[rows - 1][cols - 1]);
    }
}
