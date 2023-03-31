package com.code.ds.striver.graphs;

import java.util.List;

/**
 * Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.


Example 1:

Input:



Output: 1
Explanation: 3 -> 3 is a cycle

Example 2:

Input:


Output: 0
Explanation: no cycle in the graph

Your task:
You dont need to read input or print anything. Your task is to complete the function isCyclic() which takes the integer V denoting the number of vertices 
and adjacency list as input parameters and returns a boolean value denoting if the given directed graph contains a cycle or not.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ V, E ≤ 105
 * 
 * @author sukh
 *
 */
public class _19_DetectCycle_DirectedGraph {

  /**
   * Time: O(V + E) <br>
   * Space: O(V)
   * 
   * @param V
   * @param adj
   * @return
   */
  public boolean isCyclic(int V, List<List<Integer>> adj) {
    /**
     * Cycle == On the same path, the node has to be visited again
     * 
     */
    boolean[] visited = new boolean[V];
    /**
     * No need of this array
     * 
     * Use int[] visited: <br>
     * 1 == visited <br>
     * 2 == path visited
     */
    boolean[] pathVisited = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        if (dfs(adj, i, visited, pathVisited)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs(List<List<Integer>> adj, int node, boolean[] visited,
      boolean[] pathVisited) {
    visited[node] = true;
    pathVisited[node] = true;
    for (int i : adj.get(node)) {
      if (!visited[i]) {
        if (dfs(adj, i, visited, pathVisited)) {
          return true;
        }
      } else if (pathVisited[i]) {
        /**
         * If Path visited --> Cycle Detected
         */
        return true;
      }
    }
    pathVisited[node] = false;
    return false;
  }

}
