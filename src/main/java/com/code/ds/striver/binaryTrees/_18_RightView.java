package com.code.ds.striver.binaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

Example 1:


Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Example 2:

Input: root = [1,null,3]
Output: [1,3]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 * 
 * @author sukh
 *
 */
public class _18_RightView {

  /**
   * Time: O(n) <br>
   * Space: O(height)
   * 
   * for skewed trees, Space: O(n)
   * 
   * @param root
   * @return
   */
  public List<Integer> rightSideView(_0_TreeNode root) {
    /**
     * NOTE: Recursive Solution, i.e., DFS
     * 
     * Right View == Reverse Pre-Order Traversal == Root Right Left
     * 
     * the last node in each level is the right view
     */
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    rightView(root, res, 0);
    return res;
  }

  private void rightView(_0_TreeNode root, List<Integer> res, int level) {
    if (root == null) {
      return;
    }
    if (level == res.size()) {
      res.add(root.val);
    }
    rightView(root.right, res, level + 1);
    rightView(root.left, res, level + 1);
  }

  /**
   * NOTE: Iterative Solution , i.e., BFS <br>
   * 
   * Drawback:
   * 
   * Space: O(n)
   * 
   * here, we have to store all the nodes in the each(last is max) level
   * 
   * But for recursive solution we have to store only the nodes in a height of the
   * tree
   */

}
