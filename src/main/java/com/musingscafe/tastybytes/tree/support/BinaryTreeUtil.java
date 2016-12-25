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

    /**
     *          4
     *        /   \
     *       2     6
     *     /  \   / \
     *    1   3  5   7
     */
    public static BinaryTreeNode getSampleBinarySearchTree() {
        BinaryTreeNode node1 = new BinaryTreeNode();
        BinaryTreeNode node2 = new BinaryTreeNode();
        BinaryTreeNode node3 = new BinaryTreeNode();
        BinaryTreeNode node4 = new BinaryTreeNode();
        BinaryTreeNode node5 = new BinaryTreeNode();
        BinaryTreeNode node6 = new BinaryTreeNode();
        BinaryTreeNode node7 = new BinaryTreeNode();

        node1.setValue(1);
        node2.setValue(2);
        node3.setValue(3);
        node4.setValue(4);
        node5.setValue(5);
        node6.setValue(6);
        node7.setValue(7);

        node4.setLeft(node2);
        node4.setRight(node6);

        node2.setLeft(node1);
        node2.setRight(node3);

        node6.setLeft(node5);
        node6.setRight(node7);

        return node4;

    }
}
