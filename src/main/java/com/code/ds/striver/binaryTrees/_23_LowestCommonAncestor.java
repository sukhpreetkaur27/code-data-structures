package com.code.ds.striver.binaryTrees;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q 
as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.
 * 
 * @author sukh
 *
 */
public class _23_LowestCommonAncestor {
  
  /**
   * NOTE: <br>
   * 
   * “The lowest common ancestor is defined between two nodes p and q as the
   * lowest node in T that has both p and q as descendants (where we allow a node
   * to be a descendant of itself).”
   */

  /**
   * Time: O(n) <br>
   * Space: O(height)
   * 
   * for skewed trees, Space: O(n)
   * 
   * @param root
   * @param p
   * @param q
   * @return
   */
  public _0_TreeNode lowestCommonAncestor(_0_TreeNode root, _0_TreeNode p,
      _0_TreeNode q) {
    /**
     * NOTE: Recursive Pre-Order Traversal
     * 
     * Traverse in both the directions
     * 
     * if node found, return the node
     * 
     * if node not found till the leaf node, return null
     * 
     * if both the sub-trees return null, return null
     * 
     * if both the sub-trees return non-null, current node is the ancestor, return
     * the current node
     * 
     * if either returns null, return the non-null node
     */
    if (root == null || root == p || root == q) {
      /**
       * if null node (or) either of the nodes is found, return the same
       */
      return root;
    }
    /**
     * find in the left sub-tree
     */
    _0_TreeNode left = lowestCommonAncestor(root.left, p, q);
    /**
     * find in the right sub-tree
     */
    _0_TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left != null && right != null) {
      /**
       * if both the paths return some node, we have found the ancestor, i.e., the
       * current node
       */
      return root;
    }
    if (left == null && right == null) {
      /**
       * if both the paths return null, return null for the path to the current node
       */
      return null;
    }
    if (left == null) {
      /**
       * if left is null, pick the right node
       */
      return right;
    } else {
      /**
       * if right is null, pick the right node
       */
      return left;
    }
  }

}
