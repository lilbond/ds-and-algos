package com.musingscafe.tastybytes.disjointsets.drivers;

/**
 * Created by ayadav on 12/28/16.
 */
public class Utility {
    /**
     * Just an extra function to display the set at a given point in time.
     */
    public static void print(int[] set, int N) {
        String output = "Index\t| ";
        for (int i = 0; i < N; i++) {
            output += i + "\t| ";
        }

        int length = output.length();
        output += "\n";
        for (int i = 0; i < length + 1; i++) {
            output += "-";
        }
        output += "\n";
        output += "Value\t| ";
        for (int i = 0; i < N; i++) {
            output += set[i] + "\t| ";
        }

        System.out.println(output);
    }
}
