package com.musingscafe.tastybytes.tree;

import com.musingscafe.tastybytes.tree.support.BinaryTreeNode;
import com.musingscafe.tastybytes.tree.support.BinaryTreeUtil;

/**
 * Created by ayadav on 12/25/16.
 */
public class InsertANodeInBinarySearchTree {
    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeUtil.getSampleBinarySearchTree();
        BinaryTreeUtil.printInOrder(root);
        root = insert(root, 12);
        System.out.println();
        BinaryTreeUtil.printInOrder(root);
    }

    private static BinaryTreeNode insert(BinaryTreeNode root, int value) {
        if (root == null) {
            root = new BinaryTreeNode();
            root.setValue(value);
            return root;
        }

        if (root.getValue() < value) {
            root.setRight(insert(root.getRight(), value));
        }
        else if (root.getValue() > value) {
            root.setLeft(insert(root.getLeft(), value));
        }
        else {
            //ignore
        }

        return root;
    }
}
