package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
 * 
 * @author sukh
 *
 */
public class _13_01Matrix {

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
        if (mat[r][c] == 0) {
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
