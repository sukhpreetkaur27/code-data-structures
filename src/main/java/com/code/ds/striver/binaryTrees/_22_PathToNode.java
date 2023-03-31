package com.code.ds.striver.binaryTrees;

import java.util.ArrayList;

/**
 * Problem Description

Given a Binary Tree A containing N nodes.

You need to find the path from Root to a given node B.

NOTE:

No two nodes in the tree have same data values.
You can assume that B is present in the tree A and a path always exists.


Problem Constraints
 1 <= N <= 105 

 1 <= Data Values of Each Node <= N

 1 <= B <= N



Input Format
First Argument represents pointer to the root of binary tree A.

Second Argument is an integer B denoting the node number.



Output Format
Return an one-dimensional array denoting the path from Root to the node B in order.



Example Input
Input 1:

 A =

           1
         /   \
        2     3
       / \   / \
      4   5 6   7 


B = 5

Input 2:

 A = 
            1
          /   \
         2     3
        / \ .   \
       4   5 .   6


B = 1




Example Output
Output 1:

 [1, 2, 5]
Output 2:

 [1]


Example Explanation
Explanation 1:

 We need to find the path from root node to node with data value 5.
 So the path is 1 -> 2 -> 5 so we will return [1, 2, 5]
Explanation 2:

 We need to find the path from root node to node with data value 1.
 As node with data value 1 is the root so there is only one node in the path.
 So we will return [1]
 * 
 * @author sukh
 *
 */
public class _22_PathToNode {

  /**
   * Time: O(n) <br>
   * Space: O(height)
   * 
   * for skewed trees, Space: O(n)
   * 
   * @param root
   * @param target
   * @return
   */
  public ArrayList<Integer> solve(_0_TreeNode root, int target) {
    /**
     * NOTE: Recursive <br>
     * 
     * Tree Path to a Node == In-Order Traversal
     */
    ArrayList<Integer> list = new ArrayList<>();
    path(list, root, target);
    return list;
  }

  private boolean path(ArrayList<Integer> list, _0_TreeNode root, int target) {
    if (root == null) {
      return false;
    }
    list.add(root.val);
    if (root.val == target) {
      /**
       * if node found, exit
       */
      return true;
    }
    if (path(list, root.left, target) || path(list, root.right, target)) {
      /**
       * if node found either on the left or right sub-tree, exit
       */
      return true;
    }

    /**
     * Invalid path, remove the current node
     */
    list.remove(list.size() - 1);

    return false;
  }

}
