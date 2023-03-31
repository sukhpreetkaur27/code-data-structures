package com.code.ds.hashtable.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * An n x n matrix is valid if every row and every column contains all the integers from 1 to n (inclusive).

Given an n x n integer matrix matrix, return true if the matrix is valid. Otherwise, return false.

 

Example 1:


Input: matrix = [[1,2,3],[3,1,2],[2,3,1]]
Output: true
Explanation: In this case, n = 3, and every row and column contains the numbers 1, 2, and 3.
Hence, we return true.
Example 2:


Input: matrix = [[1,1,1],[1,2,3],[1,2,3]]
Output: false
Explanation: In this case, n = 3, but the first row and the first column do not contain the numbers 2 or 3.
Hence, we return false.
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
1 <= matrix[i][j] <= n
 * @author sukh
 *
 */
public class ValidRowCol_2133 {

  /**
   * Time: O(n^2)<br>
   * Space: O(n^2)
   * @param matrix
   * @return
   */
  public boolean checkValid(int[][] matrix) {
    int n = matrix.length;

    Set<Integer>[] rows = new Set[n];
    Set<Integer>[] cols = new Set[n];

    for (int i = 0; i < n; i++) {
      rows[i] = new HashSet<>();
      cols[i] = new HashSet<>();
    }

    int val;
    for (int r = 0; r < n; r++) {
      for (int c = 0; c < n; c++) {
        val = matrix[r][c];

        if (rows[r].contains(val)) {
          return false;
        }
        rows[r].add(val);

        if (cols[c].contains(val)) {
          return false;
        }
        cols[c].add(val);
      }
    }

    return true;
  }

}
