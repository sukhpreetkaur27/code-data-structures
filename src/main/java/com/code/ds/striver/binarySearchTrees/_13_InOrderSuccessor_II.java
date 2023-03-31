package com.code.ds.striver.binarySearchTrees;

/**
 * Given a node in a binary search tree, return the in-order successor of that node in the BST. If that node has no in-order successor, return null.

The successor of a node is the node with the smallest key greater than node.val.

You will have direct access to the node but not to the root of the tree. Each node will have a reference to its parent node. Below is the definition for Node:

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
 

Example 1:


Input: tree = [2,1,3], node = 1
Output: 2
Explanation: 1's in-order successor node is 2. Note that both the node and the return value is of Node type.
Example 2:


Input: tree = [5,3,6,2,4,null,null,1], node = 6
Output: null
Explanation: There is no in-order successor of the current node, so the answer is null.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
All Nodes will have unique values.
 

Follow up: Could you solve it without looking up any of the node's values?
 * 
 * @author sukh
 *
 */
public class _13_InOrderSuccessor_II {

  /**
   * Time: O(log n) <br>
   * Space: O(1)
   * 
   * @param _0_Node
   * @return
   */
  public _0_Node inorderSuccessor(_0_Node _0_Node) {
    _0_Node curr = _0_Node;
    /**
     * if right child exists
     */
    if (curr.right != null) {
      /**
       * the successor is somewhere lower in the right subtree
       */
      curr = curr.right;
      while (curr.left != null) {
        curr = curr.left;
      }
      return curr;
    }

    /**
     * if right child doesn't exists
     */
    /**
     * the successor is somewhere upper in the tree
     */
    while (curr.parent != null && curr.parent.right == curr) {
      curr = curr.parent;
    }
    return curr.parent;
  }

}
