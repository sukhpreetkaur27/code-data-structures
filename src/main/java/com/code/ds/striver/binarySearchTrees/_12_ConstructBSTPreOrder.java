package com.code.ds.striver.binarySearchTrees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.

It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.

A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, 
and any descendant of Node.right has a value strictly greater than Node.val.

A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.

 

Example 1:


Input: preorder = [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
Example 2:

Input: preorder = [1,3]
Output: [1,null,3]
 

Constraints:

1 <= preorder.length <= 100
1 <= preorder[i] <= 1000
All the values of preorder are unique.
 * 
 * @author sukh
 *
 */
public class _12_ConstructBSTPreOrder {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param preorder
   * @return
   */
  public _0_TreeNode bstFromPreorder(int[] preorder) {
    /**
     * Refer {@link com.code.ds.striver.binarySearchTrees._10_ValidateBST}
     */
    /**
     * pass the upper bound
     */
    return build1(preorder, new int[] { 0 }, Integer.MAX_VALUE);
  }

  private _0_TreeNode build1(int[] preorder, int[] index, int upperBound) {
    /**
     * if value > upperb ound --> return null
     */
    if (index[0] == preorder.length || preorder[index[0]] > upperBound) {
      return null;
    }
    _0_TreeNode node = new _0_TreeNode(preorder[index[0]++]);
    /**
     * for left sub-tree, upper bound = node.val
     */
    node.left = build1(preorder, index, node.val);
    /**
     * for right sub-tree, upper bound = upperBound.val
     */
    node.right = build1(preorder, index, upperBound);
    return node;
  }

  /**
   * Time: O(n log n) <br>
   * Space: O(n)
   * 
   * @param preorder
   * @return
   */
  public _0_TreeNode bstFromPreorder0(int[] preorder) {
    /**
     * Create in-order by sorting pre-order <br>
     * Now, the problem ==
     * {@link com.code.ds.striver.binaryTrees._33_ConstructTreeInOrderPreOrder}
     * 
     * Hash in-order position
     * 
     * start with pre-order start
     * 
     * look for pre-order values in in-order hash
     * 
     * root = pre-order[start]
     * 
     * root.left sub-tree = <br>
     * = in-order start to in-order root - 1 == numsLeft <br>
     * = pre-order start + 1 to pre-order + numsLeft
     * 
     * root.right sub-tree = <br>
     * = in-order root + 1 to in-order end <br>
     * = pre-order start + numsLeft to pre-order end
     * 
     */
    int[] inorder = preorder.clone();
    Arrays.sort(inorder);
    Map<Integer, Integer> inMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inMap.put(inorder[i], i);
    }
    return build(inMap, preorder, 0, preorder.length - 1, 0, inorder.length - 1);
  }

  private _0_TreeNode build(Map<Integer, Integer> inMap, int[] preorder, int preStart,
      int preEnd, int inStart, int inEnd) {
    if (inStart > inEnd || preStart > preEnd) {
      return null;
    }
    _0_TreeNode node = new _0_TreeNode(preorder[preStart]);
    int inRoot = inMap.get(node.val);
    int numsLeft = inRoot - inStart;

    node.left = build(inMap, preorder, preStart + 1, preStart + numsLeft, inStart,
        inRoot - 1);
    node.right = build(inMap, preorder, preStart + numsLeft + 1, preEnd, inRoot + 1,
        inEnd);
    return node;
  }

}
