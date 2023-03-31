package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

 

Example 1:


Input: grid = [[0,1],[1,0]]
Output: 2
Example 2:


Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
Example 3:

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1
 * 
 * @author sukh
 *
 */
public class _36_ShortestPath_BinaryMatrix {

  class Tuple {
    int row;
    int col;
    int distance;

    Tuple(int row, int col, int distance) {
      this.row = row;
      this.col = col;
      this.distance = distance;
    }
  }

  /**
   * Time: O(n^2) == O(E) <br>
   * Space: O(E)
   * 
   * @param grid
   * @return
   */
  public int shortestPathBinaryMatrix(int[][] grid) {
    /**
     * Dijkstra's Algorithm - Queue
     */
    int n = grid.length;

    int[] source = { 0, 0 };
    int[] destination = { n - 1, n - 1 };

    /**
     * Edge Case:
     * 
     * if source and destination cannot be visited ever due to '1'
     */
    if (grid[source[0]][source[1]] == 1 || grid[destination[0]][destination[1]] == 1) {
      return -1;
    }
    /**
     * Edge Case:
     * 
     * If only 1 (source) node --> source == destination
     */
    if (n == 1) {
      return 1;
    }

    int[][] distance = new int[n][n];
    for (int[] i : distance) {
      Arrays.fill(i, Integer.MAX_VALUE);
    }

    /**
     * We don't use Priority Queue. Why?
     * 
     * If we observe the pattern of the queue, it's always in sorted order (based on
     * distance) due to the distance being unit weighted.
     * 
     * Hence, we can avoid the extra O(log n) for maintaining a Priority Queue
     */
    Deque<Tuple> queue = new ArrayDeque<>();
    queue.offer(new Tuple(source[0], source[1], 0));
    distance[source[0]][source[1]] = 0;

    while (!queue.isEmpty()) {
      Tuple pop = queue.poll();

      /**
       * Move in 8 directions
       * 
       * row values = -1, 0, +1
       * 
       * col values = -1, 0, +1
       */
      for (int delta_row = -1; delta_row <= 1; delta_row++) {
        int row = pop.row + delta_row;
        if (row >= 0 && row < n) {
          for (int delta_col = -1; delta_col <= 1; delta_col++) {
            int col = pop.col + delta_col;
            /**
             * if node can be visited
             */
            if (col >= 0 && col < n && grid[row][col] == 0) {
              int dist = pop.distance + 1;
              if (distance[row][col] > dist) {
                queue.offer(new Tuple(row, col, dist));
                distance[row][col] = dist;
                /**
                 * if destination reached
                 */
                if (row == destination[0] && col == destination[1]) {
                  /**
                   * the source node is considered as step 1 --> hence "+1"
                   */
                  return dist + 1;
                }
              }
            }
          }
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    _36_ShortestPath_BinaryMatrix obj = new _36_ShortestPath_BinaryMatrix();
    int[][] grid = { { 0, 1 }, { 1, 0 } };
    System.out.println(obj.shortestPathBinaryMatrix(grid));
  }

}
