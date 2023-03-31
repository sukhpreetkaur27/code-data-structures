package com.code.ds.striver.array;

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 * 
 * @author sukh
 *
 */
public class _30_SetMatrixZeroes {

  /**
   * Time: O(nm)<br>
   * Space: O(1)
   * @param matrix
   */
  public void setZeroes(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;

    boolean col0 = false;

    for (int r = 0; r < n; r++) {
      if (matrix[r][0] == 0) {
        col0 = true;
      }
      for (int c = 1; c < m; c++) {
        if (matrix[r][c] == 0) {
          matrix[0][c] = matrix[r][0] = 0;
        }
      }
    }

    for (int r = n - 1; r >= 0; r--) {
      for (int c = m - 1; c >= 1; c--) {
        if (matrix[r][0] == 0 || matrix[0][c] == 0) {
          matrix[r][c] = 0;
        }
      }
      if (col0) {
        matrix[r][0] = 0;
      }
    }
  }

}
