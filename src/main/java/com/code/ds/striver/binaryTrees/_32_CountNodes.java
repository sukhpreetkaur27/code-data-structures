package com.code.ds.striver.binaryTrees;

/**
 * Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, 
and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.

 

Example 1:


Input: root = [1,2,3,4,5,6]
Output: 6
Example 2:

Input: root = []
Output: 0
Example 3:

Input: root = [1]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [0, 5 * 104].
0 <= Node.val <= 5 * 104
The tree is guaranteed to be complete.
 * 
 * @author sukh
 *
 */
public class _32_CountNodes {

  /**
   * Time: O[(log N)^2] <br>
   * log N recursive calls <br>
   * log N for finding the height
   * 
   * Space: O(log N)
   * 
   * @param root
   * @return
   */
  public int countNodes(_0_TreeNode root) {
    /**
     * if left sub-tree height == right sub-tree height <br>
     * # of nodes = (2 ^ height) - 1
     * 
     * else # of nodes = 1 (for the root) + left sub-tree count + right sub-tree
     * count
     */
    if (root == null) {
      return 0;
    }
    int left = leftHeight(root);
    int right = rightHeight(root);

    if (left == right) {
      return (2 << left) - 1;
    }

    return 1 + countNodes(root.left) + countNodes(root.right);
  }

  /**
   * Find left sub-tree height
   * 
   * @param root
   * @return
   */
  private int rightHeight(_0_TreeNode root) {
    _0_TreeNode curr = root;
    int height = 0;
    while (curr.right != null) {
      height++;
      curr = curr.right;
    }
    return height;
  }

  /**
   * Find right sub-tree height
   * 
   * @param root
   * @return
   */
  private int leftHeight(_0_TreeNode root) {
    _0_TreeNode curr = root;
    int height = 0;
    while (curr.left != null) {
      height++;
      curr = curr.left;
    }
    return height;
  }

}
