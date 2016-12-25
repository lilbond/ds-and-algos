package com.musingscafe.tastybytes.tree;

import com.musingscafe.tastybytes.tree.support.BinaryTreeNode;
import com.musingscafe.tastybytes.tree.support.BinaryTreeUtil;

/**
 * Created by ayadav on 12/24/16.
 */
public class DeleteANodeInBinarySearchTree {
    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeUtil.getSampleBinarySearchTree();
        printInOrder(root);
        root = delete(root, 2);
        System.out.println();
        printInOrder(root);

    }

    private static BinaryTreeNode delete(BinaryTreeNode root, int key) {
        if (root == null) return root;
        BinaryTreeNode temp = null;

        //we got the key
        if (root.getValue() == key) {
            if (root.getLeft() != null && root.getRight() != null) {
                temp = findMax(root.getLeft());
                root.setValue(temp.getValue());
                root.setLeft(delete(root.getLeft(), root.getValue()));
            }
            else {
                /* either one or no child */
                if (root.getRight() == null) {
                    root = root.getLeft();
                }
                else {
                    root = root.getRight();
                }
            }
        }
        else if (root.getValue() < key) {
            //we are moving to right
            root.setRight(delete(root.getRight(), key));
        }
        else {
            //we are moving to left
            root.setLeft(delete(root.getLeft(), key));
        }

        return root;
    }

    private static BinaryTreeNode findMax(BinaryTreeNode root) {
        if (root == null) return root;

        if (root.getRight() == null) return root;
        return findMax(root.getRight());
    }

    private static void printInOrder(BinaryTreeNode root) {
        if (root == null) return;

        printInOrder(root.getLeft());
        System.out.print(" " + root.getValue());
        printInOrder(root.getRight());
    }

}
