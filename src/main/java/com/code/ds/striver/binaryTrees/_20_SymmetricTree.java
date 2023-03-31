package com.code.ds.striver.binaryTrees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 

Follow up: Could you solve it both recursively and iteratively?
 * 
 * @author sukh
 *
 */
public class _20_SymmetricTree {

  /**
   * Time: O(n) <br>
   * Space: O(height)
   * 
   * for skewed trees, Space: O(n)
   * 
   * @param root
   * @return
   */
  public boolean isSymmetric(_0_TreeNode root) {
    /**
     * NOTE: Recursive Approach, i.e., DFS
     * 
     * node.left == node.right
     */
    return root == null || symmetric(root.left, root.right);
  }

  private boolean symmetric(_0_TreeNode left, _0_TreeNode right) {
    if (left == null || right == null) {
      return left == right;
    }
    if (left.val != right.val) {
      return false;
    }
    return symmetric(left.left, right.right) && symmetric(left.right, right.left);
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
  public boolean isSymmetric1(_0_TreeNode root) {
    Deque<_0_TreeNode> queue = new ArrayDeque<>();
    if (root.left != null) {
      queue.offer(root.left);
    }
    if (root.right != null) {
      queue.offer(root.right);
    }

    while (!queue.isEmpty()) {
      _0_TreeNode left = queue.poll();
      _0_TreeNode right = queue.poll();

      if (left == null && right == null) {
        return true;
      }
      if (left == null || right == null) {
        return false;
      }
      if (left.val != right.val) {
        return false;
      }
      if (left.left != null && right.right != null) {
        queue.offer(left.left);
        queue.offer(right.right);
      } else if (left.left == null && right.right == null) {
        ;
      } else {
        return false;
      }
      if (left.right != null && right.left != null) {
        queue.offer(left.right);
        queue.offer(right.left);
      } else if (left.right == null && right.left == null) {
        ;
      } else {
        return false;
      }
    }
    return true;
  }
  
}