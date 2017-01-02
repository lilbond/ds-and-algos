package com.musingscafe.tastybytes.heap.generic;

import com.musingscafe.tastybytes.heap.generic.BinaryHeap;

/**
 * Created by ayadav on 1/2/17.
 */
public class BinaryComparableHeap <T extends Comparable> extends BinaryHeap<T> {
    public BinaryComparableHeap(boolean isMaxHeap) {
        super(isMaxHeap);
    }

    @Override
    protected void percolateUpMax(int index) {
        if (index <= 0) return;

        int parentIndex = findParent(index);

        if (parentIndex >= 0 && heap.get(parentIndex).compareTo(heap.get(index)) < 0) {
            swap(parentIndex, index);
            percolateUpMax(parentIndex);
        }
    }

    @Override
    protected void percolateDownMax(int index) {
        int left = findLeftChild(index);
        int right = findRightChild(index);
        int next = index;

        if (left != -1 && heap.get(left).compareTo(heap.get(index)) > 0) {
            next = left;
        }

        if (right != -1 && heap.get(right).compareTo(heap.get(next)) > 0) {
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

        if (parentIndex >= 0 && heap.get(parentIndex).compareTo(heap.get(index)) > 0) {
            swap(parentIndex, index);
            percolateUpMin(parentIndex);
        }
    }

    @Override
    protected void percolateDownMin(int index) {

        int left = findLeftChild(index);
        int right = findRightChild(index);
        int next = index;

        if (left != -1 && heap.get(left).compareTo(heap.get(index)) < 0) {
            next = left;
        }

        if (right != -1 && heap.get(right).compareTo(heap.get(next)) < 0) {
            next = right;
        }

        if (next != index) {
            swap(next, index);
            percolateDownMin(next);
        }
    }
}
