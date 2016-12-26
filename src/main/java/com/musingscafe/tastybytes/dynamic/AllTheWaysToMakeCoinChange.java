package com.musingscafe.tastybytes.dynamic;

/**
 * Created by ayadav on 12/25/16.
 */
public class AllTheWaysToMakeCoinChange {

    public static void main(String[] args) {
        coinChange(11, new int[] {2, 5, 6, 8});
    }

    private static void coinChange(int N, int[] values) {
        int M = values.length;
        long[] cache = new long[N + 1];
        cache[0] = 1;
        for (int j = 0; j < M; j++) {
            for (int i = 1; i <= N; i++) {
                if (i >= values[j]) {
                    cache[i] += cache[i - values[j]];
                }
            }
        }

        System.out.println(cache[N]);
    }
}
