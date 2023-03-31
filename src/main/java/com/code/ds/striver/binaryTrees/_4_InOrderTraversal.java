package com.code.ds.striver.binaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [1,3,2]
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
 * @author sukh
 *
 */
public class _4_InOrderTraversal {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param root
   * @return
   */
  public List<Integer> inorderTraversal1(_0_TreeNode root) {
    /**
     * Recursive
     */
    List<Integer> list = new ArrayList<>();
    inorder(root, list);
    return list;
  }

  private void inorder(_0_TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    inorder(root.left, list);
    list.add(root.val);
    inorder(root.right, list);
  }

  /**
   * Time: O(n) <br>
   * Space: O(n) 
   * 
   * @param root
   * @return
   */
  public List<Integer> inorderTraversal(_0_TreeNode root) {
    /**
     * Iterative
     */
    List<Integer> list = new ArrayList<>();
    Deque<_0_TreeNode> stack = new ArrayDeque<>();

    _0_TreeNode curr = root;

    while (curr != null || !stack.isEmpty()) {
      /**
       * push left
       */
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      /**
       * pop left
       */
      _0_TreeNode top = stack.pop();
      list.add(top.val);
      curr = top.right;
    }

    return list;
  }

}
