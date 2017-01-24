package com.musingscafe.tastybytes.tree;

import com.musingscafe.tastybytes.tree.support.BinaryTreeNode;
import com.musingscafe.tastybytes.tree.support.BinaryTreeUtil;

/**
 * Created by ayadav on 12/24/16.
 */
public class FindIfAPathOfGivenSumExistsInBinaryTree {
    public static void main(String[] args) {
        findIfExists(BinaryTreeUtil.getSampleTree(), 7);
        findIfExists(BinaryTreeUtil.getSampleTree(), 10);
        findIfExists(BinaryTreeUtil.getSampleTree(), 9);
    }

    private static void findIfExists(BinaryTreeNode root, int sum) {
        if (findIfExistsUtil(root, sum, 0)) {
            System.out.println("Exists");
        }
        else {
            System.out.println("Does not exists");
        }
    }

    private static boolean findIfExistsUtil(BinaryTreeNode root, int sum, int sumSoFar) {
        if (root == null) return false;
        if (sum == sumSoFar + root.getValue()) return true;

        boolean left = findIfExistsUtil(root.getLeft(), sum, sumSoFar + root.getValue());
        boolean right = findIfExistsUtil(root.getRight(), sum, sumSoFar + root.getValue());

        return left || right;
    }
}
