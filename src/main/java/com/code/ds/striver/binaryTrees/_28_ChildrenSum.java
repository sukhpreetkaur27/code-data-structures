package com.code.ds.striver.binaryTrees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a Binary Tree. Check whether all of its nodes have the value equal to the sum of their child nodes.


Example 1:

Input:
     10
    /
  10 
Output: 1
Explanation: Here, every node is sum of
its left and right child.
Example 2:

Input:
       1
     /   \
    4     3
   /  \
  5    N
Output: 0
Explanation: Here, 1 is the root node
and 4, 3 are its child nodes. 4 + 3 =
7 which is not equal to the value of
root node. Hence, this tree does not
satisfy the given conditions.

Your Task:
You don't need to read input or print anything. Your task is to complete the function isSumProperty() 
that takes the root Node of the Binary Tree as input and returns 1 if all the nodes in the tree satisfy the following properties. 
Else, it returns 0.
For every node, data value must be equal to the sum of data values in left and right children. 
Consider data value as 0 for NULL child.  Also, leaves are considered to follow the property.


Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

 

Constraints:
1 <= N <= 105
1 <= Data on nodes <= 105
 * 
 * @author sukh
 *
 */
public class _28_ChildrenSum {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param root
   * @return
   */
  public static int isSumProperty(_0_TreeNode root) {
    /**
     * NOTE: <br>
     * Level Order Traversal
     */
    Deque<_0_TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      _0_TreeNode top = queue.poll();
      int sum = top.val;
      if (top.left != null) {
        sum -= top.left.val;
        queue.offer(top.left);
      }
      if (top.right != null) {
        sum -= top.right.val;
        queue.offer(top.right);
      }
      if (sum == 0 || sum == top.val) {
        continue;
      } else {
        return 0;
      }
    }
    return 1;
  }

  /**
   * Time: O(n) <br>
   * Space: O(height)
   * 
   * for skewed trees, Space: O(n)
   * 
   * @param node
   * @return
   */
  public static int isSumProperty1(_0_TreeNode node) {
    /**
     * NOTE: <br>
     * Recursive Traversal
     */
    int left_data = 0;
    int right_data = 0;

    // if node is null or both child nodes are null, we return true.
    if (node == null || (node.left == null && node.right == null))
      return 1;

    else {
      // if left child is not null then we store its value.
      if (node.left != null)
        left_data = node.left.val;

      // if right child is not null then we store its value.
      if (node.right != null)
        right_data = node.right.val;

      /// if sum of stored data of left and right child is equal to the
      // current node data and recursively for the left and right subtree,
      // parent data is equal to sum of child data then we return true.
      if ((node.val == left_data + right_data)
          && (isSumProperty(node.left) != 0 && isSumProperty(node.right) != 0))
        return 1;

      // else we return false.
      else
        return 0;
    }

  }

}
