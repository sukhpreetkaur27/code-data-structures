package com.code.ds.array.twoD;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 * @author sukh
 *
 */
public class SpiralMatrix {

  /**
   * Time: O(n * m)<br>
   * Space: O(1)
   * @param matrix
   * @return
   */
  public List<Integer> spiral(int[][] matrix) {
    List<Integer> result = new ArrayList<>();

    int rows = matrix.length;
    int cols = matrix[0].length;

    /**
     * Define Boundaries
     */
    int up = 0;
    int right = cols - 1;
    int down = rows - 1;
    int left = 0;

    while (result.size() < rows * cols) {
      /**
       * Traverse L -> R
       */
      for (int col = left; col <= right; col++) {
        result.add(matrix[up][col]);
      }

      /**
       * Traverse U -> D
       */
      for (int row = up + 1; row <= down; row++) {
        result.add(matrix[row][right]);
      }

      /**
       * Check you are not traversing the already visited UP boundary
       */
      if (up != down) {
        /**
         * Traverse R -> L
         */
        for (int col = right - 1; col >= left; col--) {
          result.add(matrix[down][col]);
        }
      }

      /**
       * Check you are not traversing the already visited RIGHT boundary
       */
      if (left != right) {
        for (int row = down - 1; row > up; row--) {
          result.add(matrix[row][left]);
        }
      }

      up++;
      right--;
      down--;
      left++;
    }

    return result;
  }

}
