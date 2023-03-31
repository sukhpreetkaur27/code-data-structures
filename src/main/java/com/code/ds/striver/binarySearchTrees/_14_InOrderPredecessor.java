package com.code.ds.striver.binarySearchTrees;

/**
 * Given the root of a binary search tree and a node p in it, return the in-order predecessor of that node in the BST. 
 * If the given node has no in-order predecessor in the tree, return null.

The successor of a node p is the node with the largest key smaller than p.val.

 

Example 1:

Input: root = [2,1,3], p = 1
Output: null


Example 2:

Input: root = [5,3,6,2,4,null,null,1], p = 6
Output: 5
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
All Nodes will have unique values.
 * 
 * @author sukh
 *
 */
public class _14_InOrderPredecessor {

  /**
   * Time: O(log n) <br>
   * Space: O(1)
   * 
   * @param root
   * @param p
   * @return
   */
  public _0_TreeNode inorderPredecessor(_0_TreeNode root, _0_TreeNode p) {
    /**
     * The maximum value in the left sub-tree == predecessor
     */
    /**
     * In-Order Traversal of BST == Ascending Order
     * 
     * In-Order Predecessor == Previous Smallest to the node
     * 
     * if current <= node --> Traverse Right
     * 
     * if current > node --> Traverse Left (current might be the predecessor)
     */
    _0_TreeNode curr = root;
    _0_TreeNode min = null;
    while (curr != null) {
      if (curr.val < p.val) {
        min = curr;
        curr = curr.right;
      } else {
        curr = curr.left;
      }
    }
    return min;
  }

  /**
   * NOTE: Other Approach
   * 
   * Find the In-Order Traversal
   * 
   * Binary Search to find the predecessor
   */

}
