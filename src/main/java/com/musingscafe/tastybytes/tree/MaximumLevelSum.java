package com.musingscafe.tastybytes.tree;

import com.musingscafe.tastybytes.tree.support.BinaryTreeNode;
import com.musingscafe.tastybytes.tree.support.BinaryTreeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ayadav on 12/22/16.
 */
public class MaximumLevelSum {
    public static void main(String[] args) {
        maximumLevelSum(BinaryTreeUtil.getSampleTree());
    }

    private static void maximumLevelSum(BinaryTreeNode root) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode temp = null;
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            while ((temp = queue.remove()) != null) {
                sum += temp.getValue();

                if (temp.getLeft() != null) queue.add(temp.getLeft());
                if (temp.getRight() != null) queue.add(temp.getRight());
            }

            if (max < sum) max = sum;

            //next level
            if (!queue.isEmpty() && queue.peek() != null) {
                sum = 0;
                queue.add(null);
            }
        }

        System.out.println(max);
    }

    //this can be implemented in another way as well
}
