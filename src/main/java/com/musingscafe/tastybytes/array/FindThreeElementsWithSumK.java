package com.musingscafe.tastybytes.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayadav on 12/28/16.
 */
/*
Given an array on n elements. Find three elements in the array such that their sum is equal to given element k.
 */
public class FindThreeElementsWithSumK {
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        findElements(array, 21);
    }

    private static void findElements(int[] array, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            }
        }

        for (int i = 0; i < array.length; i++) {
            for(Integer key: map.keySet()) {
                if (array[i] != key) {
                    int y = array[i];
                    int x = k - (key + y);
                    if (map.containsKey(k - (key + y)) && x != y && x != key) {
                        System.out.println(y + ", " + key + ", " + x);
                        return;
                    }
                }
            }
        }
    }
}
