package com.code.ds.striver.binarySearchTrees;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants 
(where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [2,1], p = 2, q = 1
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST.
 * 
 * @author sukh
 *
 */
public class _11_LCA {

  /**
   * Time: O(log n) <br>
   * Space: O(1)
   * 
   * @param root
   * @param p
   * @param q
   * @return
   */
  public _0_TreeNode lowestCommonAncestor(_0_TreeNode root, _0_TreeNode p,
      _0_TreeNode q) {
    /**
     * Iterative Approach
     */
    if (root == null) {
      return null;
    }
    _0_TreeNode curr = root;
    while (curr != null) {
      /**
       * if both the values lie on the right
       */
      if (curr.val < p.val && curr.val < q.val) {
        curr = curr.right;
      } else if (curr.val > p.val && curr.val > q.val) {
        /**
         * if both the values lie on the left
         */
        curr = curr.left;
      } else {
        /**
         * if both the values lie on opposite sides
         * 
         * if the (root == p || root == q) && (either p or q lies on one side)
         * 
         * in both the above cases, the root is the LCA
         */
        break;
      }
    }
    return curr;
  }

  /**
   * Time: O(log n) <br>
   * Space: O(log n)
   * 
   * @param root
   * @param p
   * @param q
   * @return
   */
  public _0_TreeNode lowestCommonAncestor0(_0_TreeNode root, _0_TreeNode p,
      _0_TreeNode q) {
    /**
     * Recursive Approach
     */
    if (root == null) {
      return null;
    }
    /**
     * if both the values lie on the right
     */
    if (root.val < p.val && root.val < q.val) {
      return lowestCommonAncestor0(root.right, p, q);
    }
    /**
     * if both the values lie on the left
     */
    if (root.val > p.val && root.val > q.val) {
      return lowestCommonAncestor0(root.left, p, q);
    }
    /**
     * if both the values lie on opposite sides
     * 
     * if the (root == p || root == q) && (either p or q lies on one side)
     * 
     * in both the above cases, the root is the LCA
     */
    return root;
  }

}
