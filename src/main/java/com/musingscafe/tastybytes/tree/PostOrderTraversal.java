package com.musingscafe.tastybytes.tree;

import com.musingscafe.tastybytes.tree.support.BinaryTreeNode;
import com.musingscafe.tastybytes.tree.support.BinaryTreeUtil;

/**
 * Created by ayadav on 12/24/16.
 */
public class PostOrderTraversal {
    public static void main(String[] args) {
        postOrder(BinaryTreeUtil.getSampleTree());
    }

    private static void postOrder(BinaryTreeNode root) {
        if (root == null) return;

        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.println(root.getValue());

    }
}
