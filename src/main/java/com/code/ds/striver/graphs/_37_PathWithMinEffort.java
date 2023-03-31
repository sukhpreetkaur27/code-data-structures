package com.code.ds.striver.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D
 * array of size rows x columns, where heights[row][col] represents the height
 * of cell (row, col). You are situated in the top-left cell, (0, 0), and you
 * hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e.,
 * 0-indexed). You can move up, down, left, or right, and you wish to find a
 * route that requires the minimum effort.
 * 
 * A route's effort is the maximum absolute difference in heights between two
 * consecutive cells of the route.
 * 
 * Return the minimum effort required to travel from the top-left cell to the
 * bottom-right cell.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: heights = [[1,2,2],[3,8,2],[5,3,5]] Output: 2 Explanation: The route
 * of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
 * This is better than the route of [1,2,2,2,5], where the maximum absolute
 * difference is 3. Example 2:
 * 
 * 
 * 
 * Input: heights = [[1,2,3],[3,8,4],[5,3,5]] Output: 1 Explanation: The route
 * of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells,
 * which is better than route [1,3,5,3,5]. Example 3:
 * 
 * 
 * Input: heights =
 * [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]] Output: 0
 * Explanation: This route does not require any effort.
 * 
 * 
 * Constraints:
 * 
 * rows == heights.length columns == heights[i].length 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 * 
 * @author sukh
 *
 */
public class _37_PathWithMinEffort {

  class Tuple {
    int row;
    int col;
    /**
     * Effort = Max of absolute difference of successive heights in a path
     */
    int effort;

    Tuple(int row, int col, int effort) {
      this.row = row;
      this.col = col;
      this.effort = effort;
    }
  }

  class TupleComparator implements Comparator<Tuple> {
    public int compare(Tuple a, Tuple b) {
      if (a.effort == b.effort) {
        if (a.row == b.row) {
          return a.col - b.col;
        }
        return a.row - b.row;
      }
      return a.effort - b.effort;
    }
  }

  /**
   * Time: <br>
   * Dijkstra Time: O(E log V) <br>
   * Here, E = n * m * 4 (as each node can move into 4 directions --> so 4 edges
   * per node) <br>
   * V = n * m
   * 
   * Space: O(n * m)
   * 
   * @param heights
   * @return
   */
  public int minimumEffortPath(int[][] heights) {
    int rows = heights.length;
    int cols = heights[0].length;
    int[] source = { 0, 0 };
    int[] destination = { rows - 1, cols - 1 };

    int[][] efforts = new int[rows][cols];
    for (int[] i : efforts) {
      Arrays.fill(i, Integer.MAX_VALUE);
    }
    efforts[source[0]][source[1]] = 0;

    int[] offset = { 0, 1, 0, -1, 0 };

    Queue<Tuple> pq = new PriorityQueue<>(new TupleComparator());
    pq.offer(new Tuple(source[0], source[1], 0));
    while (!pq.isEmpty()) {
      Tuple pop = pq.poll();

      /**
       * PQ is a min heap
       * 
       * so if we pop the destination, it means that we have reached the destination
       * with the minimum possible effort
       * 
       * we don't exit while insertion of destination node --> as there could be other
       * paths with min effort to it
       */
      if (pop.row == destination[0] && pop.col == destination[1]) {
        return pop.effort;
      }

      for (int i = 0; i < offset.length - 1; i++) {
        int row = pop.row + offset[i];
        int col = pop.col + offset[i + 1];

        if (row >= 0 && row < rows && col >= 0 && col < cols) {
          /**
           * Current effort = Math.abs(heights[pop.row][pop.col] - heights[row][col])
           * 
           * Actual Effort = Math.max(Current effort, pop.effort)
           */
          int effort = Math.max(Math.abs(heights[pop.row][pop.col] - heights[row][col]),
              pop.effort);
          /**
           * if Actual Effort < efforts[row][col]
           * 
           * consider it as it could lead to the min effort to destination
           */
          if (efforts[row][col] > effort) {
            efforts[row][col] = effort;
            pq.offer(new Tuple(row, col, effort));
          }
        }
      }

    }
    return 0;
  }

}
