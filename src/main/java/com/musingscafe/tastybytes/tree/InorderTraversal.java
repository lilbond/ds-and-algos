package com.musingscafe.tastybytes.tree;

import com.musingscafe.tastybytes.tree.support.BinaryTreeNode;
import com.musingscafe.tastybytes.tree.support.BinaryTreeUtil;

import java.util.Stack;

/**
 * Created by ayadav on 12/24/16.
 */
public class InorderTraversal {
    public static void main(String[] args) {
        inOrder(BinaryTreeUtil.getSampleTree());
        System.out.println("----------------------------");
        inOrderIterative(BinaryTreeUtil.getSampleTree());
    }

    private static void inOrder(BinaryTreeNode root) {
        if (root == null) return;

        inOrder(root.getLeft());
        System.out.println(root.getValue());
        inOrder(root.getRight());
    }

    private static void inOrderIterative(BinaryTreeNode root) {
        if (root == null) return;

        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode temp = root;

        while (true) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.getLeft();
            }

            if (stack.isEmpty()) break;

            temp = stack.pop();
            System.out.println(temp.getValue());
            temp = temp.getRight();
        }
    }
}
