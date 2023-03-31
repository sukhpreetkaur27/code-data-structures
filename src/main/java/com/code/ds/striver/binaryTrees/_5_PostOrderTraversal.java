package com.code.ds.striver.binaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [3,2,1]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
 

Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author sukh
 *
 */
public class _5_PostOrderTraversal {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param root
   * @return
   */
  public List<Integer> postorderTraversal1(_0_TreeNode root) {
    /**
     * Recursive
     */
    List<Integer> list = new ArrayList<>();
    postorder(root, list);
    return list;
  }

  private void postorder(_0_TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    postorder(root.left, list);
    postorder(root.right, list);
    list.add(root.val);
  }

  /**
   * Time: O(n) <br>
   * Space: O(2n)
   * 
   * @param root
   * @return
   */
  public List<Integer> postorderTraversal2(_0_TreeNode root) {
    /**
     * Iterative: 2 Stacks
     */
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    Deque<_0_TreeNode> stack1 = new ArrayDeque<>();
    Deque<_0_TreeNode> stack2 = new ArrayDeque<>();

    /**
     * Push Root
     */
    stack1.push(root);

    while (!stack1.isEmpty()) {
      /**
       * Pop Node from stack1 and push it to stack2 <br>
       * Push node's left and right to stack1
       */
      _0_TreeNode pop = stack1.pop();
      stack2.push(pop);
      if (pop.left != null) {
        stack1.push(pop.left);
      }
      if (pop.right != null) {
        stack1.push(pop.right);
      }
    }

    /**
     * pop stack2 == pre-order traversal
     */
    while (!stack2.isEmpty()) {
      list.add(stack2.pop().val);
    }
    return list;
  }

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param root
   * @return
   */
  public List<Integer> postorderTraversal(_0_TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Deque<_0_TreeNode> stack = new ArrayDeque<>();

    /**
     * Start with Root
     */
    _0_TreeNode curr = root;

    while (curr != null || !stack.isEmpty()) {
      if (curr != null) {
        /**
         * Push Root and move to Left
         */
        stack.push(curr);
        curr = curr.left;
      } else {
        /**
         * if Left == null <br>
         * Check for Right
         */
        _0_TreeNode top = stack.peek().right;
        if (top == null) {
          /**
           * If Right == null <br>
           * Push the Root
           */
          top = stack.pop();
          list.add(top.val);
          while (!stack.isEmpty() && stack.peek().right == top) {
            /**
             * If Pop == Root's Right <br>
             * Pop Root
             */
            top = stack.pop();
            list.add(top.val);
          }
        } else {
          /**
           * Move to Right
           */
          curr = top;
        }
      }
    }

    return list;
  }

}
