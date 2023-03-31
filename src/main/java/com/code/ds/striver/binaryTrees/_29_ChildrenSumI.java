package com.code.ds.striver.binaryTrees;

/**
 * Convert the tree to satisfy the Children Sum property, i.e., <br>
 * Parent = left + right
 * 
 * @author sukh
 *
 */
public class _29_ChildrenSumI {

  /**
   * Time: O(n) <br>
   * Space: O(height)
   * 
   * for skewed trees, Space: O(n)
   * 
   * @param root
   */
  public void convert(_0_TreeNode root) {
    /**
     * NOTE: <br>
     * Recursive Traversal --> Pre-Order
     */
    if (root == null) {
      return;
    }

    /**
     * Calculate the sum of left and right children
     */
    int sum = 0;
    if (root.left != null) {
      sum += root.left.val;
    }
    if (root.right != null) {
      sum += root.right.val;
    }

    /**
     * update root or children, whichever is smaller, to the max(root,
     * sum(left,right))
     */
    if (root.val >= sum) {
      if (root.left != null) {
        root.left.val = root.val;
      }
      if (root.right != null) {
        root.right.val = root.val;
      }
    } else {
      root.val = sum;
    }

    /**
     * Pre-Order Traversal
     */
    convert(root.left);
    convert(root.right);

    /**
     * Update root to the sum of left and right children
     */
    sum = 0;
    if (root.left != null) {
      sum += root.left.val;
    }
    if (root.right != null) {
      sum += root.right.val;
    }
    if (root.left != null || root.right != null) {
      root.val = sum;
    }
  }

}
