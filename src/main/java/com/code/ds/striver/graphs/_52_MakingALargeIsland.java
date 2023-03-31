package com.code.ds.striver.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

Return the size of the largest island in grid after applying this operation.

An island is a 4-directionally connected group of 1s.

 

Example 1:

Input: grid = [[1,0],[0,1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
Example 2:

Input: grid = [[1,1],[1,0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
Example 3:

Input: grid = [[1,1],[1,1]]
Output: 4
Explanation: Can't change any 0 to 1, only one island with area = 4.
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 500
grid[i][j] is either 0 or 1.
 * 
 * @author sukh
 *
 */
public class _52_MakingALargeIsland {

  public int largestIsland(int[][] grid) {
    /**
     * DSU -- Dynamic Graph with Connected Components
     * 
     * Islands = Connected Components
     * 
     * Changing each 0 to 1 to check for max Island == Dynamic Graph
     */
    int n = grid.length;
    /**
     * Move in 4 directions: Right, Down, Left, Up
     */
    int[] offsets = { 0, 1, 0, -1, 0 };
    _0_DisjointSet_UnionFind dsu = new _0_DisjointSet_UnionFind(n * n);
    /**
     * Create connected components in DSU
     */
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        /**
         * node position = row * # of columns + column
         */
        int node = row * n + col;
        /**
         * if node is a land
         */
        if (grid[row][col] == 1) {
          /**
           * Move in 4 directions
           */
          for (int j = 0; j < offsets.length - 1; j++) {
            int adj_row = row + offsets[j];
            int adj_col = col + offsets[j + 1];
            if (adj_row >= 0 && adj_row < n && adj_col >= 0 && adj_col < n
                && grid[adj_row][adj_col] == 1) {
              int adj_node = adj_row * n + adj_col;
              /**
               * if adjacent node is a land
               * 
               * merge (union)
               */
              dsu.unionBySize(node, adj_node);
            }
          }
        }
      }
    }
    int maxArea = 0;
    int count = 0;
    /**
     * Traverse through all nodes for 0
     */
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        int node = row * n + col;
        /**
         * if node == 0
         */
        if (grid[row][col] == 0) {
          int area = 1;
          /**
           * Edge Case:
           * 
           * for a node with 0, it can have Down and Left connected components, which will
           * result into adding the area twice
           * 
           * therefore, use a set DS to avoid adding duplicate areas
           */
          Set<Integer> parents = new HashSet<>();
          for (int j = 0; j < offsets.length - 1; j++) {
            int adj_row = row + offsets[j];
            int adj_col = col + offsets[j + 1];
            /**
             * if adjacent nodes are 1 --> look for the size of the parent nodes
             */
            if (adj_row >= 0 && adj_row < n && adj_col >= 0 && adj_col < n
                && grid[adj_row][adj_col] == 1) {
              int adj_node = adj_row * n + adj_col;
              int adj_parent = dsu.find(adj_node);
              if (!parents.contains(adj_parent)) {
                parents.add(adj_parent);
                area += dsu.getSize().get(adj_parent);
              }
            }
          }
          maxArea = Math.max(maxArea, area);
        } else {
          /**
           * Edge case:
           * 
           * all nodes are land, no water
           */
          count++;
        }
      }
    }
    /**
     * Edge case:
     * 
     * all nodes are land, no water
     */
    if (count == n * n) {
      return n * n;
    }
    return maxArea;
  }

}
