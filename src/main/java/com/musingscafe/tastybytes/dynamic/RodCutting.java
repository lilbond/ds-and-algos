package com.musingscafe.tastybytes.dynamic;

/**
 * Created by ayadav on 12/27/16.
 */
/*
Given a rod of length n inches and a table of prices pi, i=1,2,…,n, write an algorithm to find the maximum
revenue rn obtain­able by cut­ting up the rod and sell­ing the pieces.
 */
public class RodCutting {
    public static void main(String[] args) {
        int[] sizes = new int[] {1, 2, 3, 4};
        int[] prices = new int[] {1, 5, 8, 9};

        System.out.println(rodCuttingRecursive(sizes, prices, 5, 0));
    }

    /*
    either we can choose a size or we do not. If we choose a size, then we are left
    with length - size.
     */
    private static int rodCuttingRecursive(int[] sizes, int[] prices, int length, int start) {
        if (length <= 0) return 0;
        if (start < 0 || start > sizes.length - 1) return 0;

        if (length == sizes[start]) return prices[start];

        int max = 0;
        if (length > sizes[start]) {
            int valueInclusive = rodCuttingRecursive(sizes, prices, length - sizes[start], start);
            int valueExclusive = rodCuttingRecursive(sizes, prices, length, start + 1);

            //add only if we got a result
            if (valueInclusive > 0) {
                valueInclusive += prices[start];
            }

            max = Math.max(valueInclusive, valueExclusive);
        }

        return max;
    }
}
