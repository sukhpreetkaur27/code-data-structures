package com.code.ds.striver.graphs;

/**
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

 

Example 1:


Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Notice that an 'O' should not be flipped if:
- It is on the border, or
- It is adjacent to an 'O' that should not be flipped.
The bottom 'O' is on the border, so it is not flipped.
The other three 'O' form a surrounded region, so they are flipped.
Example 2:

Input: board = [["X"]]
Output: [["X"]]
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
 * 
 * @author sukh
 *
 */
public class _15_ReplaceOsWithXs {

  /**
   * Time: O(m * n) <br>
   * Space: O(m * n)
   * 
   * @param board
   */
  public void solve(char[][] board) {
    int m = board.length;
    int n = board[0].length;

    boolean[][] visited = new boolean[m][n];
    int[] offset = { 0, 1, 0, -1, 0 };

    /**
     * DFS == Mark nodes connected to 'O' boundary as visited
     * 
     * Other O's are replaced with 'X'
     */
    /**
     * Check for top and bottom boundaries
     */
    for (int c = 0; c < n; c++) {
      /**
       * First Row
       */
      if (board[0][c] == 'O' && !visited[0][c]) {
        dfs(board, visited, 0, c, offset);
      }
      /**
       * Last Row
       */
      if (board[m - 1][c] == 'O' && !visited[m - 1][c]) {
        dfs(board, visited, m - 1, c, offset);
      }
    }

    /**
     * Check for left and right boundaries
     */
    for (int r = 0; r < m; r++) {
      /**
       * Left Column
       */
      if (board[r][0] == 'O' && !visited[r][0]) {
        dfs(board, visited, r, 0, offset);
      }
      /**
       * Right Column
       */
      if (board[r][n - 1] == 'O' && !visited[r][n - 1]) {
        dfs(board, visited, r, n - 1, offset);
      }
    }

    /**
     * Replace other unvisited 'O' nodes with 'X'
     */
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (board[r][c] == 'O' && !visited[r][c]) {
          board[r][c] = 'X';
          visited[r][c] = true;
        }
      }
    }
  }

  /**
   * DFS Traversal in all the 4 directions for 'O' boundary connected nodes
   */
  private void dfs(char[][] board, boolean[][] visited, int row, int col, int[] offset) {
    int m = board.length;
    int n = board[0].length;

    visited[row][col] = true;

    for (int k = 0; k < offset.length - 1; k++) {
      int r = row + offset[k];
      int c = col + offset[k + 1];
      if (r >= 0 && r < m && c >= 0 && c < n) {
        if (board[r][c] == 'O' && !visited[r][c]) {
          dfs(board, visited, r, c, offset);
        }
      }
    }
  }

}
