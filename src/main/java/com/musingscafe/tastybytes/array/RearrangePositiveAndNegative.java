package com.musingscafe.tastybytes.array;

/**
 * Created by ayadav on 12/21/16.
 */
public class RearrangePositiveAndNegative {

    /**
     * Rearrange array in alternating positive and negative number
     *
     */
    public static void main(String[] args) {
        int[] array = new int[] { 6, -2, 4, -3, 5, 6 };
        rearrange(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static void rearrange(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            if (i % 2 != 0 ) {
                //search positive
                if (array[i] > 0) continue;
                else {
                    if (!findPositive(array, length, i)) {
                        return;
                    }
                }
            }
            else {
                //search negative
                if (array[i] < 0) continue;
                else {
                    if (!findNegative(array, length, i)) {
                        return;
                    }
                }
            }
        }
    }

    private static boolean findNegative(int[] array, int length, int i) {
        if (i + 1 < length) {
            for (int j = i + 1; j < length; j++) {
                if (array[j] < 0) {
                    swap(array, i, j);
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean findPositive(int[] array, int length, int i) {
        if (i + 1 < length) {
            for (int j = i + 1; j < length; j++) {
                if (array[j] > 0) {
                    swap(array, i, j);
                    return true;
                }
            }
        }
        return false;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
