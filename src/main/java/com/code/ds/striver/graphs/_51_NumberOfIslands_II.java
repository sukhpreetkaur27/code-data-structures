package com.code.ds.striver.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an empty 2D binary grid grid of size m x n. The grid represents a map where 0's represent water and 1's represent land. 
 * Initially, all the cells of grid are water cells (i.e., all the cells are 0's).

We may perform an add land operation which turns the water at position into a land. You are given an array positions 
where positions[i] = [ri, ci] is the position (ri, ci) at which we should operate the ith operation.

Return an array of integers answer where answer[i] is the number of islands after turning the cell (ri, ci) into a land.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

 

Example 1:


Input: m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]
Output: [1,1,2,3]
Explanation:
Initially, the 2d grid is filled with water.
- Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land. We have 1 island.
- Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land. We still have 1 island.
- Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land. We have 2 islands.
- Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land. We have 3 islands.
Example 2:

Input: m = 1, n = 1, positions = [[0,0]]
Output: [1]
 

Constraints:

1 <= m, n, positions.length <= 104
1 <= m * n <= 104
positions[i].length == 2
0 <= ri < m
0 <= ci < n
 

Follow up: Could you solve it in time complexity O(k log(mn)), where k == positions.length?
 * 
 * @author sukh
 *
 */
public class _51_NumberOfIslands_II {

  /**
   * Time: O(L * 4 * 4 * alpha + m * n) == O(L + m * n) <br> 
   * Space: O(m * n)
   * 
   * @param m
   * @param n
   * @param positions
   * @return
   */
  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    /**
     * DSU --> Dynamic Graph
     */
    List<Integer> islands = new ArrayList<>();
    /**
     * Move in 4 directions: Right, Down, Left, Up
     */
    int[] offsets = { 0, 1, 0, -1, 0 };
    /**
     * Marking nodes as visited
     * 
     * total m * n nodes --> 0-based indexing
     * 
     * Initially all nodes are water == unvisited
     */
    boolean[] visited = new boolean[m * n];
    /**
     * Consider each node(position) as a component
     * 
     * Time: O(m * n)
     */
    _0_DisjointSet_UnionFind dsu = new _0_DisjointSet_UnionFind(m * n);
    int count = 0;
    for (int[] i : positions) {
      int row = i[0];
      int col = i[1];
      /**
       * node position = row * # of columns + column
       */
      int node = row * n + col;
      /**
       * if node already visited --> count remains the same --> continue
       */
      if (visited[node]) {
        islands.add(count);
        continue;
      }
      /**
       * Mark node as visited == land
       * 
       * increment the counter
       */
      visited[node] = true;
      count++;
      /**
       * Move in 4 directions
       */
      for (int j = 0; j < offsets.length - 1; j++) {
        int adj_row = row + offsets[j];
        int adj_col = col + offsets[j + 1];
        if (adj_row >= 0 && adj_row < m && adj_col >= 0 && adj_col < n) {
          int adj_node = adj_row * n + adj_col;
          /**
           * if adjacent node is visited == land
           * 
           * check for their ultimate parents (find) (initially ultimate parents == the
           * node itself) --> if not equal, decrement the counter and merge (union)
           */
          if (visited[adj_node]) {
            if (dsu.find(node) != dsu.find(adj_node)) {
              count--;
              dsu.unionBySize(node, adj_node);
            }
          }
        }
      }
      /**
       * add the count of islands for the current dynamics
       */
      islands.add(count);
    }
    return islands;
  }

  public static void main(String[] args) {
    _51_NumberOfIslands_II obj = new _51_NumberOfIslands_II();
    int m = 3, n = 3;
    int[][] positions = { { 0, 0 }, { 0, 1 }, { 1, 2 }, { 2, 1 } };
    System.out.println(obj.numIslands2(m, n, positions).toString());
  }

}
