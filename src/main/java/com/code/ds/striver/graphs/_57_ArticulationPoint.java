package com.code.ds.striver.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an undirected connected graph with V vertices and adjacency list adj. You are required to find all the vertices removing which (and edges through it) 
 * disconnects the graph into 2 or more components.
Note: Indexing is zero-based i.e nodes numbering from (0 to V-1). There might be loops present in the graph.

Example 1:

Input:

Output:{1,4}
Explanation: Removing the vertex 1 will
discconect the graph as-

Removing the vertex 4 will disconnect the
graph as-

 

Your Task:
You don't need to read or print anything. Your task is to complete the function articulationPoints() which takes V and adj as input parameters 
and returns a list containing all the vertices removing which turn the graph into two or more disconnected components in sorted order.
 If there are no such vertices then returns a list containing -1.
 

Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)
 

Constraints:
1 ≤ V ≤ 10
 * 
 * @author sukh
 *
 */
public class _57_ArticulationPoint {

  /**
   * stores the step count
   */
  private int timer = 1;

  /**
   * Time: O(V+E) <br>
   * Space: O(V)
   * @param n
   * @param adj
   * @return
   */
  public List<Integer> articulationPoints(int n, List<List<Integer>> adj) {
    /**
     * Articulation Point Algorithm
     * 
     * DFS Traversal --> keep track of time of insertion and low time of insertion
     * 
     * time of insertion = step at which we reach a node during DFS
     * 
     * low time of insertion = minimum lowest time of insertion of all adjacent
     * nodes apart from parent and visited nodes <br>
     * for visited nodes, consider the insertion time for comparison
     * 
     * This implies the lowest step via which we could reach the parent from the
     * node
     * 
     * To check for a AP, if insertionTime[parent] <= lowInsertionTime[child] --> AP
     * Found
     * 
     * On backtracking, check for: <br>
     * a. low time of insertion for the node <br>
     * b. check for AP
     * 
     * For starting point, check for child (unvisited) count > 1 --> hence AP
     */
    int[] insertionTime = new int[n];
    int[] lowInsertionTime = new int[n];
    boolean[] visited = new boolean[n];
    /**
     * hashing to avoid duplicate APs
     * 
     * using ordered hashing with O(1) time
     */
    boolean[] aps = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(adj, visited, 0, -1, insertionTime, lowInsertionTime, aps);
      }
    }
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (aps[i]) {
        list.add(i);
      }
    }
    /**
     * if no AP exists --> return -1
     */
    if (list.isEmpty()) {
      list.add(-1);
    }
    return list;
  }

  private void dfs(List<List<Integer>> adj, boolean[] visited, int node, int parent,
      int[] insertionTime, int[] lowInsertionTime, boolean[] aps) {
    visited[node] = true;
    /**
     * Initialization of insertion time and low insertion time to step #
     */
    insertionTime[node] = lowInsertionTime[node] = timer;
    timer++;
    /**
     * unvisited adjacent nodes are considered children, as they weren't reachable
     * via other nodes
     * 
     * required for starting point (i.e. parent = -1)
     */
    int child = 0;
    for (int i : adj.get(node)) {
      /**
       * if adjacent node == parent --> skip
       */
      if (i == parent) {
        continue;
      }
      /**
       * if adjacent node is unvisited --> DFS --> check for low insertion time -->
       * check for AP
       */
      if (!visited[i]) {
        dfs(adj, visited, i, node, insertionTime, lowInsertionTime, aps);
        lowInsertionTime[node] = Math.min(lowInsertionTime[node], lowInsertionTime[i]);
        /**
         * if low insertion time of adjacent node >= insertion time of node --> node is
         * an AP
         * 
         * as we cannot reach any node before the current node
         */
        if (insertionTime[node] <= lowInsertionTime[i] && parent != -1) {
          aps[node] = true;
        }
        child++;
      } else {
        /**
         * if visited --> check for low insertion time only as we have already traversed
         * the path via adjacent node to reach the current node --> hence, compare
         * insertion time of adjacent node with low insertion time of current node as
         * the adjacent node might become an AP; therefore there is no way in which we
         * can reach a node before it, so no point of considering its low insertion time
         */
        lowInsertionTime[node] = Math.min(lowInsertionTime[node], insertionTime[i]);
      }
    }
    /**
     * for starting point, if it has more than 1 child --> then it can be an AP;
     * else not
     */
    if (parent == -1 && child > 1) {
      aps[node] = true;
    }
  }

}
