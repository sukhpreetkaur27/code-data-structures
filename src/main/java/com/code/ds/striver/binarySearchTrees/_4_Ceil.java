package com.code.ds.striver.binarySearchTrees;

/**
 * Given a BST and a number X, find Ceil of X.
Note: Ceil(X) is a number that is either equal to X or is immediately greater than X.

Example 1:

Input:
      5
    /   \
   1     7
    \
     2 
      \
       3
X = 3
Output: 3
Explanation: We find 3 in BST, so ceil
of 3 is 3.
Example 2:

Input:
     10
    /  \
   5    11
  / \ 
 4   7
      \
       8
X = 6
Output: 7
Explanation: We find 7 in BST, so ceil
of 6 is 7.
Your task:
You don't need to read input or print anything. Just complete the function findCeil() to implement ceil in BST which returns the ceil of X in the given BST.

Expected Time Complexity: O(Height of the BST)
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 <= Number of nodes <= 105
1 <= Value of nodes<= 105
 * 
 * @author sukh
 *
 */
public class _4_Ceil {

  /**
   * Time: O(log n) <br>
   * Space: O(1)
   * 
   * @param root
   * @param key
   * @return
   */
  int findCeil(_0_TreeNode root, int key) {
    if (root == null) {
      return -1;
    }
    int ceil = -1;
    while (root != null) {
      /**
       * Find Ceil
       */
      if (root.val >= key) {
        ceil = root.val;
      }
      if (ceil == key) {
        break;
      }
      /**
       * Search in a BST
       */
      root = root.val > key ? root.left : root.right;
    }
    return ceil;
  }

}
