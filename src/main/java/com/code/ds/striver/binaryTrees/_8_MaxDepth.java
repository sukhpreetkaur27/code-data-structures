package com.code.ds.striver.binaryTrees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
 * 
 * @author sukh
 *
 */
public class _8_MaxDepth {

  /**
   * Time: O(n) <br>
   * space: O(n)
   * 
   * @param root
   * @return
   */
  public int maxDepth1(_0_TreeNode root) {
    /**
     * Iterative: Level Order Traversal Approach <br>
     * 
     * Disadvantages: <br>
     * for any binary tree <br>
     * Space: O(n); due to Queue DS
     */
    if (root == null) {
      return 0;
    }
    Deque<_0_TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    int depth = 0;
    while (!queue.isEmpty()) {
      int level = queue.size();
      for (int i = 0; i < level; i++) {
        _0_TreeNode node = queue.poll();
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      depth++;
    }
    return depth;
  }

  /**
   * Time: O(n) <br>
   * Space: O(height)
   * 
   * @param root
   * @return
   */
  public int maxDepth(_0_TreeNode root) {
    /**
     * Recursive:
     * 
     * Advantages: <br>
     * Auxiliary Space: O( height) <br>
     * at worst case O(n) (for skewed trees)
     * 
     * 
     * 
     * This approach is preferred to Iterative as binary trees are generally not
     * skewed.
     * 
     * Rather trees end up having very small height in almost all the cases.
     */

    /**
     * Using Recurrence Relation: <br>
     * 
     * Depth = 1 (for root node) + max height of (left, right) <br>
     * i.e., <br>
     * Depth = 1 + max(l, r)
     */
    int depth = 0;
    if (root == null) {
      return 0;
    }
    depth = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    return depth;
  }

}
