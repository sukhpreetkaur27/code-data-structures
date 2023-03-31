package com.code.ds.striver.binaryTrees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, 
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, 
so please be creative and come up with different approaches yourself.

 

Example 1:


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
 * 
 * @author sukh
 *
 */
public class _35_SerializeDeserializeTree {

  /**
   * Encodes a tree to a single string.
   * 
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param root
   * @return
   */
  public String serialize(_0_TreeNode root) {
    if (root == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    Deque<_0_TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    sb.append(root.val);
    sb.append(",");
    while (!queue.isEmpty()) {
      _0_TreeNode top = queue.poll();
      if (top.left != null) {
        queue.offer(top.left);
        sb.append(top.left.val);
      } else {
        sb.append("null");
      }
      sb.append(",");
      if (top.right != null) {
        queue.offer(top.right);
        sb.append(top.right.val);
      } else {
        sb.append("null");
      }
      sb.append(",");
    }
    sb.setLength(sb.length() - 1);
    return sb.toString();
  }

  /**
   * Decodes your encoded data to tree.
   * 
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param data
   * @return
   */
  public _0_TreeNode deserialize(String data) {
    if (data == "") {
      return null;
    }
    String[] vals = data.split(",");
    _0_TreeNode root = new _0_TreeNode(Integer.parseInt(vals[0]));
    Deque<_0_TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    for (int i = 1, left = 0, right = 0; i < vals.length; i++) {
      _0_TreeNode top = queue.poll();
      String val = vals[i];
      if (!val.equals("null")) {
        left = Integer.parseInt(val);
        top.left = new _0_TreeNode(left);
        queue.offer(top.left);
      }
      val = vals[++i];
      if (!val.equals("null")) {
        right = Integer.parseInt(val);
        top.right = new _0_TreeNode(right);
        queue.offer(top.right);
      }
    }
    return root;
  }

}
