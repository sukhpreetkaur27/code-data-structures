package com.code.ds.striver.binaryTrees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 

Example 1:


Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [0]
Output: [0]
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
 

Follow up: Can you flatten the tree in-place (with O(1) extra space)?
 * 
 * @author sukh
 *
 */
public class _38_FlattenTreeToLinkedList {

  private _0_TreeNode prev;

  /**
   * Time: O(n) <br>
   * Space: O(log n) <br>
   * 
   * for skewed trees, Space: O(n)
   * 
   * @param root
   */
  public void flatten0(_0_TreeNode root) {
    /**
     * Recursive Approach
     * 
     * Reverse Post Order
     * 
     * Right -> Left -> Root
     */
    if (root == null) {
      return;
    }
    flatten(root.right);
    flatten(root.left);

    root.right = prev;
    root.left = null;
    prev = root;
  }

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param root
   */
  public void flatten1(_0_TreeNode root) {
    /**
     * Iterative Approach
     */
    if (root == null) {
      return;
    }
    Deque<_0_TreeNode> stack = new ArrayDeque<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      _0_TreeNode top = stack.pop();
      if (top.right != null) {
        stack.push(top.right);
      }
      if (top.left != null) {
        stack.push(top.left);
      }
      if (!stack.isEmpty()) {
        top.right = stack.peek();
      }
      top.left = null;
    }
  }

  /**
   * NOTE: <br>
   * 
   * Morris Traversal uses Threaded Binary Tree concept
   * 
   * Why to use this over DFS and BFS ?
   * 
   * Due to O(1) space complexity
   */

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * 
   * @param root
   */
  public void flatten(_0_TreeNode root) {
    /**
     * Threaded Binary Tree :
     * 
     * Create Threads from the right-most node of the left sub-tree to the Root's
     * right
     */
    _0_TreeNode curr = root;
    while (curr != null) {
      if (curr.left != null) {
        _0_TreeNode prev = curr.left;
        while (prev.right != null) {
          prev = prev.right;
        }
        prev.right = curr.right;
        curr.right = curr.left;
        curr.left = null;
      }
      curr = curr.right;
    }
  }

}
