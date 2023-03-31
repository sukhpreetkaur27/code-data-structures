package com.code.ds.striver.binaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. 
 * Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
 * 
 * @author sukh
 *
 */
public class _26_PathSumII {

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
  public List<List<Integer>> pathSum(_0_TreeNode root, int targetSum) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    sum(root, targetSum, res, new ArrayList<Integer>());
    return res;
  }

  private void sum(_0_TreeNode root, int sum, List<List<Integer>> res,
      List<Integer> temp) {
    sum -= root.val;
    temp.add(root.val);
    if (root.left == null && root.right == null) {
      if (sum == 0) {
        res.add(new ArrayList<>(temp));
      }
    }
    if (root.left != null) {
      sum(root.left, sum, res, temp);
    }
    if (root.right != null) {
      sum(root.right, sum, res, temp);
    }
    sum += root.val;
    temp.remove(temp.size() - 1);
  }

}
