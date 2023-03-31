package com.code.ds.striver.binaryTrees;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, 
 * construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
 * 
 * @author sukh
 *
 */
public class _33_ConstructTreeInOrderPreOrder {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param preorder
   * @param inorder
   * @return
   */
  public _0_TreeNode buildTree(int[] preorder, int[] inorder) {
    /**
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
    Map<Integer, Integer> inMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inMap.put(inorder[i], i);
    }
    return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1, inMap);
  }

  private _0_TreeNode build(int[] preorder, int preStart, int preEnd, int inStart,
      int inEnd, Map<Integer, Integer> inMap) {
    if (preStart > preEnd || inStart > inEnd) {
      return null;
    }
    _0_TreeNode root = new _0_TreeNode(preorder[preStart]);
    int inRoot = inMap.get(root.val);
    int numsLeft = inRoot - inStart;
    root.left = build(preorder, preStart + 1, preStart + numsLeft, inStart, inRoot - 1,
        inMap);
    root.right = build(preorder, preStart + numsLeft + 1, preEnd, inRoot + 1, inEnd,
        inMap);
    return root;
  }

}
