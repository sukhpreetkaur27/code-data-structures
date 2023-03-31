package com.code.ds.striver.graphs;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).

The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if 
and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, 
you must stay within the boundaries of the grid during your swim.

Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).

 

Example 1:


Input: grid = [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
Example 2:


Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation: The final route is shown.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 50
0 <= grid[i][j] < n2
Each value grid[i][j] is unique.
 * 
 * @author sukh
 *
 */
public class _54_SwimInRisingWater {

  class Tuple {
    int row;
    int col;
    int height;

    Tuple(int row, int col, int height) {
      this.row = row;
      this.col = col;
      this.height = height;
    }
  }

  class TupleComparator implements Comparator<Tuple> {
    public int compare(Tuple a, Tuple b) {
      return a.height - b.height;
    }
  }

  /**
   * Time: O(n^2 log (n^2)) == O(n^2 * 2 * log n) == O(n^2 log n) <br>
   * at max we push all the nodes into the PQ <br>
   * Space: O(n^2)
   * 
   * @param grid
   * @return
   */
  public int swimInWater(int[][] grid) {
    /**
     * Dijkstra's Algorithm - Priority Queue
     * 
     * start from (0,0)
     * 
     * consider the maximum height in a shortest path to be the least time
     */
    int maxTime = 0;
    int rows = grid.length;
    int columns = grid[0].length;
    int target_row = rows - 1;
    int target_col = columns - 1;
    /**
     * Move in all 4 directions
     */
    int[] offset = { 0, 1, 0, -1, 0 };
    /**
     * keep track of visited nodes before pushing into the queue
     */
    boolean[][] visited = new boolean[rows][columns];
    /**
     * priority = minimum height
     * 
     * each time we pop the minimum height in order to form the shortest path
     */
    Queue<Tuple> pq = new PriorityQueue<>(new TupleComparator());
    pq.offer(new Tuple(0, 0, grid[0][0]));
    while (!pq.isEmpty()) {
      Tuple pop = pq.poll();
      /**
       * consider the maximum height in a shortest path to be the least time
       */
      maxTime = Math.max(maxTime, pop.height);
      /**
       * if the popped node i.e. the current minimum height is of the target node
       * 
       * break
       */
      if (pop.row == target_row && pop.col == target_col) {
        break;
      }
      /**
       * Move in all 4 directions
       */
      for (int i = 0, row = 0, col = 0; i < offset.length - 1; i++) {
        row = pop.row + offset[i];
        col = pop.col + offset[i + 1];
        if (row >= 0 && row < rows && col >= 0 && col < columns) {
          /**
           * if node is unvisited --> add it to the queue
           */
          if (!visited[row][col]) {
            visited[row][col] = true;
            pq.offer(new Tuple(row, col, grid[row][col]));
          }
        }
      }
    }
    return maxTime;
  }

}
