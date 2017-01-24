package com.musingscafe.tastybytes.array;

import java.util.Arrays;

/**
 * Created by ayadav on 12/22/16.
 */
public class FindMissingNumberBetweenOneToHundred {
    public static void main(String[] args) {
        int[] array = new int[] {1 , 2, 3, 4, 5, 7, 10, 9, 8};

        findMissingNumberNSquare(array, 10);
        findMissingNumberSort(array, 10);
        findingMissingNumber(array, 10);
    }

    private static void findMissingNumberNSquare(int[] array, int n) {

        /**
         * let's check for all the numbers from 1 to n (n being 100 in this case),
         * whether the number is in array or not. This will need n x n iterations
         * in worst case and thus complexity would be O(n^2)
         */
        int length = array.length;
        boolean existsInArray = false;
        for (int i = 1; i <= n; i++) {
            existsInArray = false;

            for (int j = 0; j < length; j++) {
                if (array[j] == i) {
                    existsInArray = true;
                }
            }

            if (!existsInArray) {
                System.out.println(i);
                return;
            }
        }
    }

    private static void findMissingNumberSort(int[] array, int n) {
        /**
         * let's sort the the array and iterate over it. If we did not
         * find a number, we got our answer. Sorting the array would have
         * a complexity of O(nlogn) and then scanning the array would be
         * O(n). Thus, the overall complexity would be O(nlogn).
         */

        Arrays.sort(array);

        for (int i = 0; i < n; i++) {
            if (array[i] != i + 1) {
                System.out.println(i + 1);
                return;
            }
        }
    }

    private static void findingMissingNumber(int[] array, int n) {
        /**
         * Find sum n consecutive numbers (A.P)
         */
        int sumOfConsecutiveNumbers = (n) * (n + 1) / 2;

        int sumOfArrayInHand = 0;

        //Find actual sum of integers in array
        for(int i = 0; i < array.length; i++){
            sumOfArrayInHand += array[i];
        }

        //return the difference of expected and actual sum. You have your missing integer
        System.out.println(sumOfConsecutiveNumbers - sumOfArrayInHand);
    }
}
