package com.code.ds.striver.binaryTrees;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

Example 1:


Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:


Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:


Input: p = [1,2,1], q = [1,1,2]
Output: false
 

Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104
 * 
 * @author sukh
 *
 */
public class _12_SameTree {

  /**
   * Time: O(n) <br>
   * Space: O(height)
   * 
   * Space: O(n) for skewed trees
   * 
   * @param p
   * @param q
   * @return
   */
  public boolean isSameTree(_0_TreeNode p, _0_TreeNode q) {
    if (p == null || q == null) {
      return p == q;
    }
    return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

}
