package com.musingscafe.tastybytes.greedy;

import java.util.Arrays;

/**
 * You have beer barrel of fixed capacity. You have N bottles of different capacity. These bottles keep beer chilled.
 * Once a bottle is open the beer start loosing the chill. Thus, you want to maximize the number of beer bottles that
 * you can fill with the provided beer, to enjoy more. If a bottle is not filled fully, it is not counted.
 */
public class HowManyBottlesCanBeFilled {

    public static void main(String[] args) {
        int[] bottles = new int[] {8, 5, 4, 3, 2};
        int capacity = 10;

        maximumBottles(bottles, capacity);
    }

    private static void maximumBottles(int[] bottles, int capacity) {
        Arrays.sort(bottles);

        int num = 0;
        for (int i = 0; i < bottles.length; i++) {
            if (capacity - bottles[i] >= 0) {
                num++;
                capacity -= bottles[i];
            }
        }

        System.out.println(num);
    }
}
