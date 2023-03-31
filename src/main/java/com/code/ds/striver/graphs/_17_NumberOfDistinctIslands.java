package com.code.ds.striver.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) 
 * You may assume all four edges of the grid are surrounded by water.

An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Return the number of distinct islands.

 

Example 1:


Input: grid = [[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]
Output: 1
Example 2:


Input: grid = [[1,1,0,1,1],[1,0,0,0,0],[0,0,0,0,1],[1,1,0,1,1]]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.
 * 
 * @author sukh
 *
 */
public class _17_NumberOfDistinctIslands {

  /**
   * Time: O(m * n) <br>
   * Space: O(m * n)
   * 
   * @param grid
   * @return
   */
  public int numDistinctIslands(int[][] grid) {
    /**
     * Set of Islands == (row, col) from the base (row, col) of the island
     */
    Set<String> islands = new HashSet<>();
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    int[] offset = { 0, 1, 0, -1, 0 };
    StringBuilder sb = new StringBuilder();

    /**
     * For each node '1', check is it leads to a group of '1's forming a distinct
     * island
     */
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (grid[r][c] == 1 && !visited[r][c]) {
          dfs(grid, visited, r, c, sb, offset, r, c);
          islands.add(sb.toString());
          sb.setLength(0);
        }
      }
    }
    return islands.size();
  }

  private void dfs(int[][] grid, boolean[][] visited, int sr, int sc, StringBuilder sb,
      int[] offset, int row, int col) {
    /**
     * sr = base row index
     * 
     * sc = base col index
     */
    int m = grid.length;
    int n = grid[0].length;

    visited[row][col] = true;
    /**
     * ( rowIndex - baseRow, colIndex - baseCol )
     */
    sb.append(row - sr).append(col - sc);

    /**
     * Check for all directions: Right, Down, Left, Up
     */
    for (int i = 0; i < offset.length - 1; i++) {
      int r = row + offset[i];
      int c = col + offset[i + 1];

      if (r >= 0 && r < m && c >= 0 && c < n) {
        if (grid[r][c] == 1 && !visited[r][c]) {
          dfs(grid, visited, sr, sc, sb, offset, r, c);
        }
      }
    }
  }

}
