package com.code.ds.striver.binaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * The boundary of a binary tree is the concatenation of the root, the left boundary, the leaves ordered from left-to-right, and the reverse order of the right boundary.

The left boundary is the set of nodes defined by the following:

The root node's left child is in the left boundary. If the root does not have a left child, then the left boundary is empty.
If a node in the left boundary and has a left child, then the left child is in the left boundary.
If a node is in the left boundary, has no left child, but has a right child, then the right child is in the left boundary.
The leftmost leaf is not in the left boundary.
The right boundary is similar to the left boundary, except it is the right side of the root's right subtree. Again, the leaf is not part of the right boundary, 
and the right boundary is empty if the root does not have a right child.

The leaves are nodes that do not have any children. For this problem, the root is not a leaf.

Given the root of a binary tree, return the values of its boundary.

 

Example 1:


Input: root = [1,null,2,3,4]
Output: [1,3,4,2]
Explanation:
- The left boundary is empty because the root does not have a left child.
- The right boundary follows the path starting from the root's right child 2 -> 4.
  4 is a leaf, so the right boundary is [2].
- The leaves from left to right are [3,4].
Concatenating everything results in [1] + [] + [3,4] + [2] = [1,3,4,2].
Example 2:


Input: root = [1,2,3,4,5,6,null,null,null,7,8,9,10]
Output: [1,2,4,7,8,9,10,6,3]
Explanation:
- The left boundary follows the path starting from the root's left child 2 -> 4.
  4 is a leaf, so the left boundary is [2].
- The right boundary follows the path starting from the root's right child 3 -> 6 -> 10.
  10 is a leaf, so the right boundary is [3,6], and in reverse order is [6,3].
- The leaves from left to right are [4,7,8,9,10].
Concatenating everything results in [1] + [2] + [4,7,8,9,10] + [6,3] = [1,2,4,7,8,9,10,6,3].
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-1000 <= Node.val <= 1000
 * 
 * @author sukh
 *
 */
public class _14_BoundaryTraversal {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param root
   * @return
   */
  public List<Integer> boundaryOfBinaryTree(_0_TreeNode root) {
    List<Integer> traversal = new ArrayList<>();
    /**
     * if Root is a leaf node, then add it during leaf traversal
     */
    if (!isLeaf(root)) {
      traversal.add(root.val);
    }
    /**
     * Pre-Order Traversal for Left Boundary
     * 
     * Left Boundary has only left nodes except leaf nodes <br>
     * if left child doesn't exist, then go for right child
     */
    leftBoundary(root, traversal);
    /**
     * In-Order Traversal for Leaf Nodes
     */
    leaf(root, traversal);
    /**
     * Pre-Order Traversal for Right Boundary
     * 
     * Right Boundary has only right nodes except leaf nodes <br>
     * if right child doesn't exist, then go for left child
     */
    rightBoundary(root, traversal);
    return traversal;
  }

  /**
   * check for a leaf node
   * 
   * @param root
   * @return
   */
  private boolean isLeaf(_0_TreeNode root) {
    if (root.left == null && root.right == null) {
      return true;
    }
    return false;
  }

  /**
   * Check for left boundary using Pre-Order Traversal
   * 
   * @param root
   * @param traversal
   */
  private void leftBoundary(_0_TreeNode root, List<Integer> traversal) {
    _0_TreeNode curr = root.left;
    while (curr != null) {
      if (!isLeaf(curr)) {
        traversal.add(curr.val);
      }
      if (curr.left != null) {
        curr = curr.left;
      } else {
        curr = curr.right;
      }
    }
  }

  /**
   * Check for leaf nodes using In-Order Traversal
   * 
   * @param root
   * @param traversal
   */
  private void leaf(_0_TreeNode root, List<Integer> traversal) {
    if (isLeaf(root)) {
      traversal.add(root.val);
    }
    if (root.left != null) {
      leaf(root.left, traversal);
    }
    if (root.right != null) {
      leaf(root.right, traversal);
    }
  }

  /**
   * Check for right boundary using Pre-Order Traversal
   * 
   * @param root
   * @param traversal
   */
  private void rightBoundary(_0_TreeNode root, List<Integer> traversal) {
    Deque<Integer> stack = new ArrayDeque<>();
    _0_TreeNode curr = root.right;
    while (curr != null) {
      if (!isLeaf(curr)) {
        stack.push(curr.val);
      }
      if (curr.right != null) {
        curr = curr.right;
      } else {
        curr = curr.left;
      }
    }
    while (!stack.isEmpty()) {
      traversal.add(stack.pop());
    }
  }

}
