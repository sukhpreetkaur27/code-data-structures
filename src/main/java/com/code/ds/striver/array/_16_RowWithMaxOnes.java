package com.code.ds.striver.array;

public class _16_RowWithMaxOnes {

  /**
   * Time: O(n+m)<br>
   * Space: O(1)
   * @param matrix
   * @return
   */
  public int findRow(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    int row = -1;
    /**
     * Start from top right corner
     */
    int r = 0, c = m - 1;
    while (r < n && c >= 0) {
      if (matrix[r][c] == 1) {
        /**
         * Move Left
         */
        c--;
        row = r;
      } else {
        /**
         * Move Down
         */
        r++;
      }
    }
    return row;
  }

}
