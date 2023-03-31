package com.code.ds.striver.binaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, 
 * then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
 * 
 * @author sukh
 *
 */
public class _13_ZigZagTraversal {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param root
   * @return
   */
  public List<List<Integer>> zigzagLevelOrder(_0_TreeNode root) {
    List<List<Integer>> traversal = new ArrayList<>();

    if (root == null) {
      return traversal;
    }

    Deque<_0_TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    int level;
    boolean left = true;
    while (!queue.isEmpty()) {
      level = queue.size();
      LinkedList<Integer> subLevel = new LinkedList<>();
      for (int i = 0; i < level; i++) {
        if (queue.peek().left != null) {
          queue.offer(queue.peek().left);
        }
        if (queue.peek().right != null) {
          queue.offer(queue.peek().right);
        }
        if (left) {
          subLevel.add(queue.poll().val);
        } else {
          subLevel.addFirst(queue.poll().val);
        }
      }
      left = !left;

      traversal.add(subLevel);
    }

    return traversal;
  }

}
