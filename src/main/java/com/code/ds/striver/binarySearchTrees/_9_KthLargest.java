package com.code.ds.striver.binarySearchTrees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary search tree, task is to find Kth largest element in the binary search tree.

Example: 

Input :  k = 3
         Root of following BST
            10
          /    \
         4      20
        /      /   \
       2     15     40
Output : 15
 * 
 * @author sukh
 *
 */
public class _9_KthLargest {
  
  /**
   * NOTE: 
   * 
   * Solve: 
   *
   *Kth Largest Element in a Stream
   *
   * https://leetcode.com/problems/kth-largest-element-in-a-stream/
   */

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param root
   * @param k
   * @return
   */
  public int kthLargest0(_0_TreeNode root, int k) {
    /**
     * Reverse In-Order Traversal of BST == Descending Order
     * 
     * Iterative Approach
     */
    _0_TreeNode curr = root;
    Deque<_0_TreeNode> stack = new ArrayDeque<>();
    int count = 0;
    _0_TreeNode top = null;
    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.right;
      }
      top = stack.pop();
      curr = top.left;
      count++;
      if (count == k) {
        break;
      }
    }
    return top.val;
  }

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * 
   * @param root
   * @param k
   * @return
   */
  public int kthLargest(_0_TreeNode root, int k) {
    /**
     * Reverse In-Order Traversal of BST == Descending Order
     * 
     * Morris Traversal Approach
     */
    _0_TreeNode curr = root;
    int count = 0;
    _0_TreeNode largest = root;
    while (curr != null && count != k) {
      if (curr.right == null) {
        count++;
        // if(count==k){
        // return curr.val;
        // }
        largest = curr;
        curr = curr.left;
      } else {
        _0_TreeNode succ = curr.right;
        while (succ.left != null && succ.left != curr) {
          succ = succ.left;
        }
        if (succ.left == null) {
          succ.left = curr;
          curr = curr.right;
        } else {
          succ.left = null;
          count++;
          // if(count==k){
          // return curr.val;
          // }
          largest = curr;
          curr = curr.left;
        }
      }
    }
    return largest.val;
  }

}
