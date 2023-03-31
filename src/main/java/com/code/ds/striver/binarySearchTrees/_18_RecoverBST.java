package com.code.ds.striver.binarySearchTrees;

/**
 * You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

 

Example 1:


Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
Example 2:


Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 

Constraints:

The number of nodes in the tree is in the range [2, 1000].
-231 <= Node.val <= 231 - 1
 

Follow up: A solution using O(n) space is pretty straight-forward. Could you devise a constant O(1) space solution?
 * 
 * @author sukh
 *
 */
public class _18_RecoverBST {

  private _0_TreeNode prev;
  private _0_TreeNode first;
  private _0_TreeNode mid;
  private _0_TreeNode last;

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param root
   */
  public void recoverTree(_0_TreeNode root) {
    /**
     * In-Order Traversal
     * 
     * Case 1: Nodes to be swapped are adjacent <br>
     * last = null
     * 
     * Case 2: Nodes to be swapped are not adjacent <br>
     * first and last are not null
     */
    if (root == null) {
      return;
    }
    prev = new _0_TreeNode(Integer.MIN_VALUE);

    inorder(root);

    if (first != null && last != null) {
      swap(first, last);
    } else if (last == null) {
      swap(first, mid);
    }
  }

  private void inorder(_0_TreeNode root) {
    if (root == null) {
      return;
    }

    inorder(root.left);

    update(root);

    inorder(root.right);
  }

  private void update(_0_TreeNode curr) {
    if (prev != null && curr.val < prev.val) {
      if (first == null) {
        /**
         * First violation
         * 
         * mark these 2 nodes as first and mid
         */
        first = prev;
        mid = curr;
      } else {
        /**
         * Second violation
         * 
         * mark this node as last
         */
        last = curr;
      }
    }
    prev = curr;
  }

  private void swap(_0_TreeNode a, _0_TreeNode b) {
    int temp = a.val;
    a.val = b.val;
    b.val = temp;
  }

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * 
   * @param root
   */
  public void recoverTree0(_0_TreeNode root) {
    /**
     * Morris In-Order Traversal
     * 
     * Case 1: Nodes to be swapped are adjacent <br>
     * last = null
     * 
     * Case 2: Nodes to be swapped are not adjacent <br>
     * first and last are not null
     */
    if (root == null) {
      return;
    }

    prev = new _0_TreeNode(Integer.MIN_VALUE);

    morris(root);

    if (first != null && last != null) {
      swap(first, last);
    } else if (last == null) {
      swap(first, mid);
    }
  }

  /**
   * Morris Traversal
   * 
   * @param root
   */
  private void morris(_0_TreeNode root) {
    _0_TreeNode curr = root;
    while (curr != null) {
      if (curr.left == null) {
        update(curr);
        curr = curr.right;
      } else {
        _0_TreeNode left = curr.left;
        while (left.right != null && left.right != curr) {
          left = left.right;
        }
        if (left.right == null) {
          left.right = curr;
          curr = curr.left;
        } else {
          left.right = null;
          update(curr);
          curr = curr.right;
        }
      }
    }
  }

  /**
   * NOTE:
   * 
   * Approach 2:
   * 
   * In-Order Traversal + Sort
   * 
   * In-Order Traversal compare with the Sorted In-Order Traversal
   * 
   * Update incorrect values
   * 
   * Time: O(n log n)
   * 
   * Space: O(n)
   */

}
