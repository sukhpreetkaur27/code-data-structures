package com.code.ds.striver.binarySearchTrees;

/**
 * Given the root of a binary tree, find the largest subtree, which is also a Binary Search Tree (BST), where the largest means subtree has the largest number of nodes.

A Binary Search Tree (BST) is a tree in which all the nodes follow the below-mentioned properties:

The left subtree values are less than the value of their parent (root) node's value.
The right subtree values are greater than the value of their parent (root) node's value.
Note: A subtree must include all of its descendants.

 

Example 1:



Input: root = [10,5,15,1,8,null,7]
Output: 3
Explanation: The Largest BST Subtree in this case is the highlighted one. The return value is the subtree's size, which is 3.
Example 2:

Input: root = [4,2,7,2,3,5,null,2,null,null,null,null,null,1]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-104 <= Node.val <= 104
 

Follow up: Can you figure out ways to solve it with O(n) time complexity?
 * 
 * @author sukh
 *
 */
public class _19_LargestBST {

  /**
   * Each node will return min node value, max node value, max size
   * 
   * @author sukh
   *
   */
  class Node {
    int size;
    int min;
    int max;

    Node(int size, int min, int max) {
      this.size = size;
      this.min = min;
      this.max = max;
    }
  }

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * Can use Morris Traversal for Space: O(1)
   * 
   * @param root
   * @return
   */
  public int largestBSTSubtree(_0_TreeNode root) {
    return postorder(root).size;
  }

  private Node postorder(_0_TreeNode root) {
    /**
     * An empty tree is a BST of size 0.
     */
    if (root == null) {
      return new Node(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    /**
     * Get values from left and right subtree of current tree.
     */
    Node left = postorder(root.left);
    Node right = postorder(root.right);

    /**
     * Current node is greater than max in left AND smaller than min in right, it is
     * a BST.
     */
    if (left.max < root.val && root.val < right.min) {
      /**
       * It is a BST.
       */
      return new Node(1 + left.size + right.size, Math.min(root.val, left.min),
          Math.max(root.val, right.max));
    }

    /**
     * Otherwise, return [-inf, inf] so that parent can't be valid BST
     */
    return new Node(Math.max(left.size, right.size), Integer.MIN_VALUE,
        Integer.MAX_VALUE);
  }

  /**
   * NOTE: Brute Force
   * 
   * For each node (Time: O(n)):
   * 
   * 1. Check if it's a valid BST : Time: O(n) <br>
   * a. If yes, find the size
   * 
   * Time: O(n^2)
   * 
   * Space: O(n)
   */

}
