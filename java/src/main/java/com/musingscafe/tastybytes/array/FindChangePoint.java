package com.musingscafe.tastybytes.array;

/**
 * There is an array of integers. It has n numbers. Number at index 0 to k are increasing
 * and numbers from k to n are decreasing. Find k, the change point
 */
public class FindChangePoint {
    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 6, 5, 4, 3, 2, 1 };
        findChangePoint(array);
    }

    private static void findChangePoint(int[] array) {
        int index = findChangePointUtil(array, 0, array.length - 1);

        if (index == - 1) {
            System.out.println("no change point");
        }
        else {
            System.out.println("Change point at : " + index + " and value is : " + array[index]);
        }
    }

    private static int findChangePointUtil(int[] array, int left, int right) {
        if (left > right || left < 0 || right > array.length - 1) return -1;

        int mid = left + (right - left) / 2;

        if (mid - 1 < 0 || mid + 1 > array.length - 1) return -1;

        //it is still increasing move to right
        if (array[mid - 1] < array[mid] && array[mid] < array[mid + 1]) {
            return findChangePointUtil(array, mid + 1, right);
        }
        else if (array[mid - 1] > array[mid] && array[mid] > array[mid + 1]) {
            //move left
            return findChangePointUtil(array, left, mid - 1);
        }
        else {
            //got the change point
            return mid;
        }
    }
}
