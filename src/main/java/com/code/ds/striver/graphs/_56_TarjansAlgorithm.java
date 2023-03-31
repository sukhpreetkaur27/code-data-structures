package com.code.ds.striver.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network 
 * where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:


Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
Example 2:

Input: n = 2, connections = [[0,1]]
Output: [[0,1]]
 

Constraints:

2 <= n <= 105
n - 1 <= connections.length <= 105
0 <= ai, bi <= n - 1
ai != bi
There are no repeated connections.
 * 
 * @author sukh
 *
 */
public class _56_TarjansAlgorithm {

  /**
   * stores the step count
   */
  private int timer = 1;

  /**
   * Time: O(V+E) <br>
   * Space: O(V+E)
   * 
   * @param n
   * @param connections
   * @return
   */
  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    /**
     * Tarjan's Algorithm
     * 
     * DFS Traversal --> keep track of time of insertion and low time of insertion
     * 
     * time of insertion = step at which we reach a node during DFS
     * 
     * low time of insertion = minimum lowest time of insertion of all adjacent
     * nodes apart from parent
     * 
     * This implies the lowest step via which we could reach the parent from the
     * node
     * 
     * To check for a bridge, if insertionTime[parent] < lowInsertionTime[child] -->
     * Bridge Found
     * 
     * On backtracking, check for: <br>
     * a. low time of insertion for the node <br>
     * b. check for bridge
     */
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }
    /**
     * Adjacency List
     */
    for (List<Integer> i : connections) {
      adj.get(i.get(0)).add(i.get(1));
      adj.get(i.get(1)).add(i.get(0));
    }
    int[] insertionTime = new int[n];
    int[] lowInsertionTime = new int[n];
    boolean[] visited = new boolean[n];
    List<List<Integer>> bridges = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(adj, visited, 0, -1, insertionTime, lowInsertionTime, bridges);
      }
    }
    return bridges;
  }

  /**
   * Time: O(V+E)
   */
  private void dfs(List<List<Integer>> adj, boolean[] visited, int node, int parent,
      int[] insertionTime, int[] lowInsertionTime, List<List<Integer>> bridges) {
    visited[node] = true;
    /**
     * Initialization of insertion time and low insertion time to step #
     */
    insertionTime[node] = lowInsertionTime[node] = timer;
    timer++;
    for (int i : adj.get(node)) {
      /**
       * if adjacent node == parent --> skip
       */
      if (i == parent) {
        continue;
      }
      /**
       * if adjacent node is unvisited --> DFS --> check for low insertion time -->
       * check for bridge
       */
      if (!visited[i]) {
        dfs(adj, visited, i, node, insertionTime, lowInsertionTime, bridges);
        lowInsertionTime[node] = Math.min(lowInsertionTime[node], lowInsertionTime[i]);
        if (insertionTime[node] < lowInsertionTime[i]) {
          bridges.add(Arrays.asList(node, i));
        }
      } else {
        /**
         * if visited --> check for low insertion time only as we have already traversed
         * the path via adjacent node to reach the current node --> hence, no bridge
         * possible at all
         */
        lowInsertionTime[node] = Math.min(lowInsertionTime[node], lowInsertionTime[i]);
      }
    }
  }

}
