package com.musingscafe.tastybytes.dynamic;

import com.musingscafe.tastybytes.utility.Util;

/**
 * Created by ayadav on 1/21/17.
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        LCS("abcdaf".toCharArray(), "acbcf".toCharArray());
    }

    private static void LCS(char[] alpha, char[] beta) {
        int[][] T = new int[alpha.length + 1][beta.length + 1];

        for (int i = 1; i <= alpha.length; i++) {
            for (int j = 1; j <= beta.length; j++) {
                int left = T[i][j - 1];
                int top = T[i - 1][j];
                if (alpha[i - 1] == beta[j - 1]) {
                    T[i][j] = top + 1 > left ? top + 1: left;
                }
                else {
                    T[i][j] = top > left ? top : left;
                }
            }
        }

        Util.print2D(T, alpha.length + 1, beta.length + 1);
    }
}
