package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.Deque;
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
public class _23_DetectCycleDirectedGraph_KahnsAlgo {

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
     * Topological Sort:
     * 
     * Linear ordering of vertices such that if there is an edge between u and v, u
     * always appears before v in the sort order.
     * 
     * Exists only for DAG ( Directed Acyclic Graph )
     */
    /**
     * Kahn's Topo Sort Algorithm: BFS
     * 
     * 1. Push nodes with in-degree 0 to queue
     * 
     * 2. Pop nodes from queue and decrement the in-degree of adjacent nodes by 1
     * 
     * 2.a. Pushing (or Popping) of nodes is in the sort order as their in-degree= 0
     * 
     * 3. Push nodes with in-degree 0 to queue
     */
    /**
     * Since, Kahn's Algo (or) Topo Sort Algo is valid only for DAGs
     * 
     * Hence, if topo sort size != vertices count
     * 
     * then, it's cyclic
     * 
     * else, DAG
     */
    Deque<Integer> queue = new ArrayDeque<>();
    int[] inDegrees = new int[V];
    /**
     * Find in degree of all the nodes
     */
    for (int i = 0; i < V; i++) {
      for (int node : adj.get(i)) {
        inDegrees[node]++;
      }
    }

    /**
     * Push nodes with in-degree 0 to the queue
     */
    for (int i = 0; i < V; i++) {
      if (inDegrees[i] == 0) {
        queue.offer(i);
      }
    }
    int sortCount = 0;
    while (!queue.isEmpty()) {
      int pop = queue.poll();
      sortCount++;
      /**
       * Decrement in-degree of adjacent nodes by 1
       * 
       * Push nodes with in-degree 0
       */
      for (int node : adj.get(pop)) {
        inDegrees[node]--;
        if (inDegrees[node] == 0) {
          queue.offer(node);
        }
      }
    }
    return sortCount != V;
  }

}
