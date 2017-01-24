package com.musingscafe.tastybytes.tree;

import com.musingscafe.tastybytes.tree.support.BinaryTreeNode;
import com.musingscafe.tastybytes.tree.support.BinaryTreeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ayadav on 12/24/16.
 */
public class LevelOrderTraversal {
    public static void main(String[] args) {
        levelOrder(BinaryTreeUtil.getSampleTree());
    }

    /*
        In level order traversal we traverse each level from top to bottom. It is also called breadth first traversal.
        As we are traversing the tree breadth wise. In other traversal algorithms we move depth wise. As we needed to
        move depth wise we used Stack to hold the children and popped them out once traversed. In level order we need
        traverse all the nodes at a level. They may have same parent and may not. Once traversed we also need to traverse
        children of these nodes. Thus, if we use a stack and push the children to keep track of them, the next node which
        we will pop will be the child and not the sibling. Remember, stack implements LIFO. Thus, we need Queue to
        implement level order. As we need sibling first and not child.
     */
    private static void levelOrder(BinaryTreeNode root) {
        if (root == null) return;
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();

        queue.add(root);
        BinaryTreeNode temp = null;

        while (!queue.isEmpty()) {
            temp = queue.remove();

            System.out.println(temp.getValue());
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
        }
    }
}
