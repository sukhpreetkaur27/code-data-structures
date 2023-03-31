package com.code.ds.striver.binarySearchTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
 * 
 * @author sukh
 *
 */
public class _10_ValidateBST {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param root
   * @return
   */
  public boolean isValidBST(_0_TreeNode root) {
    return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean isValid(_0_TreeNode root, long min, long max) {
    if (root == null) {
      return true;
    }
    if (root.val >= max || root.val <= min) {
      return false;
    }
    return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
  }

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * 
   * @param root
   * @return
   */
  public boolean isValidBST0(_0_TreeNode root) {
    /**
     * Morris Traversal
     */
    _0_TreeNode curr = root;
    List<Integer> inorder = new ArrayList<>();
    while (curr != null) {
      if (curr.left == null) {
        inorder.add(curr.val);
        curr = curr.right;
      } else {
        _0_TreeNode prev = curr.left;
        while (prev.right != null && prev.right != curr) {
          prev = prev.right;
        }
        if (prev.right == null) {
          prev.right = curr;
          curr = curr.left;
        } else {
          prev.right = null;
          inorder.add(curr.val);
          curr = curr.right;
        }
      }
    }
    for (int i = 1; i < inorder.size(); i++) {
      if (inorder.get(i) <= inorder.get(i - 1)) {
        return false;
      }
    }
    return true;
  }

}
