package com.musingscafe.tastybytes.heap.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayadav on 1/2/17.
 */
public class MaxHeap {
    private List<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    private int findParent(int index) {
        if (index <= 0 || index >= heap.size()) return -1;
        return (index - 1) / 2;
    }

    private int findLeftChild(int index) {
        int left = (2 * index + 1);

        if (left >= heap.size()) return -1;

        return left;
    }

    private int findRightChild(int index) {
        int right = (2 * index + 2);

        if (right >= heap.size()) return -1;

        return right;
    }

    public Integer findMax() {
        if (heap.size() == 0) return null;

        return heap.get(0);
    }

    public void insert(int value) {
        heap.add(value);

        percolateUp(heap.size() - 1);
    }

    private void percolateUp(int index) {
        if (index <= 0) return;

        int parentIndex = findParent(index);

        if (parentIndex >= 0 && heap.get(parentIndex) < heap.get(index)) {
            swap(parentIndex, index);
            percolateUp(parentIndex);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public Integer delete() {
        if (heap.size() == 0) return null;

        int max = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        percolateDown(0);
        return max;
    }

    private void percolateDown(int index) {
        //if (index < 0 || index > heap.size() - 1) return;

        int left = findLeftChild(index);
        int right = findRightChild(index);
        int max = index;

        if (left != -1 && heap.get(left) > heap.get(index)) {
            max = left;
        }

        if (right != -1 && heap.get(right) > heap.get(max)) {
            max = right;
        }

        if (max != index) {
            swap(max, index);
            percolateDown(max);
        }
    }

    public void printLinear() {
        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }
}
