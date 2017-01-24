package com.musingscafe.tastybytes.heap.drivers;

import com.musingscafe.tastybytes.heap.basic.MaxHeap;

/**
 * Created by ayadav on 1/2/17.
 */
public class MaxHeapDriver {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();

        maxHeap.insert(11);
        maxHeap.printLinear();
        //System.out.println(minHeap.findMin());

        maxHeap.insert(5);
        maxHeap.printLinear();
        //System.out.println(minHeap.findMin());

        maxHeap.insert(3);
        maxHeap.printLinear();
        //System.out.println(minHeap.findMin());

        maxHeap.insert(12);
        maxHeap.printLinear();
        //System.out.println(minHeap.findMin());

        maxHeap.insert(2);
        maxHeap.printLinear();
        //System.out.println(minHeap.findMin());

        maxHeap.insert(1);
        maxHeap.printLinear();
        //System.out.println(maxHeap.findMax());

        System.out.println(maxHeap.delete());
        maxHeap.printLinear();

        System.out.println(maxHeap.delete());
        maxHeap.printLinear();

        System.out.println(maxHeap.delete());
        maxHeap.printLinear();

        System.out.println(maxHeap.delete());
        maxHeap.printLinear();
    }
}
