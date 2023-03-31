package com.code.ds.striver.binaryTrees;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. 
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

 

Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 

Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000
 * 
 * @author sukh
 *
 */
public class _11_MaxPathSum {

  /**
   * /** Time: O(n) <br>
   * Space: O(height)
   * 
   * Space: O(n) for skewed trees
   * 
   * @param root
   * @return
   */
  public int maxPathSum(_0_TreeNode root) {
    int[] pathSum = { Integer.MIN_VALUE };
    pathSum(root, pathSum);
    return pathSum[0];
  }

  private int pathSum(_0_TreeNode root, int[] pathSum) {
    if (root == null) {
      return 0;
    }
    /**
     * if left sum < 0, discard it as it will not lead to max path sum
     * 
     * as summation of negative values will decrease the sum more, and as we are
     * interested in finding the maximum path sum, we discard it by choosing max of
     * (sum, 0)
     */
    int leftSum = Math.max(pathSum(root.left, pathSum), 0);
    /**
     * if right sum < 0, discard it as it will not lead to max path sum
     */
    int rightSum = Math.max(pathSum(root.right, pathSum), 0);

    int sum = root.val + leftSum + rightSum;

    pathSum[0] = Math.max(pathSum[0], sum);

    /**
     * a path cannot contain the same node twice, so pick either the left or right
     * path from a root node
     */
    return root.val + Math.max(leftSum, rightSum);
  }

}
