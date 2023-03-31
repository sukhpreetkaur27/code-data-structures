package com.code.ds.striver.binaryTrees;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, 
 * construct and return the binary tree.

 

Example 1:


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
 

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
 * 
 * @author sukh
 *
 */
public class _34_ConstructTreeInOrderPostOrder {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param inorder
   * @param postorder
   * @return
   */
  public _0_TreeNode buildTree(int[] inorder, int[] postorder) {
    /**
     * Hash in-order position
     * 
     * start with post-order end
     * 
     * look for post-order values in in-order hash
     * 
     * root = post-order[end]
     * 
     * root.left sub-tree = <br>
     * = in-order start to in-order root - 1 == numsLeft <br>
     * = post-order start to post-order + numsLeft - 1
     * 
     * root.right sub-tree = <br>
     * = in-order root + 1 to in-order end <br>
     * = post-order start + numsLeft to post-order end - 1
     * 
     */
    Map<Integer, Integer> inMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inMap.put(inorder[i], i);
    }
    return build(postorder, 0, postorder.length - 1, 0, inorder.length - 1, inMap);
  }

  private _0_TreeNode build(int[] postorder, int postStart, int postEnd, int inStart,
      int inEnd, Map<Integer, Integer> inMap) {
    if (postStart > postEnd || inStart > inEnd) {
      return null;
    }
    _0_TreeNode root = new _0_TreeNode(postorder[postEnd]);
    int inRoot = inMap.get(root.val);
    int numsLeft = inRoot - inStart;
    /**
     * postStart = postStart
     * 
     * postEnd = postStart + numsLeft - 1
     * 
     */
    root.left = build(postorder, postStart, postStart + numsLeft - 1, inStart, inRoot - 1,
        inMap);
    root.right = build(postorder, postStart + numsLeft, postEnd - 1, inRoot + 1, inEnd,
        inMap);
    return root;
  }

}
