package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 * 
 * @author sukh
 *
 */
public class _8_NumberOfIslands {

  class Pair {
    int r;
    int c;

    Pair(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  /**
   * Time: O(m * n) <br>
   * Space: O(m * n)
   * 
   * @param grid
   * @return
   */
  public int numIslands(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];

    int islands = 0;

    /**
     * Right, Down, Left, Up
     */
    int[] offsets = { 0, 1, 0, -1, 0 };

    Deque<Pair> queue = new ArrayDeque<>();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        /**
         * If grid[i][j] == land and is not visited yet
         * 
         * grid[i][j] == starting point
         */
        if (grid[i][j] == '1' && !visited[i][j]) {
          visited[i][j] = true;
          islands++;
          queue.offer(new Pair(i, j));
          bfs(queue, visited, offsets, grid);
        }
      }
    }
    return islands;
  }

  /**
   * Time: O(m * n)
   */
  private void bfs(Deque<Pair> queue, boolean[][] visited, int[] offsets, char[][] grid) {
    /**
     * BFS from a starting point in all 4 directions (Right, Down, Left, Up)
     */
    int m = grid.length;
    int n = grid[0].length;

    while (!queue.isEmpty()) {
      Pair pop = queue.poll();
      int pop_r = pop.r;
      int pop_c = pop.c;

      for (int k = 0; k < offsets.length - 1; k++) {
        int row = pop_r + offsets[k];
        int col = pop_c + offsets[k + 1];

        if (row >= 0 && row < m && col >= 0 && col < n) {
          if (grid[row][col] == '1' && !visited[row][col]) {
            visited[row][col] = true;
            queue.offer(new Pair(row, col));
          }
        }
      }
    }
    queue.clear();
  }

}
