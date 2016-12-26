package com.musingscafe.tastybytes.dynamic;

import java.util.Arrays;

/**
 * Created by ayadav on 12/26/16.
 */
public class MinimumNumberOfCoinsToMakeChange {
    public static void main(String[] args) {
        minimumCoins(new int[] {1, 5, 6, 8}, 11);
    }

    private static void minimumCoins(int[] coins, int amount) {
        int rows = coins.length;
        int cols = amount + 1;

        int[][] cache = new int[rows][cols];

        Arrays.sort(coins);

        for (int row = 0; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (col >= coins[row]) {
                    if (cache[row][col - coins[row]] + 1 < cache[row][col] || cache[row][col] == 0) {
                        cache[row][col] = cache[row][col - coins[row]] + 1;
                        continue;
                    }
                }
                cache[row][col] = cache[row - 1][col];
            }
        }


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(cache[row][col] + "\t");
            }

            System.out.println();
        }

        int min = Integer.MAX_VALUE;
        for (int row = 0; row < rows; row++) {
            if (cache[row][cols - 1] < min) {
                min = cache[row][cols - 1];
            }
        }

        System.out.println(min);
    }
}
