package com.musingscafe.tastybytes.heap;

/**
 * Created by ayadav on 1/2/17.
 */
public class MinHeapDriver {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(11);
        minHeap.printLinear();
        //System.out.println(minHeap.findMin());

        minHeap.insert(5);
        minHeap.printLinear();
        //System.out.println(minHeap.findMin());

        minHeap.insert(3);
        minHeap.printLinear();
        //System.out.println(minHeap.findMin());

        minHeap.insert(12);
        minHeap.printLinear();
        //System.out.println(minHeap.findMin());

        minHeap.insert(2);
        minHeap.printLinear();
        //System.out.println(minHeap.findMin());

        minHeap.insert(1);
        minHeap.printLinear();
        //System.out.println(minHeap.findMin());

        System.out.println(minHeap.deleteMin());
        minHeap.printLinear();
    }
}
