package com.code.ds.striver.binaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Preorder Inorder Postorder Traversals in One Traversal. 
 * 
 * Write a program to print Preorder, Inorder, and Postorder traversal of the tree in a single traversal.

Example:

{1, 2, 3, 4, 5, 6, 7}

Pre-Order: {1, 2, 4, 5, 3, 6, 7}

In-Order: {4, 2, 5, 1, 6, 3, 7}

Post-Order: {4, 5, 2, 6, 7, 3, 1}

 * 
 * @author sukh
 *
 */
public class _7_PreInPostTraversal {

  class Node {
    _0_TreeNode node;
    int num;

    Node(_0_TreeNode node, int num) {
      this.node = node;
      this.num = num;
    }
  }

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param root
   */
  public void traversal(_0_TreeNode root) {
    List<Integer> preorder = new ArrayList<>();
    List<Integer> inorder = new ArrayList<>();
    List<Integer> postorder = new ArrayList<>();

    Deque<Node> stack = new ArrayDeque<>();
    stack.push(new Node(root, 1));

    while (!stack.isEmpty()) {
      Node top = stack.pop();
      if (top.num == 1) {
        /**
         * Pre-Order
         */
        preorder.add(top.node.val);
        top.num++;
        stack.push(top);

        /**
         * Push Left
         */
        if (top.node.left != null) {
          stack.push(new Node(top.node.left, 1));
        }
      } else if (top.num == 2) {
        /**
         * In-Order
         */
        inorder.add(top.node.val);
        top.num++;
        stack.push(top);
        /**
         * Push Right
         */ 
        if (top.node.right != null) {
          stack.push(new Node(top.node.right, 1));
        }
      } else {
        /**
         * Post-Order
         */
        postorder.add(top.node.val);
      }
    }
  }

}
