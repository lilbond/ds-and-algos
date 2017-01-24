package com.musingscafe.tastybytes.disjointsets.drivers;

import com.musingscafe.tastybytes.disjointsets.QuickFind;

/**
 * Created by ayadav on 12/28/16.
 */
public class QuickFindDriver {
    public static void main(String[] args) {
        QuickFind quickFind = new QuickFind(5);
        quickFind.union(0, 1);
        quickFind.union(3, 4);
        quickFind.union(4, 2);

        System.out.println(quickFind.areConnected(1,2));
        System.out.println(quickFind.areConnected(3,2));
        System.out.println();

        quickFind.print();

    }
}
