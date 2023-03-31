package com.code.ds.striver.binaryTrees;

/**
 * Given a binary tree, determine if it is height-balanced.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
 * 
 * @author sukh
 *
 */
public class _9_BalancedBinaryTree {

  /**
   * Time: O(n) <br>
   * Space: O(height)
   * 
   * Space: O(n) for skewed trees
   * 
   * @param root
   * @return
   */
  public boolean isBalanced(_0_TreeNode root) {
    /**
     * Balanced Binary Tree: <br>
     * 
     * For every node,
     * 
     * Math.abs ( height(left) - height(right) ) <= 1
     */
    return height(root) > -1;
  }

  /**
   * Time: O(n) <br>
   * Space: O(height)
   * 
   * @param root
   * @return
   */
  private int height(_0_TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = height(root.left);
    if (leftHeight == -1) {
      return -1;
    }
    int rightHeight = height(root.right);
    if (rightHeight == -1) {
      return -1;
    }
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }
    return 1 + Math.max(leftHeight, rightHeight);
  }

}
