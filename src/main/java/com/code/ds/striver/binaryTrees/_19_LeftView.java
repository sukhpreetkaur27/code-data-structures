package com.code.ds.striver.binaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. 
 * The task is to complete the function leftView(), which accepts root of the tree as argument.

Left view of following tree is 1 2 4 8.

          1
       /     \
     2        3
   /     \    /    \
  4     5   6    7
   \
     8   

Example 1:

Input:
   1
 /  \
3    2
Output: 1 3

Example 2:

Input:

Output: 10 20 40
Your Task:
You just have to complete the function leftView() that returns an array containing the nodes that are in the left view. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
0 <= Number of nodes <= 100
1 <= Data of a node <= 1000
 * 
 * @author sukh
 *
 */
public class _19_LeftView {

  /**
   * Time: O(n) <br>
   * Space: O(height)
   * 
   * for skewed trees, Space: O(n)
   * 
   * @param root
   * @return
   */
  public List<Integer> leftSideView(_0_TreeNode root) {
    /**
     * NOTE: Recursive Solution, i.e., DFS
     * 
     * Left View == Pre-Order Traversal == Root Left Right
     * 
     * the first node in each level is the left view
     */
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    leftView(root, res, 0);
    return res;
  }

  private void leftView(_0_TreeNode root, List<Integer> res, int level) {
    if (root == null) {
      return;
    }
    if (level == res.size()) {
      res.add(root.val);
    }
    leftView(root.left, res, level + 1);
    leftView(root.right, res, level + 1);
  }

  /**
   * NOTE: Iterative Solution , i.e., BFS <br>
   * 
   * Drawback:
   * 
   * Space: O(n)
   * 
   * here, we have to store all the nodes in the each(last is max) level
   * 
   * But for recursive solution we have to store only the nodes in a height of the
   * tree
   */

}
