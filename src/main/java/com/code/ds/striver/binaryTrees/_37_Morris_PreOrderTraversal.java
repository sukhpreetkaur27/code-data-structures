package com.code.ds.striver.binaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.

 

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
 * @author sukh
 *
 */
public class _37_Morris_PreOrderTraversal {

  /**
   * NOTE: <br>
   * 
   * Morris Traversal uses Threaded Binary Tree concept
   * 
   * Why to use this over DFS and BFS ?
   * 
   * Due to O(1) space complexity
   */

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * 
   * @param root
   * @return
   */
  public List<Integer> preorderTraversal(_0_TreeNode root) {
    /**
     * Threaded Binary Tree for In Order Traversal :
     * 
     * Create Threads from the right-most node of the left sub-tree to the Root
     * 
     * This is done to backtrack to the root
     */
    List<Integer> list = new ArrayList<>();
    _0_TreeNode curr = root;
    while (curr != null) {
      if (curr.left == null) {
        /**
         * curr == root
         * 
         * move to right
         */
        list.add(curr.val);
        curr = curr.right;
      } else {
        /**
         * traverse to create threads before moving to left
         */
        _0_TreeNode prev = curr.left;
        /**
         * Time: O(log n)
         * 
         * move till the height of the tree from curr
         * 
         * Amortized Time: O(n)
         */
        while (prev.right != null && prev.right != curr) {
          prev = prev.right;
        }
        if (prev.right == null) {
          /**
           * If thread doesn't exists
           * 
           * create thread
           * 
           * move to the left
           */
          prev.right = curr;
          /**
           * curr == root
           */
          list.add(curr.val);
          curr = curr.left;
        } else {
          /**
           * if thread already exists
           * 
           * remove thread
           * 
           * move to the right
           */
          prev.right = null;
          curr = curr.right;
        }
      }
    }
    return list;
  }

}
