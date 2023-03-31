package com.code.ds.striver.binaryTrees;

import java.util.HashMap;
import java.util.Map;

/**
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

 

Example 1:


Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.
Example 2:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
 

Constraints:

The number of nodes in the tree is in the range [0, 1000].
-109 <= Node.val <= 109
-1000 <= targetSum <= 1000
 * 
 * @author sukh
 *
 */
public class _27_PathSumIII {

  private int target;
  private int count = 0;
  private Map<Long, Integer> map = new HashMap<>();

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
  public int pathSum(_0_TreeNode root, int targetSum) {
    /**
     * NOTE: <br>
     * 
     * Prefix Sum
     */
    target = targetSum;
    long currSum = 0L;
    preOrder(root, currSum);
    return count;
  }

  private void preOrder(_0_TreeNode root, long currSum) {
    if (root == null) {
      return;
    }
    currSum += root.val;
    if (currSum == target) {
      count++;
    }
    /**
     * Check for Prefix Sum - Target
     */
    count += map.getOrDefault(currSum - target, 0);
    map.put(currSum, map.getOrDefault(currSum, 0) + 1);
    preOrder(root.left, currSum);
    preOrder(root.right, currSum);
    /**
     * remove the current sum from the prefix sum count map in order not to use it
     * during the parallel subtree processing
     */
    map.put(currSum, map.get(currSum) - 1);
  }

}
