package com.musingscafe.tastybytes.sorting;

import com.musingscafe.tastybytes.heap.basic.MinHeap;

public class FindKMaxFromBillions {
    //instead of billions we can try with say 100/1000
    public static void main(String[] args) {
        int N = 1000;
        int[] array = new int[N];

//        for (int i = 0; i < N; i++) {
//            array[i] = i;
//        }

        for (int i = N - 1; i >= 0; i--) {
            array[i] = i;
        }

        kMax(array, 9);
    }

    //assume un-sorted
    private static void kMax(int[] array, int k) {
        //create a min heap of size k
        MinHeap minHeap = new MinHeap();
        for (int i = 0; i < k; i++) {
            minHeap.insert(array[i]);
        }

        for (int i = k; i < array.length; i++) {
            if (array[i] > minHeap.findMin()) {
                minHeap.deleteMin();
                minHeap.insert(array[i]);
            }
        }

        minHeap.printLinear();
    }
}
