package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of '0's (Water) and '1's(Land). Find the number of islands.

Note: An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

Example 1:

Input:
grid = {{0,1},{1,0},{1,1},{1,0}}
Output:
1
Explanation:
The grid is-
0 1
1 0
1 1
1 0
All lands are connected.
Example 2:

Input:
grid = {{0,1,1,1,0,0,0},{0,0,1,1,0,1,0}}
Output:
2
Expanation:
The grid is-
0 1 1 1 0 0 0
0 0 1 1 0 1 0 
There are two islands :- one is colored in blue 
and other in orange.
Your Task:
You don't need to read or print anything. Your task is to complete the function numIslands() which takes the grid as an input parameter and returns the total number of islands.

Expected Time Complexity: O(n*m)
Expected Space Complexity: O(n*m)

Constraints:
1 ≤ n, m ≤ 500
 * 
 * @author sukh
 *
 */
public class _9_NumberOfIslands_GfG {

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
          bfs(queue, visited, grid);
        }
      }
    }
    return islands;
  }

  /**
   * Time: O(m * n)
   */
  private void bfs(Deque<Pair> queue, boolean[][] visited, char[][] grid) {
    /**
     * BFS from a starting point in all 8 directions (Right, Diagonal, Down, Diagonal,
     * Left, Diagonal, Up, Diagonal)
     */
    int m = grid.length;
    int n = grid[0].length;

    while (!queue.isEmpty()) {
      Pair pop = queue.poll();
      int pop_r = pop.r;
      int pop_c = pop.c;

      /**
       * Move in 8 directions
       * 
       * row values = -1, 0, +1
       * 
       * col values = -1, 0, +1
       */
      for (int delta_row = -1; delta_row <= 1; delta_row++) {
        int row = pop_r + delta_row;
        if (row >= 0 && row < m) {
          for (int delta_col = -1; delta_col <= 1; delta_col++) {
            int col = pop_c + delta_col;
            if (col >= 0 && col < n) {
              if (grid[row][col] == '1' && !visited[row][col]) {
                visited[row][col] = true;
                queue.offer(new Pair(row, col));
              }
            }
          }
        }
      }

    }
    queue.clear();
  }

}
