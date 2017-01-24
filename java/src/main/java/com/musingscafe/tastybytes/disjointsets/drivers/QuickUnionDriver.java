package com.musingscafe.tastybytes.disjointsets.drivers;

import com.musingscafe.tastybytes.disjointsets.QuickUnion;

/**
 * Created by ayadav on 12/28/16.
 */
public class QuickUnionDriver {
    public static void main(String[] args) {
        QuickUnion quickUnion = new QuickUnion(10);
        quickUnion.union(3, 4);
        quickUnion.union(4, 9);
        quickUnion.union(2, 9);
        quickUnion.union(5, 6);

        System.out.println(quickUnion.areConnected(5, 2));
        System.out.println(quickUnion.areConnected(3, 9));
        System.out.println();
        quickUnion.print();
        System.out.println();

        quickUnion.union(3, 5);

        System.out.println(quickUnion.areConnected(5, 2));
        System.out.println(quickUnion.areConnected(3, 9));
        System.out.println();
        quickUnion.print();
        System.out.println();
    }
}
