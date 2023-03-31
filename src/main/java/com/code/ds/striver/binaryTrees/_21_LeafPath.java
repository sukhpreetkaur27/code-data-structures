package com.code.ds.striver.binaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

 

Example 1:


Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:

Input: root = [1]
Output: ["1"]
 

Constraints:

The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100
 * 
 * @author sukh
 *
 */
public class _21_LeafPath {

  /**
   * Time: O(n) <br>
   * Space: O(height)
   * 
   * for skewed trees, Space: O(n)
   * 
   * @param root
   * @return
   */
  public List<String> binaryTreePaths(_0_TreeNode root) {
    /**
     * NOTE: Recursive <br>
     * 
     * Tree Path to a Node == In-Order Traversal
     */
    List<String> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    path(list, root, new ArrayList<Integer>());
    return list;
  }

  private void path(List<String> list, _0_TreeNode root, List<Integer> temp) {
    temp.add(root.val);
    if (root.left == null && root.right == null) {
      /**
       * if node is leaf
       */
      StringBuilder sb = new StringBuilder();
      for (int i : temp) {
        sb.append(i).append("->");
      }
      sb.setLength(sb.length() - 2);
      list.add(sb.toString());
      temp.remove(temp.size() - 1);
    } else {
      if (root.left != null) {
        path(list, root.left, temp);
      }
      if (root.right != null) {
        path(list, root.right, temp);
      }
      /**
       * backtrack and remove the current node from the path
       */
      temp.remove(temp.size() - 1);
    }
  }

}
