package com.code.ds.striver.graphs;

/**
 * The problem is to find the shortest distances between every pair of vertices in a given edge-weighted directed graph. 
 * The graph is represented as an adjacency matrix of size n*n. Matrix[i][j] denotes the weight of the edge from i to j. If Matrix[i][j]=-1, 
 * it means there is no edge from i to j.
Do it in-place.

Example 1:

Input: matrix = {{0,25},{-1,0}}

Output: {{0,25},{-1,0}}

Explanation: The shortest distance between
every pair is already given(if it exists).
Example 2:

Input: matrix = {{0,1,43},{1,0,6},{-1,-1,0}}

Output: {{0,1,7},{1,0,6},{-1,-1,0}}

Explanation: We can reach 2 from 0 as 0->1->2
and the cost will be 1+6=7 which is less than 
43.
Your Task:
You don't need to read, return or print anything. Your task is to complete the function shortest_distance() which takes the matrix as input parameter 
and modifies the distances for every pair in-place.

Expected Time Complexity: O(n3)
Expected Space Complexity: O(1)

Constraints:
1 <= n <= 100
-1 <= matrix[ i ][ j ] <= 1000
 * 
 * @author sukh
 *
 */
public class _43_FloydWarshallAlgorithm {

  /**
   * Time: O(n^3) <br>
   * Space: O(1)
   * 
   * @param matrix
   */
  public void shortest_distance(int[][] matrix) {
    /**
     * Floyd Warshall Algorithm
     * 
     * The code is as per the question
     * 
     * The commented code can be considered as the accurate algorithm implementation
     */
    /**
     * NOTE: <br>
     * 
     * if your graph doesn't contain negative weight cycle (or) negative weights,
     * you can use Dijkstra per node to find the shortest distance <br>
     * 
     * Time: O(V * E log V)
     * 
     * Still better than Floyd Warshall Algorithm
     */
    int n = matrix.length;
//    int[][] distances = new int[n][n];
//    for (int[] i : distances) {
//      Arrays.fill(i, Integer.MAX_VALUE);
//    }
//    for (int i = 0; i < n; i++) {
//      /**
//       * Marking the diagonals as unreachable
//       */
//      distances[i][i] = 0;
//    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == -1) {
          matrix[i][j] = Integer.MAX_VALUE;
        }
        /**
         * Marking the diagonals as unreachable
         */
        if (i == j) {
          matrix[i][j] = 0;
        }
      }
    }
    for (int via = 0; via < n; via++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0, dist = 0; j < n; j++) {
          if (matrix[i][via] == Integer.MAX_VALUE
              || matrix[via][j] == Integer.MAX_VALUE) {
            dist = Integer.MAX_VALUE;
          } else {
            dist = matrix[i][via] + matrix[via][j];
          }
          if (dist != Integer.MAX_VALUE && dist < matrix[i][j]) {
            matrix[i][j] = dist;
          }
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        /**
         * For unreachable nodes, reset to -1
         */
        if (matrix[i][j] == Integer.MAX_VALUE) {
          matrix[i][j] = -1;
        }
//        if (matrix[i][i] < 0) {
//          // Negative Weight Cycle Detected
//        }
      }
    }
//    for (int i = 0; i < n; i++) {
//      if (distances[i][i] < 0) {
//        // Negative Weight Cycle Detected
//      }
//    }
  }

}
