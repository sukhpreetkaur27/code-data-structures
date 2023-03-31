package com.code.ds.striver.binaryTrees;

/**
 * Given an integer i. Print the maximum number of nodes on level i of a binary tree.

Example 1:

Input: 5
Output: 16
Example 2:

Input: 1
Output: 1
 

Your Task:

Complete the function countNode() which takes an integer i as input and prints the count of maximum number of nodes at that level.

 

Expected Time Complexity: O(1)

Expected Space Complexity: O(1)

 

Constraints:

1<=i<=20
 * 
 * @author sukh
 *
 */
public class _1_MaxNodes {
  
  /**
   * NOTE: level starts with 0
   */

  /**
   * Time: O(1) <br>
   * Space: O(1)
   * 
   * @param level
   * @return
   */
  public int countNodes(int level) {
    return (int) Math.pow(2, (level - 1));
  }

}
