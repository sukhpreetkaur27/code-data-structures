package com.code.ds.striver.binarySearchTrees;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
 

Example 1:


Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Example 2:

Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.
Example 3:

Input: root = [], key = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-105 <= Node.val <= 105
Each node has a unique value.
root is a valid binary search tree.
-105 <= key <= 105
 

Follow up: Could you solve it with time complexity O(height of tree)?
 * 
 * @author sukh
 *
 */
public class _7_Delete {

  /**
   * Time: O(log n) <br>
   * Space: O(1)
   * 
   * @param root
   * @param key
   * @return
   */
  public _0_TreeNode deleteNode(_0_TreeNode root, int key) {
    /**
     * Delete Algo:
     * 
     * 1. Search the node
     * 
     * 2. Delete the node
     */
    if (root == null) {
      return null;
    }
    if (root.val == key) {
      /**
       * if root is to be deleted
       */
      return helper(root);
    }
    _0_TreeNode curr = root;
    while (curr != null) {
      if (curr.val > key) {
        /**
         * if key < root, check on the LHS
         */
        if (curr.left != null && curr.left.val == key) {
          curr.left = helper(curr.left);
          break;
        } else {
          curr = curr.left;
        }
      } else {
        /**
         * if key > root, check on the RHS
         */
        if (curr.right != null && curr.right.val == key) {
          curr.right = helper(curr.right);
          break;
        } else {
          curr = curr.right;
        }
      }
    }
    /**
     * always return root
     */
    return root;
  }

  /**
   * Delete the node and return node to attach to root's left (or) right i.e.
   * in-place of the deleted node
   * 
   * if no left node exists, return the right node
   * 
   * if no right node exists, return the left node
   * 
   * if both the left and the right node exists, return the left node (to attach
   * to the root); and attach the right node to the right of the last right node
   * to its left
   * 
   * @param del
   * @return
   */
  private _0_TreeNode helper(_0_TreeNode del) {
    if (del.left == null) {
      return del.right;
    } else if (del.right == null) {
      return del.left;
    } else {
      _0_TreeNode right = del.right;
      _0_TreeNode lastRight = lastRight(del.left);
      lastRight.right = right;
      return del.left;
    }
  }

  /**
   * Find the last right node
   * 
   * @param node
   * @return
   */
  private _0_TreeNode lastRight(_0_TreeNode node) {
    if (node.right == null) {
      return node;
    }
    return lastRight(node.right);
  }

}
