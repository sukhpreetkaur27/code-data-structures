package com.code.ds.striver.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]
 

Constraints:

0 <= rowIndex <= 33
 

Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
 * 
 * @author sukh
 *
 */
public class _34_PascalsTriangle {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param r
   * @return
   */
  public List<Integer> getRow(int r) {
    List<Integer> row = new ArrayList<>();

    /**
     * NOTE:<br>
     * 0-based row
     */
    row.add(1);
    for (int c = 1; c <= r; r++) {
      int prev = row.get(c - 1);
      int diff = r - c + 1;
      int val = (int) ((diff * prev) / c);
      row.add(val);
    }

    return row;
  }

}
