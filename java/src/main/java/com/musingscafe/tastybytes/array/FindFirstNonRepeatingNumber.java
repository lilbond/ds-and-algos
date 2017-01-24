package com.musingscafe.tastybytes.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayadav on 12/21/16.
 */
public class FindFirstNonRepeatingNumber {
    public static void main(String[] args) {
        findFirstNonRepeatingNumberBruteForce(new int[] {1, 2, 3, 2, 4, 3, 4, 5, 1});
    }

    private static void findFirstNonRepeatingNumberBruteForce(int[] array) {
        int length = array.length;
        int index = -1;
        Map<Integer, List<Integer>> store = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < length; i++) {
            if (store.containsKey(array[i])) {
                List<Integer> values = store.get(array[i]);
                values.add(i);
                store.put(array[i], values);
            }
            else {
                final int finalI = i;
                store.put(array[i], new ArrayList<Integer>(){{add(finalI);}});
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry: store.entrySet()) {
            if (entry.getValue().size() == 1 && index == -1) {
                index = entry.getValue().get(0);
            }
            else if(entry.getValue().size() == 1 && index > entry.getValue().get(0)){
                index = entry.getValue().get(0);
            }
        }

        if (index != -1) {
            System.out.println("First non repeating number is : " + array[index]);
        }
        else {
            System.out.println("All repeating");
        }
    }
}
