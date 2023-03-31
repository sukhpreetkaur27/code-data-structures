package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

 

Example 1:


Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
Example 2:


Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 500
grid[i][j] is either 0 or 1.
 * 
 * @author sukh
 *
 */
public class _16_NumberOfEnclaves {

  /**
   * Time: O(m * n) <br>
   * Space: O(m * n)
   * 
   * @param grid
   * @return
   */
  public int numEnclaves_dfs(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    boolean[][] visited = new boolean[m][n];
    int[] offset = { 0, 1, 0, -1, 0 };

    /**
     * DFS == Mark nodes connected to '1' boundary as visited
     * 
     * Other 1's are considered as unvisited
     */
    /**
     * Check for top and bottom boundaries
     */
    for (int c = 0; c < n; c++) {
      /**
       * First Row
       */
      if (grid[0][c] == 1 && !visited[0][c]) {
        dfs(grid, visited, 0, c, offset);
      }
      /**
       * Last Row
       */
      if (grid[m - 1][c] == 1 && !visited[m - 1][c]) {
        dfs(grid, visited, m - 1, c, offset);
      }
    }

    /**
     * Check for left and right boundaries
     */
    for (int r = 0; r < m; r++) {
      /**
       * Left Column
       */
      if (grid[r][0] == 1 && !visited[r][0]) {
        dfs(grid, visited, r, 0, offset);
      }
      /**
       * Right Column
       */
      if (grid[r][n - 1] == 1 && !visited[r][n - 1]) {
        dfs(grid, visited, r, n - 1, offset);
      }
    }
    int count = 0;
    /**
     * Count other unvisited '1' nodes
     */
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (grid[r][c] == 1 && !visited[r][c]) {
          count++;
          visited[r][c] = true;
        }
      }
    }
    return count;
  }

  /**
   * DFS Traversal in all the 4 directions for '1' boundary connected nodes
   */
  private void dfs(int[][] grid, boolean[][] visited, int row, int col, int[] offset) {
    int m = grid.length;
    int n = grid[0].length;

    visited[row][col] = true;

    for (int k = 0; k < offset.length - 1; k++) {
      int r = row + offset[k];
      int c = col + offset[k + 1];
      if (r >= 0 && r < m && c >= 0 && c < n) {
        if (grid[r][c] == 1 && !visited[r][c]) {
          dfs(grid, visited, r, c, offset);
        }
      }
    }
  }
  
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
  public int numEnclaves_bfs(int[][] grid) {
    /**
     * BFS == Mark nodes connected to '1' boundary as visited
     * 
     * Other 1's are considered as unvisited
     */
    int m = grid.length;
    int n = grid[0].length;

    boolean[][] visited = new boolean[m][n];

    Deque<Pair> queue = new ArrayDeque<>();
    for (int c = 0; c < n; c++) {
      /**
       * First Row
       */
      if (grid[0][c] == 1 && !visited[0][c]) {
        visited[0][c] = true;
        queue.offer(new Pair(0, c));
      }
      /**
       * Last Row
       */
      if (grid[m - 1][c] == 1 && !visited[m - 1][c]) {
        visited[m - 1][c] = true;
        queue.offer(new Pair(m - 1, c));
      }
    }

    /**
     * Check for left and right boundaries
     */
    for (int r = 0; r < m; r++) {
      /**
       * Left Column
       */
      if (grid[r][0] == 1 && !visited[r][0]) {
        visited[r][0] = true;
        queue.offer(new Pair(r, 0));
      }
      /**
       * Right Column
       */
      if (grid[r][n - 1] == 1 && !visited[r][n - 1]) {
        visited[r][n - 1] = true;
        queue.offer(new Pair(r, n - 1));
      }
    }

    bfs(grid, visited, queue);

    int count = 0;
    /**
     * Count other unvisited '1' nodes
     */
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (grid[r][c] == 1 && !visited[r][c]) {
          count++;
          visited[r][c] = true;
        }
      }
    }
    return count;
  }

  /**
   * BFS Traversal in all the 4 directions for '1' boundary connected nodes
   */
  private void bfs(int[][] grid, boolean[][] visited, Deque<Pair> queue) {
    int[] offset = { 0, 1, 0, -1, 0 };
    int m = grid.length;
    int n = grid[0].length;

    while (!queue.isEmpty()) {
      Pair pop = queue.poll();
      for (int k = 0; k < offset.length - 1; k++) {
        int r = pop.r + offset[k];
        int c = pop.c + offset[k + 1];
        if (r >= 0 && r < m && c >= 0 && c < n) {
          if (grid[r][c] == 1 && !visited[r][c]) {
            queue.offer(new Pair(r, c));
            visited[r][c] = true;
          }
        }
      }
    }
  }

}
