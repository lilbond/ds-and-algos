package com.musingscafe.tastybytes.dynamic;

import com.musingscafe.tastybytes.utility.Util;

import java.util.Arrays;

public class KnapsackInfinite {

    public static void main(String[] args) {
        executeInfiniteKnapsack();
    }


    private static Item newItem(int w, int v) {
        Item item = new Item();
        item.weight = w;
        item.value = v;
        return item;
    }

    private static void executeInfiniteKnapsack() {
        Item[] items = new Item[3];
        items[0] = newItem(1, 2);
        items[1] = newItem(2, 5);
        items[2] = newItem(3, 6);

        knapSackInfinite(items, 7);
    }

    private static void knapSackInfinite(Item[] items, int weight) {
        int[][] T = new int[items.length + 1][weight + 1];
        Arrays.sort(items);

        for (int i = 1; i <= items.length; i++) {
            for (int j = 1; j <= weight; j++) {
                int whenNotPicked = T[i - 1][j];
                if (j >= items[i - 1].weight) {
                    int whenPicked = T[i][j - items[i - 1].weight] + items[i - 1].value;
                    T[i][j] = whenNotPicked > whenPicked ? whenNotPicked  : whenPicked;
                }
                else {
                    T[i][j] = whenNotPicked;
                }
            }
        }

        Util.print2D(T, items.length + 1, weight + 1);
    }


}

class Item implements Comparable<Item> {
    public int weight;
    public int value;
    @Override
    public int compareTo(Item item) {
        if (this.weight > item.weight) return 1;
        else if (this.weight == item.weight) return 0;
        else return -1;
    }
}
