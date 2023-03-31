package com.code.ds.striver.binarySearchTrees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

 

Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 

Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
 

Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
 * 
 * @author sukh
 *
 */
public class _8_KthSmallest {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param root
   * @param k
   * @return
   */
  public int kthSmallest0(_0_TreeNode root, int k) {
    /**
     * In-Order Traversal of BST == Ascending Order
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
        curr = curr.left;
      }
      top = stack.pop();
      curr = top.right;
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
  public int kthSmallest(_0_TreeNode root, int k) {
    /**
     * In-Order Traversal of BST == Ascending Order
     * 
     * Morris Traversal Approach
     */
    _0_TreeNode curr = root;
    int count = 0;
    _0_TreeNode smallest = root;
    while (curr != null && count != k) {
      if (curr.left == null) {
        count++;
        // if(count==k){
        // return curr.val;
        // }
        smallest = curr;
        curr = curr.right;
      } else {
        _0_TreeNode prev = curr.left;
        while (prev.right != null && prev.right != curr) {
          prev = prev.right;
        }
        if (prev.right == null) {
          prev.right = curr;
          curr = curr.left;
        } else {
          prev.right = null;
          count++;
          // if(count==k){
          // return curr.val;
          // }
          smallest = curr;
          curr = curr.right;
        }
      }
    }
    return smallest.val;
  }

}
