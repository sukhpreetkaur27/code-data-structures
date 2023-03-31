package com.code.ds.striver.binaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible 
 * when the tree is viewed from the top. For the given below tree

       1
    /     \
   2       3
  /  \    /   \
4    5  6   7

Top view will be: 4 2 1 3 7
Note: Return nodes from leftmost node to rightmost node. Also if 2 nodes are outside the shadow of the tree and are at same position 
then consider the extreme ones only(i.e. leftmost and rightmost). 
For ex - 1 2 3 N 4 5 N 6 N 7 N 8 N 9 N N N N N will give 8 2 1 3 as answer. Here 8 and 9 are on the same position but 9 will get shadowed.

Example 1:

Input:
      1
   /    \
  2      3
Output: 2 1 3
Example 2:

Input:
       10
    /      \
  20        30
 /   \    /    \
40   60  90    100
Output: 40 20 10 30 100
Your Task:
Since this is a function problem. You don't have to take input. Just complete the function topView() that takes root node as parameter 
and returns a list of nodes visible from the top view from left to right.

Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 105
1 ≤ Node Data ≤ 105
 * 
 * @author sukh
 *
 */
public class _16_TopView {

  /**
   * Tuple = {vertical, node}
   */
  class Tuple {
    _0_TreeNode node;
    /**
     * vertical == x == column
     */
    int vertical;

    Tuple(_0_TreeNode node, int vertical) {
      this.node = node;
      this.vertical = vertical;
    }
  }

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param root
   * @return
   */
  public List<Integer> topView(_0_TreeNode root) {
    /**
     * Top View == Ordered Vertical Order Traversal (with the first node per vertical as the answer)
     */
    /**
     * NOTE: <br>
     * Recursive DFS Traversals are not as intuitive as BFS Level Order Traversal
     */
    List<Integer> traversal = new ArrayList<Integer>();
    if (root == null) {
      return traversal;
    }
    /**
     * Ordered Vertical --> Node
     */
    Map<Integer, Integer> map = new TreeMap<>();
    Deque<Tuple> queue = new ArrayDeque<>();
    queue.offer(new Tuple(root, 0));

    /**
     * Level Order Traversal
     */
    while (!queue.isEmpty()) {
      Tuple pop = queue.poll();

      _0_TreeNode node = pop.node;
      int vertical = pop.vertical;

      if (!map.containsKey(vertical)) {
        map.put(vertical, node.val);
      }
      if (node.left != null) {
        queue.offer(new Tuple(node.left, vertical - 1));
      }
      if (node.right != null) {
        queue.offer(new Tuple(node.right, vertical + 1));
      }
    }
    for (Integer val : map.values()) {
      traversal.add(val);
    }
    return traversal;
  }

}
