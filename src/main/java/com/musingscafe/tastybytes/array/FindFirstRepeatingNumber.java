package com.musingscafe.tastybytes.array;

/**
 * Created by ayadav on 12/21/16.
 */
public class FindFirstRepeatingNumber {
    public static void main(String[] args) {
        findFirstRepeatingNumberBruteForce(new int[] {2,4,5,6,2,3});
    }

    private static void findFirstRepeatingNumberBruteForce(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] == array[j]) {
                    System.out.println(array[i]);
                    return;
                }
            }
        }

        System.out.println("No repeating number");
    }
}
