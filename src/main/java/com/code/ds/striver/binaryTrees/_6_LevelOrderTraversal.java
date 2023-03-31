package com.code.ds.striver.binaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
 * 
 * @author sukh
 *
 */
public class _6_LevelOrderTraversal {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param root
   * @return
   */
  public List<List<Integer>> levelOrder(_0_TreeNode root) {
    List<List<Integer>> traversal = new ArrayList<>();

    if (root == null) {
      return traversal;
    }

    Deque<_0_TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    int level;
    while (!queue.isEmpty()) {
      level = queue.size();
      List<Integer> subLevel = new ArrayList<>();
      for (int i = 0; i < level; i++) {
        if (queue.peek().left != null) {
          queue.offer(queue.peek().left);
        }
        if (queue.peek().right != null) {
          queue.offer(queue.peek().right);
        }
        subLevel.add(queue.poll().val);
      }
      traversal.add(subLevel);
    }

    return traversal;
  }

}
