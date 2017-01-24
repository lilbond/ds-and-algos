package com.musingscafe.tastybytes.array;

/**
 * Created by ayadav on 12/23/16.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        binarySearch(array, -1);
        for (int i = 1; i < array.length + 1; i++) {
            binarySearch(array, i);
        }
        binarySearch(array, 20);

        System.out.println("------------------------------------------");

        binarySearchRecursive(array, -1);
        for (int i = 1; i < array.length + 1; i++) {
            binarySearchRecursive(array, i);
        }
        binarySearchRecursive(array, 20);
    }

    private static void binarySearch(int[] array, int n) {
        int length = array.length;

        int left = 0;
        int right = length - 1;
        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (n == array[mid]) {
                System.out.println("binarySearch Says: " + array[mid] + " : " + mid);
                return;
            }
            else if (n < array[mid]) {
                right = mid - 1;
                mid = left + (right - left) / 2;
            }
            else {
                left = mid + 1;
                mid = left + (right - left) / 2;
            }
        }

        System.out.println("binarySearch Says: We did not find the element");
    }

    private static void binarySearchRecursive(int[] array, int n) {

        int index = binarySearchRecursiveUtil(array, n, 0, array.length - 1);

        if (index >= 0) {
            System.out.println("binarySearchRecursive Says: " + array[index] + " : " + index);
        }
        else {
            System.out.println("binarySearchRecursive Says: We did not find the element");
        }
    }

    private static int binarySearchRecursiveUtil(int[] array, int n, int left, int right) {
        if (left > right || left < 0 || right > array.length - 1) return -1;
        int mid = left + (right - left) / 2;

        if (array[mid] == n) {
            return mid;
        }
        else if (array[mid] < n) {
            return binarySearchRecursiveUtil(array, n, mid + 1, right);
        }
        else {
            return binarySearchRecursiveUtil(array, n, left, mid - 1);
        }
    }
}
