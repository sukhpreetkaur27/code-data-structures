package com.code.ds.striver.binaryTrees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), 
where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.

 

Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
Example 2:


Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
Example 3:


Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width exists in the second level with length 2 (3,2).
 

Constraints:

The number of nodes in the tree is in the range [1, 3000].
-100 <= Node.val <= 100
 * 
 * @author sukh
 *
 */
public class _24_MaxWidth {

  class Pair {
    _0_TreeNode node;
    int index;

    Pair(_0_TreeNode node, int index) {
      this.node = node;
      this.index = index;
    }
  }

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param root
   * @return
   */
  public int widthOfBinaryTree(_0_TreeNode root) {
    /**
     * NOTE: <br>
     * 
     * Level Order Traversal
     * 
     * Assign 0 based indexing to each node
     * 
     * the current index of each node = currentIndex - minIndex of the current level
     * <br>
     * this is done to avoid integer overflow
     * 
     * left child index = 2 * parentIndex + 1
     * 
     * right child index = 2 * parentIndex + 2
     * 
     * width = lastIndex of the level - firstIndex of the same level + 1
     */
    if (root == null) {
      return 0;
    }
    Deque<Pair> queue = new ArrayDeque<>();
    queue.offer(new Pair(root, 0));

    int width = 0;
    int size;
    int currIndex;
    int last;
    int first;
    int minIndex;

    while (!queue.isEmpty()) {
      size = queue.size();
      currIndex = 0;
      last = 0;
      first = 0;
      minIndex = queue.peek().index;

      for (int i = 0; i < size; i++) {
        Pair pair = queue.poll();
        currIndex = pair.index - minIndex;
        _0_TreeNode node = pair.node;

        if (i == 0) {
          first = currIndex;
        } else if (i == size - 1) {
          last = currIndex;
        }

        if (node.left != null) {
          queue.offer(new Pair(node.left, 2 * currIndex + 1));
        }
        if (node.right != null) {
          queue.offer(new Pair(node.right, 2 * currIndex + 2));
        }
      }

      width = Math.max(width, last - first + 1);
    }

    return width;
  }

}
