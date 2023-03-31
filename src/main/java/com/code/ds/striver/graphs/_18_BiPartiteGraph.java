package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, 
 * where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. 
 * The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.

 

Example 1:


Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
Example 2:


Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
 

Constraints:

graph.length == n
1 <= n <= 100
0 <= graph[u].length < n
0 <= graph[u][i] <= n - 1
graph[u] does not contain u.
All the values of graph[u] are unique.
If graph[u] contains v, then graph[v] contains u.

 * @author sukh
 *
 */
public class _18_BiPartiteGraph {

  /**
   * Time: O(V + E) <br>
   * Space: O(V)
   * 
   * @param graph
   * @return
   */
  public boolean isBipartite_bfs(int[][] graph) {
    /**
     * BiPartite Graph = Color the graph with 2 colors such that no adjacent nodes
     * have the same color
     * 
     * Here, colors to be filled = (0, 1)
     * 
     * Unfilled Color = -1
     */
    int n = graph.length;

    int[] color = new int[n];
    Arrays.fill(color, -1);

    /**
     * For multi-component graphs, check for all uncolored nodes
     */
    for (int i = 0; i < n; i++) {
      if (color[i] == -1) {
        if (!bfs(i, color, graph)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean bfs(int node, int[] color, int[][] graph) {
    Deque<Integer> queue = new ArrayDeque<>();
    queue.offer(node);
    color[node] = 0;
    while (!queue.isEmpty()) {
      Integer pop = queue.poll();
      /**
       * Check for adjacent nodes
       */
      for (int i : graph[pop]) {
        if (color[i] == -1) {
          queue.offer(i);
          /**
           * if pop node = color 0 --> adjacent node = 1 - 0 = 1
           * 
           * if pop node = color 1 --> adjacent node = 1 - 1 = 0
           * 
           * Hence, filling opposite colors
           */
          color[i] = 1 - color[pop];
        } else if (color[i] == color[pop]) {
          /**
           * if adjacent nodes have same color, return false
           */
          return false;
        }
      }
    }
    return true;
  }
  
  /**
   * Time: O(V + E) <br>
   * Space: O(V)
   * 
   * @param graph
   * @return
   */
  public boolean isBipartite_dfs(int[][] graph) {
    int n = graph.length;

    int[] color = new int[n];
    Arrays.fill(color, -1);

    /**
     * For multi-component graphs, check for all uncolored nodes
     */
    for (int i = 0; i < n; i++) {
      if (color[i] == -1) {
        color[i] = 0;
        if (!dfs(i, color, graph)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean dfs(int node, int[] color, int[][] graph) {
    /**
     * Check for adjacent nodes
     */
    for (int i : graph[node]) {
      if (color[i] == -1) {
        /**
         * if parent node = color 0 --> adjacent node = 1 - 0 = 1
         * 
         * if parent node = color 1 --> adjacent node = 1 - 1 = 0
         * 
         * Hence, filling opposite colors
         */
        color[i] = 1 - color[node];
        if (!dfs(i, color, graph)) {
          /**
           * if DFS fails, return false
           */
          return false;
        }
      } else if (color[i] == color[node]) {
        /**
         * if adjacent nodes have same color, return false
         */
        return false;
      }
    }
    return true;
  }

}
