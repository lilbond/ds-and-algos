package com.musingscafe.tastybytes.tree.support;

/**
 * Created by ayadav on 12/22/16.
 */
public class BinaryTreeUtil {

    /**
     *          1
     *        /   \
     *       2     3
     *     /  \   / \
     *    4   5  6   7
     */
    public static BinaryTreeNode getSampleTree() {
        BinaryTreeNode root = new BinaryTreeNode();
        root.setValue(1);

        BinaryTreeNode node2 = new BinaryTreeNode();
        BinaryTreeNode node3 = new BinaryTreeNode();
        BinaryTreeNode node4 = new BinaryTreeNode();
        BinaryTreeNode node5 = new BinaryTreeNode();
        BinaryTreeNode node6 = new BinaryTreeNode();
        BinaryTreeNode node7 = new BinaryTreeNode();

        node2.setValue(2);
        node3.setValue(3);
        node4.setValue(4);
        node5.setValue(5);
        node6.setValue(6);
        node7.setValue(7);

        root.setLeft(node2);
        root.setRight(node3);

        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        node3.setRight(node7);

        return root;

    }
}
