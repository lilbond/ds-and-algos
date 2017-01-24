package com.musingscafe.tastybytes.heap.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayadav on 1/2/17.
 */
public abstract class BinaryHeap <T>{
    protected static final String MAX_HEAP = "max";
    protected static final String MIN_HEAP = "min";
    protected final String heapType;
    protected final List<T> heap;
    protected boolean isMaxHeap;

    public BinaryHeap(boolean isMaxHeap) {
        this.heapType = isMaxHeap ? MAX_HEAP : MIN_HEAP;
        this.heap = new ArrayList<T>();
        this.isMaxHeap = isMaxHeap;
    }

    protected int findParent(int index) {
        if (index <= 0 || index >= heap.size()) return -1;
        return (index - 1) / 2;
    }

    protected int findLeftChild(int index) {
        int left = (2 * index + 1);

        if (left >= heap.size()) return -1;

        return left;
    }

    protected int findRightChild(int index) {
        int right = (2 * index + 2);

        if (right >= heap.size()) return -1;

        return right;
    }

    protected void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void printLinear() {
        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }

    public void insert(T value) {
        heap.add(value);
        percolateUp(heap.size() - 1);
    }

    public T delete() {
        if (heap.size() == 0) return null;

        T top = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        percolateDown(0);
        return top;
    }

    public T peek() {
        if (heap.size() == 0) return null;
        return heap.get(0);
    }

    protected void percolateUp(int index) {
        if (heapType.equals(MAX_HEAP)) {
            percolateUpMax(index);
        }
        else {
            percolateUpMin(index);
        }
    }

    protected void percolateDown(int index) {
        if (heapType.equals(MAX_HEAP)) {
            percolateDownMax(index);
        }
        else {
            percolateDownMin(index);
        }
    }

    protected abstract void percolateUpMin(int index);
    protected abstract void percolateUpMax(int index);
    protected abstract void percolateDownMin(int index);
    protected abstract void percolateDownMax(int index);
}
