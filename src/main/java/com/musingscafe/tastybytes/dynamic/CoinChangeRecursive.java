package com.musingscafe.tastybytes.dynamic;

/**
 * Created by ayadav on 12/26/16.
 */
public class CoinChangeRecursive {
    public static void main(String[] args) {
        System.out.println(coinChangeRecursive(new int[] {1, 6, 12, 15}, 11, 0));
    }

    /*
    if coin is equal to amount return 1, else if coin is less than amount search for coinChange of amount - coin
    else return 0
     */

    //sorted array assumed
    private static int coinChangeRecursive(int[] coins, int amount, int start) {
        if (amount <= 0) return 0;
        if (start >= coins.length) return 0;

        int min = 0;
        if (amount == coins[start]) {
            min = 1;
        }
        else if (amount > coins[start]) {
            int a = coinChangeRecursive(coins, amount - coins[start], start);
            int b = coinChangeRecursive(coins, amount, start + 1);

            //increment only if we get the solution
            if (a > 0) a++;
            min = minimum(a, b);
        }
        else {
            min = 0;
        }

        return min;
    }

    private static int minimum(int i, int j) {
        if (i == 0) return j;
        if (j == 0) return i;

        return i < j ? i : j;
    }
}
