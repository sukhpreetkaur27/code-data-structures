package com.code.ds.striver.array;

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
 * 
 * @author sukh
 *
 */
public class _33_PascalsTriangle {

  /**
   * Time: O(n^2)<br>
   * Space: O(1)
   * @param n
   * @return
   */
  public List<List<Integer>> pascal(int n) {
    List<List<Integer>> pascal = new ArrayList<>();

    List<Integer> row = new ArrayList<>();
    row.add(1);
    pascal.add(row);

    for (int r = 1; r < n; r++) {
      row = new ArrayList<Integer>();
      row.add(1);

      List<Integer> prev = pascal.get(r - 1);
      for (int i = 1; i < prev.size(); i++) {
        int val = prev.get(i - 1) + prev.get(i);
        row.add(val);
      }

      row.add(1);
      pascal.add(row);
    }

    return pascal;
  }

}
