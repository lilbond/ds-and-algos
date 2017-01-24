package com.musingscafe.tastybytes.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayadav on 12/21/16.
 */
public class FindFirstRepeatingNumber {
    public static void main(String[] args) {

        findFirstRepeatingNumberBruteForce(new int[] {2,4,5, 5, 6,2,3});
        findFirstRepeatingNumberMap(new int[] {2, 4, 5, 5, 6,2,3});
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

    /**
     * Here we are putting index i + 1 as 0 * -1 would still be zero.
     * Thus, while using the value we should also subtract 1.
     */
    private static void findFirstRepeatingNumberMap(int[] array) {
        int length = array.length;
        int index = -1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], i + 1);
            }
            else {
                // for numbers which are repeating value will be negative
                int value = map.get(array[i]);
                if (value > 0) {
                    map.put(array[i],  value * -1);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > 0) {
                continue;
            }
            if (index == -1) {
                index = (-1 * entry.getValue()) - 1;
            }
            else if (index > (-1 * entry.getValue()) - 1){
                index = (-1 * entry.getValue()) - 1;
            }
        }

        if (index != -1) {
            System.out.println("First repeating number is : " + array[index]);
        }
        else {
            System.out.println("No repeating number");
        }
    }
}
