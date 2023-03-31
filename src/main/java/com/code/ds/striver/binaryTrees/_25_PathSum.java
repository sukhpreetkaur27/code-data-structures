package com.code.ds.striver.binaryTrees;

/**
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path 
 * such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
 * 
 * @author sukh
 *
 */
public class _25_PathSum {

  /**
   * Time: O(n) <br>
   * Space: O(height)
   * 
   * for skewed trees, Space: O(n)
   * 
   * @param root
   * @param targetSum
   * @return
   */
  public boolean hasPathSum(_0_TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    return sum(root, targetSum);
  }

  private boolean sum(_0_TreeNode root, int sum) {
    sum -= root.val;
    if (root.left == null && root.right == null) {
      if (sum == 0) {
        return true;
      } else {
        return false;
      }
    }
    boolean check = false;
    if (root.left != null) {
      check = sum(root.left, sum);
    }
    if (!check && root.right != null) {
      check = sum(root.right, sum);
    }
    sum += root.val;
    return check;
  }

}
