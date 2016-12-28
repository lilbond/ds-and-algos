package com.musingscafe.tastybytes.disjointsets;

import com.musingscafe.tastybytes.disjointsets.drivers.Utility;

/**
 * Created by ayadav on 12/28/16.
 */
/*
    Each element's value will be it's root.
    e.g. 3 points to 4 and 4 points to 9

    We will have forests. Root of forest will point to itself.
    e.g. 9's value is 9.

    0   1   9   4   9   6   6   7   8   9

    0   1   9   6   7   8
          / |   |
         2  4   5
            |
            3

  FIXME: Fix if you need to: All operations assumes valid indexes.
 */
public class QuickUnion {
    private final int[] set;
    private final int N;

    public QuickUnion(int N) {
        this.N = N;
        this.set = new int[N];

        for (int i = 0; i < N; i++) {
            set[i] = i;
        }
    }

    private int root(int a) {
        int value = a;

        while (value != set[value]) {
            value = set[value];
        }

        return value;
    }

    public void union(int a, int b) {
        int ida = root(a);
        int idb = root(b);
        set[ida] = set[idb];
    }

    public boolean areConnected(int a, int b) {
        int ida = root(a);
        int idb = root(b);

        return ida == idb;
    }

    public void print() {
        Utility.print(set, N);
    }
}
