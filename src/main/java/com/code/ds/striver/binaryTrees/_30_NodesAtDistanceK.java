package com.code.ds.striver.binaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
Example 2:

Input: root = [1], target = 1, k = 3
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 500].
0 <= Node.val <= 500
All the values Node.val are unique.
target is the value of one of the nodes in the tree.
0 <= k <= 1000
 * 
 * @author sukh
 *
 */
public class _30_NodesAtDistanceK {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param root
   * @param target
   * @param k
   * @return
   */
  public List<Integer> distanceK(_0_TreeNode root, _0_TreeNode target, int k) {
    /**
     * NOTE: BFS
     * 
     * Trees can traverse from parent to child and not vice-versa, therefore <br>
     * Mark Parents
     * 
     * Traverse radially in all the directions and increment the distance <br>
     * Make sure to keep track of visited nodes
     * 
     * The queue holds the nodes at a distance k
     */
    /**
     * NOTE: <br>
     * Why not DFS?
     * 
     * Because we have to radially travel level wise
     */
    List<Integer> list = new ArrayList<>();
    Map<_0_TreeNode, _0_TreeNode> childParentMap = markParents(root);
    Deque<_0_TreeNode> nodes = findNodes(target, list, childParentMap, k);
    while (!nodes.isEmpty()) {
      _0_TreeNode top = nodes.poll();
      list.add(top.val);
    }
    return list;
  }

  private Deque<_0_TreeNode> findNodes(_0_TreeNode target, List<Integer> list,
      Map<_0_TreeNode, _0_TreeNode> childParentMap, int distance) {
    Set<_0_TreeNode> visited = new HashSet<>();
    Deque<_0_TreeNode> queue = new ArrayDeque<>();
    visited.add(target);
    queue.offer(target);
    int dist = 0;
    while (!queue.isEmpty() && dist != distance) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        _0_TreeNode top = queue.poll();
        _0_TreeNode left = top.left;
        _0_TreeNode right = top.right;
        _0_TreeNode parent = childParentMap.get(top);
        if (left != null && !visited.contains(left)) {
          queue.offer(left);
          visited.add(left);
        }
        if (right != null && !visited.contains(right)) {
          queue.offer(right);
          visited.add(right);
        }
        if (parent != null && !visited.contains(parent)) {
          queue.offer(parent);
          visited.add(parent);
        }
      }
      dist++;
    }
    return queue;
  }

  private Map<_0_TreeNode, _0_TreeNode> markParents(_0_TreeNode root) {
    Map<_0_TreeNode, _0_TreeNode> childParentMap = new HashMap<>();
    Deque<_0_TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      _0_TreeNode node = queue.poll();
      _0_TreeNode left = node.left;
      _0_TreeNode right = node.right;
      if (left != null) {
        childParentMap.put(left, node);
        queue.offer(left);
      }
      if (right != null) {
        childParentMap.put(right, node);
        queue.offer(right);
      }
    }
    return childParentMap;
  }

}
