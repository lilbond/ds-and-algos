package com.musingscafe.tastybytes.sorting;

import com.musingscafe.tastybytes.utility.Util;

/**
 * Created by ayadav on 1/7/17.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] array = new int[] {4,21,5,65,12,76,82,6,90,0,61};

        Util.printArrayAndNewLine(array);
        heapSort(array, 0);
        Util.printArrayAndNewLine(array);
    }

    static int end = 0;
    private static void heapSort(int[] array, int start) {
        end = array.length - 1;

        //heapify
        for (int i = array.length / 2; i >= 0; i--) {
            percolateDown(i, array);
        }

        //now swap first, last and heapify
        for (int i = array.length - 1; i >= 0; i--) {
            Util.swapArrayElement(array, i, 0);
            percolateDown(0, array);
            end = end - 1;
        }
    }

    private static int findLeftChild(int index) {
        int left = (2 * index + 1);
        if (left >= end) return -1;
        return left;
    }

    private static int findRightChild(int index) {
        int right = (2 * index + 2);
        if (right >= end) return -1;
        return right;
    }

    private static void percolateDown(int index, int[] heap) {
        int left = findLeftChild(index);
        int right = findRightChild(index);
        int max = index;

        if (left != -1 && heap[left] > heap[index]) {
            max = left;
        }

        if (right != -1 && heap[right] > heap[max]) {
            max = right;
        }

        if (max != index) {
            Util.swapArrayElement(heap, index, max);
            percolateDown(max, heap);
        }

    }
}
