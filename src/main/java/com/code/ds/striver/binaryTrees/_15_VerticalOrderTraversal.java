package com.code.ds.striver.binaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. 
There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
Example 2:


Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.
Example 3:


Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 1000
 * 
 * @author sukh
 *
 */
public class _15_VerticalOrderTraversal {

  /**
   * Tuple = {node, vertical, level}
   */
  class Tuple {
    _0_TreeNode node;
    /**
     * vertical == x == column
     */
    int vertical;
    /**
     * level == y == row
     */
    int level;

    Tuple(_0_TreeNode node, int vertical, int level) {
      this.node = node;
      this.vertical = vertical;
      this.level = level;
    }
  }

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param root
   * @return
   */
  public List<List<Integer>> verticalTraversal(_0_TreeNode root) {
    /**
     * Vertical --> Level --> Ordered List
     */
    Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

    int vertical = 0;
    int level = 0;

    Deque<Tuple> queue = new ArrayDeque<>();
    queue.offer(new Tuple(root, vertical, level));

    /**
     * Level Order Traversal
     */
    while (!queue.isEmpty()) {
      Tuple pop = queue.poll();

      _0_TreeNode node = pop.node;
      vertical = pop.vertical;
      level = pop.level;

      TreeMap<Integer, PriorityQueue<Integer>> sublist = map.getOrDefault(vertical,
          new TreeMap<>());
      PriorityQueue<Integer> subqueue = sublist.getOrDefault(level,
          new PriorityQueue<>());
      subqueue.offer(node.val);

      sublist.put(level, subqueue);

      map.put(vertical, sublist);

      if (node.left != null) {
        // go left = vertical - 1, level + 1
        queue.offer(new Tuple(node.left, vertical - 1, level + 1));
      }
      if (node.right != null) {
        // go left = vertical + 1, level + 1
        queue.offer(new Tuple(node.right, vertical + 1, level + 1));
      }
    }

    List<List<Integer>> res = new ArrayList<>();

    for (TreeMap<Integer, PriorityQueue<Integer>> entry : map.values()) {
      List<Integer> sub = new ArrayList<>();

      for (PriorityQueue<Integer> traversal : entry.values()) {
        while (!traversal.isEmpty()) {
          sub.add(traversal.poll());
        }
      }
      res.add(sub);
    }

    return res;
  }

}
