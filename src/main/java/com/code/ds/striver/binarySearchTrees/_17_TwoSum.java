package com.code.ds.striver.binarySearchTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

 

Example 1:


Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
Example 2:


Input: root = [5,3,6,2,4,null,7], k = 28
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-104 <= Node.val <= 104
root is guaranteed to be a valid binary search tree.
-105 <= k <= 105
 * 
 * @author sukh
 *
 */
public class _17_TwoSum {

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * 
   * @param root
   * @param k
   * @return
   */
  public boolean findTarget(_0_TreeNode root, int k) {
    /**
     * Morris Traversal + Two Pointer
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

    int sum;
    int lo = 0;
    int hi = inorder.size() - 1;
    while (lo < hi) {
      sum = inorder.get(lo) + inorder.get(hi);
      if (sum < k) {
        lo++;
      } else if (sum > k) {
        hi--;
      } else {
        return true;
      }
    }
    return false;
  }

  /**
   * Time: O(n) <br>
   * Space: O(log n)
   * 
   * @param root
   * @param k
   * @return
   */
  public boolean findTarget0(_0_TreeNode root, int k) {
    /**
     * BST Iterator + Two Pointer
     */
    _15_BST_Iterator iterator = new _15_BST_Iterator(root);

    int sum;
    int lo = iterator.next();
    int hi = iterator.before();
    while (lo < hi) {
      sum = lo + hi;
      if (sum < k) {
        lo = iterator.next();
      } else if (sum > k) {
        hi = iterator.before();
      } else {
        return true;
      }
    }
    return false;
  }

}
