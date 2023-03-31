package com.code.ds.striver.binarySearchTrees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * You are given n BST (binary search tree) root nodes for n separate BSTs stored in an array trees (0-indexed). Each BST in trees has at most 3 nodes, 
 * and no two roots have the same value. In one operation, you can:

Select two distinct indices i and j such that the value stored at one of the leaves of trees[i] is equal to the root value of trees[j].
Replace the leaf node in trees[i] with trees[j].
Remove trees[j] from trees.
Return the root of the resulting BST if it is possible to form a valid BST after performing n - 1 operations, or null if it is impossible to create a valid BST.

A BST (binary search tree) is a binary tree where each node satisfies the following property:

Every node in the node's left subtree has a value strictly less than the node's value.
Every node in the node's right subtree has a value strictly greater than the node's value.
A leaf is a node that has no children.

 

Example 1:


Input: trees = [[2,1],[3,2,5],[5,4]]
Output: [3,2,5,1,null,4]
Explanation:
In the first operation, pick i=1 and j=0, and merge trees[0] into trees[1].
Delete trees[0], so trees = [[3,2,5,1],[5,4]].

In the second operation, pick i=0 and j=1, and merge trees[1] into trees[0].
Delete trees[1], so trees = [[3,2,5,1,null,4]].

The resulting tree, shown above, is a valid BST, so return its root.
Example 2:


Input: trees = [[5,3,8],[3,2,6]]
Output: []
Explanation:
Pick i=0 and j=1 and merge trees[1] into trees[0].
Delete trees[1], so trees = [[5,3,8,2,6]].

The resulting tree is shown above. This is the only valid operation that can be performed, but the resulting tree is not a valid BST, so return null.
Example 3:


Input: trees = [[5,4],[3]]
Output: []
Explanation: It is impossible to perform any operations.
 

Constraints:

n == trees.length
1 <= n <= 5 * 104
The number of nodes in each tree is in the range [1, 3].
Each node in the input may have children but no grandchildren.
No two roots of trees have the same value.
All the trees in the input are valid BSTs.
1 <= TreeNode.val <= 5 * 104.
 * 
 * @author sukh
 *
 */
public class _16_MergeBSTs {

  public _0_TreeNode canMerge(List<_0_TreeNode> trees) {
    /**
     * Store the leaf values
     */
    Set<Integer> leaves = new HashSet<>();
    /**
     * Stores the Roots
     * 
     * Root.val maps to Root node
     */
    Map<Integer, _0_TreeNode> roots = new HashMap<>();

    for (_0_TreeNode root : trees) {
      roots.put(root.val, root);
      if (root.left != null) {
        leaves.add(root.left.val);
      }
      if (root.right != null) {
        leaves.add(root.right.val);
      }
    }

    _0_TreeNode result = null;
    for (_0_TreeNode root : trees) {
      /**
       * 1 root doesn't exist as a leaf <br>
       * (as per the question --> form a valid BST after performing n - 1 operations)
       */
      if (!leaves.contains(root.val)) {
        result = root;
        break;
      }
    }
    /**
     * if no such root exist, return null
     */
    if (result == null) {
      return null;
    }

    /**
     * Check for validity of the BST by merging the leaves with the root
     * 
     * only 1 root should remain in the roots map (the result)
     * 
     * eg: [[5, 4], [3]]
     * 
     * this cannot be merged
     * 
     * hence, the check --> roots.size()==1
     */
    return isValid(result, roots, Integer.MIN_VALUE, Integer.MAX_VALUE)
        && roots.size() == 1 ? result : null;
  }

  private boolean isValid(_0_TreeNode root, Map<Integer, _0_TreeNode> roots, int min,
      int max) {
    if (root == null) {
      return true;
    }
    if (root.val <= min || root.val >= max) {
      return false;
    }

    if (root.left == null && root.right == null) {
      /**
       * the leaf shouldn't be itself a root, otherwise it will be removed from the
       * map (roots)
       * 
       * eg: [[7]]
       * 
       * single tree
       */
      if (roots.containsKey(root.val) && root != roots.get(root.val)) {
        _0_TreeNode next = roots.get(root.val);
        root.left = next.left;
        root.right = next.right;
        /**
         * Remove merged roots, to check for valid merging
         * 
         * eg: [[5, 4], [3]]
         * 
         * this cannot be merged
         * 
         * hence, the check --> roots.size()==1
         */
        roots.remove(root.val);
      }
    }

    return isValid(root.left, roots, min, root.val)
        && isValid(root.right, roots, root.val, max);
  }

}
