package com.musingscafe.tastybytes.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ayadav on 1/2/17.
 */
public class StringPermutation {
    public static void main(String[] args) {
        permute("man");
    }

    private static void permute(String string) {
        char[] chars = string.toCharArray();

        permuteUtil(chars, 0);
    }

    private static void permuteUtil(char[] chars, int start) {
        if (start == chars.length - 1) {
            print(chars);
            return;
        }

        for (int i = start; i < chars.length; i++) {
            char[] temp = Arrays.copyOf(chars, chars.length);
            char tempChar = temp[start];
            temp[start] = chars[i];
            temp[i] = tempChar;
            permuteUtil(temp, start + 1);
        }
    }

    private static void print(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        System.out.println();
    }
}
