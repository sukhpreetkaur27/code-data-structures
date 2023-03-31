package com.code.ds.striver.binaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 Given the root of a binary tree, return the preorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [1,2,3]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up: Recursive solution is trivial, could you do it iteratively?
 * 
 * 
 * @author sukh
 *
 */
public class _3_PreOrderTraversal {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param root
   * @return
   */
  public List<Integer> preorderTraversal(_0_TreeNode root) {
    /**
     * Recursive
     */
    List<Integer> list = new ArrayList<>();
    preorder(root, list);
    return list;
  }

  public void preorder(_0_TreeNode root, List<Integer> traversal) {
    if (root == null) {
      return;
    }
    traversal.add(root.val);
    preorder(root.left, traversal);
    preorder(root.right, traversal);
  }

  /**
   * Time: O(n) <br>
   * Space: O(n) == O(log n)
   * @param root
   * @return
   */
  public List<Integer> preorderTraversal1(_0_TreeNode root) {
    /**
     * Iterative
     */
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    Deque<_0_TreeNode> stack = new ArrayDeque<>();

    /**
     * push root
     */
    stack.push(root);

    while (!stack.isEmpty()) {
      /**
       * pop root
       */
      _0_TreeNode top = stack.pop();
      /**
       * push right -> left
       */
      list.add(top.val);
      if (top.right != null) {
        stack.push(top.right);
      }
      if (top.left != null) {
        stack.push(top.left);
      }
    }

    return list;
  }

}
