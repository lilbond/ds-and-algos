package com.musingscafe.tastybytes.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayadav on 1/2/17.
 */
public class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    private int findParent(int index) {
        if (index <= 0 || index >= heap.size()) return -1;

        return (index - 1) / 2;
    }

    private int findLeftChild(int index) {
        int left = 2 * index + 1;

        if (left <= 0 || left >= heap.size()) return -1;

        return left;
    }

    private int findRightChild(int index) {
        int right = 2 * index + 2;

        if (right <= 0 || right >= heap.size()) return -1;

        return right;
    }

    public Integer findMin() {
        if (heap.size() == 0) return null;

        return heap.get(0);
    }

    public void insert(int value) {
        heap.add(value);
        percolateUp(heap.size() - 1);
    }

    /**
     * Used internally, thus no bounds check
     * @param index
     */
    private void percolateUp(int index) {
        if (index <= 0) return;

        int parentIndex = findParent(index);

        if (heap.get(parentIndex) > heap.get(index)) {
            swap(index, parentIndex);
            percolateUp(parentIndex);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void printLinear() {
        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }

    public int deleteMin() {
        int min = heap.get(0);
        heap.set(0, heap.size() - 1);
        heap.remove(heap.size() - 1);

        percolateDown(0);
        return min;
    }

    private void percolateDown(int index) {
        int left = findLeftChild(index);
        int right = findRightChild(index);
        int min = index;

        if (left != -1 && heap.get(left) < heap.get(index)) {
            min = left;
        }

        if (right != -1 && heap.get(right) < heap.get(min)) {
            min = right;
        }

        if (min != index) {
            swap(index, min);
            percolateDown(min);
        }

    }

}
