package com.musingscafe.tastybytes.utility;

import java.util.List;

/**
 * Created by ayadav on 1/1/17.
 */
public class Util {
    public static void swapArrayElement(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void printArrayAndNewLine(int[] array) {
        printArray(array);
        newLine();
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void printList(List<Integer> list) {
        list.stream().forEach(System.out::println);
        newLine();
    }

    public static void newLine() {
        System.out.println();
    }
}
