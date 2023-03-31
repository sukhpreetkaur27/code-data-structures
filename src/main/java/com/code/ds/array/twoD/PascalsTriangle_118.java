package com.code.ds.array.twoD;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30
 * @author sukh
 *
 */
public class PascalsTriangle_118 {

  /**
   * Time: O(n^2)<br>
   * Space: O(1)
   * @param numRows
   * @return
   */
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle = new ArrayList<>();

    List<Integer> row = new ArrayList<>();
    triangle.add(row);
    triangle.get(0).add(1);

    List<Integer> prev;
    for (int rowNum = 1; rowNum < numRows; rowNum++) {
      prev = triangle.get(rowNum - 1);
      row = new ArrayList<>();

      row.add(1);
      for (int index = 1; index < rowNum; index++) {
        row.add(prev.get(index - 1) + prev.get(index));
      }
      row.add(1);

      triangle.add(row);
    }

    return triangle;
  }

}
