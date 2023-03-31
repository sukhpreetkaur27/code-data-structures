package com.code.ds.striver.array;

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
 * 
 * @author sukh
 *
 */
public class _32_SpiralMatrix {

  public List<Integer> spiral(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;

    int left = 0;
    int right = m - 1;
    int up = 0;
    int down = n - 1;

    List<Integer> spiral = new ArrayList<>();
    while (spiral.size() < n * m) {
      for (int col = left; col <= right; col++) {
        spiral.add(matrix[up][col]);
      }

      for (int row = up + 1; row <= down; row++) {
        spiral.add(matrix[row][right]);
      }

      if (up != down) {
        for (int col = right - 1; col >= left; col--) {
          spiral.add(matrix[down][col]);
        }
      }

      if (left != right) {
        for (int row = down - 1; row > up; row--) {
          spiral.add(matrix[row][left]);
        }
      }

      up++;
      down--;
      left++;
      right--;
    }
    return spiral;
  }

}
