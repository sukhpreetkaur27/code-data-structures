package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary grid of n*m. Find the distance of the nearest 1 in the grid for each cell.
The distance is calculated as |i1  - i2| + |j1 - j2|, where i1, j1 are the row number and column number of the current cell, and i2, j2 
are the row number and column number of the nearest cell having value 1.
 

Example 1:

Input: grid = {{0,1,1,0},{1,1,0,0},{0,0,1,1}}
Output: {{1,0,0,1},{0,0,1,1},{1,1,0,0}}
Explanation: The grid is-
0 1 1 0 
1 1 0 0 
0 0 1 1 
0's at (0,0), (0,3), (1,2), (1,3), (2,0) and
(2,1) are at a distance of 1 from 1's at (0,1),
(0,2), (0,2), (2,3), (1,0) and (1,1)
respectively.


Example 2:

Input: grid = {{1,0,1},{1,1,0},{1,0,0}}
Output: {{0,1,0},{0,0,1},{0,1,2}}
Explanation: The grid is-
1 0 1
1 1 0
1 0 0
0's at (0,1), (1,2), (2,1) and (2,2) are at a 
distance of 1, 1, 1 and 2 from 1's at (0,0),
(0,2), (2,0) and (1,1) respectively.


 

Yout Task:
You don't need to read or print anything, Your task is to complete the function nearest() which takes the grid as an input parameter 
and returns a matrix of the same dimensions where the value at index (i, j) in the resultant matrix signifies the minimum distance of 1 in the matrix from grid[i][j].
 

Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)

Constraints:
1 ≤ n, m ≤ 500


 * 
 * @author sukh
 *
 */
public class _14_NearestOne {

  class Pair {
    int r;
    int c;
    int dist;

    Pair(int r, int c, int dist) {
      this.r = r;
      this.c = c;
      this.dist = dist;
    }
  }

  /**
   * Time: O(m * n) <br>
   * Space: O(m * n)
   * 
   * @param mat
   * @return
   */
  public int[][] updateMatrix(int[][] mat) {
    /**
     * Nearest Distance == BFS
     */
    int m = mat.length;
    int n = mat[0].length;
    int[][] res = new int[m][n];
    int[] offset = { 0, 1, 0, -1, 0 };
    boolean[][] visited = new boolean[m][n];
    Deque<Pair> queue = new ArrayDeque<>();
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        /**
         * Start with 0's
         * 
         * Distance = 0
         */
        if (mat[r][c] == 1) {
          queue.offer(new Pair(r, c, 0));
          visited[r][c] = true;
        }
      }
    }

    bfs(queue, res, offset, mat, visited);
    return res;
  }

  private void bfs(Deque<Pair> queue, int[][] res, int[] offset, int[][] mat,
      boolean[][] visited) {
    int m = mat.length;
    int n = mat[0].length;

    while (!queue.isEmpty()) {
      Pair pop = queue.poll();

      /**
       * Move in 4 directions
       */
      for (int i = 0; i < offset.length - 1; i++) {
        int row = pop.r + offset[i];
        int col = pop.c + offset[i + 1];
        if (row >= 0 && row < m && col >= 0 && col < n) {
          if (!visited[row][col]) {
            /**
             * if not visited, increment distance by 1
             * 
             * push to the queue
             */
            res[row][col] = pop.dist + 1;
            queue.offer(new Pair(row, col, pop.dist + 1));
            visited[row][col] = true;
          }
        }
      }
    }
  }

}
