package com.code.ds.striver.binaryTrees;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
 * 
 * @author sukh
 *
 */
public class _10_Diameter {

  /**
   * Time: O(n) <br>
   * Space: O(height)
   * 
   * Space: O(n) for skewed trees
   * 
   * @param root
   * @return
   */
  public int diameterOfBinaryTree(_0_TreeNode root) {
    int[] diameter = new int[1];
    diameter(root, diameter);
    return diameter[0];
  }

  private int diameter(_0_TreeNode root, int[] diameter) {
    if (root == null) {
      return 0;
    }
    int leftHeight = diameter(root.left, diameter);
    int rightHeight = diameter(root.right, diameter);

    diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

    return 1 + Math.max(leftHeight, rightHeight);
  }

}
