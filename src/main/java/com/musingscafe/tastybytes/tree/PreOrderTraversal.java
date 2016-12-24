package com.musingscafe.tastybytes.tree;

import com.musingscafe.tastybytes.tree.support.BinaryTreeNode;
import com.musingscafe.tastybytes.tree.support.BinaryTreeUtil;

import java.util.Stack;

/**
 * Created by ayadav on 12/24/16.
 */
public class PreOrderTraversal {
    public static void main(String[] args) {
        preOrder(BinaryTreeUtil.getSampleTree());
        System.out.println("-------------------------------------");
        preOrderIterative(BinaryTreeUtil.getSampleTree());
    }

    /**
     * In pre order we will first traverse node then left and then right
     */
    private static void preOrder(BinaryTreeNode root) {
        if (root == null) return;

        System.out.println(root.getValue());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    /**
     *  We need to traverse the node and then to go down the left path. Means once we are done with traversing the
     *  left path we would still need node around as we need to traverse the right path. This is true for all nodes.
     *  Thus, we need a stack to maintain the node. We are using stack as it implements LIFO and thus the child will
     *  be on top. And while going back up after traversing the left part we need child before the node itself.
     */
    private static void preOrderIterative(BinaryTreeNode root) {
        if (root == null) return;

        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode temp = root;

        while (true) {
            while (temp != null) {
                System.out.println(temp.getValue());
                stack.push(temp);
                temp = temp.getLeft();
            }

            if (stack.isEmpty()) break;

            temp = stack.pop();
            temp = temp.getRight();
        }
    }
}
