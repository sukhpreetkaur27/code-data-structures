package com.code.ds.striver.binaryTrees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a binary tree and a node called target. Find the minimum time required to burn the complete binary tree if the target is set on fire. 
 * It is known that in 1 second all nodes connected to a given node get burned. That is its left child, right child, and parent.


Example 1:

Input:      
          1
        /   \
      2      3
    /  \      \
   4    5      6
       / \      \
      7   8      9
                   \
                   10
Target Node = 8
Output: 7
Explanation: If leaf with the value 
8 is set on fire. 
After 1 sec: 5 is set on fire.
After 2 sec: 2, 7 are set to fire.
After 3 sec: 4, 1 are set to fire.
After 4 sec: 3 is set to fire.
After 5 sec: 6 is set to fire.
After 6 sec: 9 is set to fire.
After 7 sec: 10 is set to fire.
It takes 7s to burn the complete tree.
Example 2:

Input:      
          1
        /   \
      2      3
    /  \      \
   4    5      7
  /    / 
 8    10
Target Node = 10
Output: 5

Your Task:  
You don't need to read input or print anything. Complete the function minTime() which takes the root of the tree and target as input parameters 
and returns the minimum time required to burn the complete binary tree if the target is set on fire at the 0th second.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(height of tree)


Constraints:
1 ≤ N ≤ 104
 * 
 * @author sukh
 *
 */
public class _31_BurnTree {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param root
   * @param target
   * @return
   */
  public static int minTime(_0_TreeNode root, int target) {
    /**
     * NOTE: BFS
     * 
     * Trees can traverse from parent to child and not vice-versa, therefore <br>
     * Mark Parents
     * 
     * Traverse radially in all the directions and increment the time <br>
     * Make sure to keep track of visited nodes
     * 
     */
    /**
     * NOTE: <br>
     * Why not DFS?
     * 
     * Because we have to radially travel level wise
     */
    Map<_0_TreeNode, _0_TreeNode> childParentMap = new HashMap<>();
    _0_TreeNode fire = markParents(root, childParentMap, target);
    int time = calculate(fire, childParentMap);
    return time;
  }

  private static int calculate(_0_TreeNode root,
      Map<_0_TreeNode, _0_TreeNode> childParentMap) {
    /**
     * The last set of nodes who don't have any unvisited left, right, parent don't
     * burn any other node <br>
     * 
     * hence, start with -1
     */
    int time = -1;
    Set<_0_TreeNode> visited = new HashSet<>();
    Deque<_0_TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    visited.add(root);
    while (!queue.isEmpty()) {
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
      time++;
    }
    return time;
  }

  private static _0_TreeNode markParents(_0_TreeNode root,
      Map<_0_TreeNode, _0_TreeNode> childParentMap, int target) {
    _0_TreeNode fire = null;
    Deque<_0_TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      _0_TreeNode _0_TreeNode = queue.poll();
      if (_0_TreeNode.val == target) {
        fire = _0_TreeNode;
      }
      _0_TreeNode left = _0_TreeNode.left;
      _0_TreeNode right = _0_TreeNode.right;
      if (left != null) {
        childParentMap.put(left, _0_TreeNode);
        queue.offer(left);
      }
      if (right != null) {
        childParentMap.put(right, _0_TreeNode);
        queue.offer(right);
      }
    }
    return fire;
  }

}
