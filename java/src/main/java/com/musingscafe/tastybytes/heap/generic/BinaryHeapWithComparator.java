package com.musingscafe.tastybytes.heap.generic;

import com.musingscafe.tastybytes.heap.generic.BinaryHeap;

import java.util.Comparator;

/**
 * Created by ayadav on 1/2/17.
 */
public class BinaryHeapWithComparator <T> extends BinaryHeap<T> {
    private static final String MAX_HEAP = "max";
    private static final String MIN_HEAP = "min";
    private final String heapType;
    private final Comparator<T> comparator;

    public BinaryHeapWithComparator(boolean isMaxHeap, Comparator<T> comparator) {
        super(isMaxHeap);
        this.comparator = comparator;
        this.heapType = isMaxHeap ? MAX_HEAP : MIN_HEAP;
    }

    @Override
    protected void percolateUpMax(int index) {
        if (index <= 0) return;

        int parentIndex = findParent(index);

        if (parentIndex >= 0 && comparator.compare(heap.get(parentIndex), heap.get(index)) < 0) {
            swap(parentIndex, index);
            percolateUpMax(parentIndex);
        }
    }

    @Override
    protected void percolateDownMax(int index) {
        int left = findLeftChild(index);
        int right = findRightChild(index);
        int next = index;

        if (left != -1 && comparator.compare(heap.get(left), heap.get(index)) > 0) {
            next = left;
        }

        if (right != -1 && comparator.compare(heap.get(right), heap.get(next)) > 0) {
            next = right;
        }

        if (next != index) {
            swap(next, index);
            percolateDownMax(next);
        }
    }

    @Override
    protected void percolateUpMin(int index) {
        if (index <= 0) return;

        int parentIndex = findParent(index);

        if (parentIndex >= 0 && comparator.compare(heap.get(parentIndex), heap.get(index)) > 0) {
            swap(parentIndex, index);
            percolateUpMin(parentIndex);
        }
    }

    @Override
    protected void percolateDownMin(int index) {

        int left = findLeftChild(index);
        int right = findRightChild(index);
        int next = index;

        if (left != -1 && comparator.compare(heap.get(left), heap.get(index)) < 0) {
            next = left;
        }

        if (right != -1 && comparator.compare(heap.get(right), heap.get(next)) < 0) {
            next = right;
        }

        if (next != index) {
            swap(next, index);
            percolateDownMin(next);
        }
    }
}
