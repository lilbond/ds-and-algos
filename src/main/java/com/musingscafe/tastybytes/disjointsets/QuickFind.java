package com.musingscafe.tastybytes.disjointsets;

import com.musingscafe.tastybytes.disjointsets.drivers.Utility;

/**
 * Created by ayadav on 12/28/16.
 */
/*
   Union (a, b) => sets value of 'b' for all components connected to 'a'

   FIXME: Fix if you need to: All operations assumes valid indexes.
 */
public class QuickFind {
    private final int[] set;
    private final int N;

    public QuickFind(int N) {
        this.N = N;
        this.set = new int[N];

        for (int i = 0; i < N; i++) {
            set[i] = i;
        }
    }

    public void union(int a, int b) {
        int ida = set[a];
        int idb = set[b];

        for (int i = 0; i < N; i++) {
            if (set[i] == ida) {
                set[i] = idb;
            }
        }
    }

    public boolean areConnected(int a, int b) {
        return set[a] == set[b];
    }

    public void print() {
        Utility.print(set, N);
    }
}
