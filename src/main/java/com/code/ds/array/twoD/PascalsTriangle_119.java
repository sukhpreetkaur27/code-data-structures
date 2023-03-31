package com.code.ds.array.twoD;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the
 * Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: rowIndex = 3 Output: [1,3,3,1] Example 2:
 * 
 * Input: rowIndex = 0 Output: [1] Example 3:
 * 
 * Input: rowIndex = 1 Output: [1,1]
 * 
 * 
 * Constraints:
 * 
 * 0 <= rowIndex <= 33
 * 
 * 
 * Follow up: Could you optimize your algorithm to use only O(rowIndex) extra
 * space?
 * @author sukh
 *
 */
public class PascalsTriangle_119 {

  /**
   * Used Maths.<br>
   * Time: O(k)<br>
   * Space: O(k)
   * @param rowIndex
   * @return
   */
  public List<Integer> getRow(int rowIndex) {
    List<Integer> row = new ArrayList<>();
    row.add(1);

    int prevCol;
    long diffFactor;
    int value;
    for (int r = 1; r <= rowIndex; r++) {
      prevCol = row.get(row.size() - 1);
      diffFactor = (long) (rowIndex - r + 1);
      value = (int) ((prevCol * diffFactor) / r);
      row.add(value);
    }
    return row;
  }

}
