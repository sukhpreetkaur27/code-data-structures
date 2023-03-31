package com.code.ds.striver.binarySearchTrees;

/**
 * Given a Binary Search Tree. The task is to find the maximum element in this given BST.

Example 1:

Input:
           5
         /    \
        4      6
       /        \
      3          7
     /
    1
Output: 7
Example 2:

Input:
             9
              \
               10
                \
                 11
Output: 11
Your Task:
The task is to complete the function maxValue() which takes root as the argument and returns the maximum element of BST. 
If the tree is empty, there is no maximum element, so return -1 in that case.

Expected Time Complexity: O(Height of the BST)
Expected Auxiliary Space: O(1).

Constraints:
0 <= N <= 104
 * 
 * @author sukh
 *
 */
public class _3_Max {

  /**
   * Time: O(log n) <br>
   * Space: O(1)
   * 
   * @param node
   * @return
   */
  int maxValue(_0_TreeNode node) {
    if (node == null) {
      return -1;
    }
    while (node.right != null) {
      node = node.right;
    }
    return node.val;
  }

}
