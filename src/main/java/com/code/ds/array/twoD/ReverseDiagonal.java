package com.code.ds.array.twoD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

 

Example 1:


Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,4,7,5,3,6,8,9]
Example 2:

Input: mat = [[1,2],[3,4]]
Output: [1,2,3,4]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
-105 <= mat[i][j] <= 105
 * @author sukh
 *
 */
public class ReverseDiagonal {

  /**
   * Time: O(n * m)<br>
   * Space: O(min(n,m))
   * @param mat
   * @return
   */
  public int[] reverse(int[][] mat) {
    if (mat == null || mat.length == 0) {
      return new int[0];
    }

    int n = mat.length;
    int m = mat[0].length;
    /**
     * # of Diagonals = n + m - 1
     */
    int diagonals = n + m - 1;

    int[] res = new int[n * m];
    int index = 0;
    int row, col;
    List<Integer> temp = new ArrayList<>();
    for (int diag = 0; diag < diagonals; diag++) {
      temp.clear();
      /**
       * if Diagonal # < # of Columns --> row = First Row (R1)
       */
      row = diag < m ? 0 : diag - m + 1;
      /**
       * if Diagonal # > # of Columns --> col = Last Column (CM)
       */
      col = diag < m ? diag : m - 1;

      while (row < n && col > -1) {
        temp.add(mat[row++][col--]);
      }

      /**
       * For Even Diagonals --> Reverse the order
       */
      if (diag % 2 == 0) {
        Collections.reverse(temp);
      }

      for (int i = 0; i < temp.size(); i++) {
        res[index++] = temp.get(i);
      }
    }

    return res;
  }

}
