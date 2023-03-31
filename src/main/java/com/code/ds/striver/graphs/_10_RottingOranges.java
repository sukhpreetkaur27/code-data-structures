package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
 * 
 * @author sukh
 *
 */
public class _10_RottingOranges {

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
  public int orangesRotting(int[][] grid) {
    int freshOranges = 0;
    Deque<Pair> queue = new ArrayDeque<>();
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 2) {
          /**
           * push the rotten oranges
           * 
           * considering them at the same starting point (simultaneously)
           */
          queue.offer(new Pair(i, j));
          visited[i][j] = true;
        } else if (grid[i][j] == 1) {
          /**
           * count the # of fresh oranges
           */
          freshOranges++;
        }
      }
    }

    /**
     * if no fresh oranges exist
     * 
     * return 0
     */
    if (freshOranges == 0) {
      return 0;
    }

    /**
     * Right, Down, Left, Up
     */
    int[] offset = { 0, 1, 0, -1, 0 };
    int time = -1;
    /**
     * BFS == Level Order Traversal
     * 
     * to find the min time
     */
    while (!queue.isEmpty()) {
      time++;
      int level = queue.size();
      for (int i = 0; i < level; i++) {
        Pair pop = queue.poll();
        /**
         * Traverse in all 4 directions
         */
        for (int k = 0; k < offset.length - 1; k++) {
          int row = pop.r + offset[k];
          int col = pop.c + offset[k + 1];
          if (row >= 0 && row < m && col >= 0 && col < n) {
            if (grid[row][col] == 1 && !visited[row][col]) {
              queue.offer(new Pair(row, col));
              visited[row][col] = true;
              freshOranges--;
            }
          }
        }
      }
    }
    /**
     * if fresh oranges still exist
     * 
     * return -1
     */
    return freshOranges > 0 ? -1 : time;
  }

}
