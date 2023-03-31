package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. Graph is in the form of adjacency list 
 * where adj[i] contains all the nodes ith node is having edge with.

Example 1:

Input:  
V = 5, E = 5
adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}} 
Output: 1
Explanation: 

1->2->3->4->1 is a cycle.
Example 2:

Input: 
V = 4, E = 2
adj = {{}, {2}, {1, 3}, {2}}
Output: 0
Explanation: 

No cycle in the graph.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function isCycle() which takes V denoting the number of vertices 
and adjacency list as input parameters and returns a boolean value denoting if the undirected graph contains any cycle or not, return 1 if a cycle is present else return 0.

NOTE: The adjacency list denotes the edges of the graph where edges[i] stores all other vertices to which ith vertex is connected.

 

Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V)


 

Constraints:
1 ≤ V, E ≤ 105

 * @author sukh
 *
 */
public class _12_DetectCycle_UnDirectedGraph {

  class Pair {
    int node;
    int parent;

    Pair(int node, int parent) {
      this.node = node;
      this.parent = parent;
    }
  }

  /**
   * Time: O(V + 2E) <br>
   * for each node, we visit all its adjacent nodes == degree == 2E
   * 
   * Space: O(V)
   * 
   * @param V
   * @param adj
   * @return
   */
  public boolean isCycle_BFS(int V, List<List<Integer>> adj) {
    /**
     * BFS Algorithm
     */
    boolean[] visited = new boolean[V];
    /**
     * NOTE:
     * 
     * A graph can have multiple components
     * 
     * hence, check for all nodes as source
     */
    for (int i = 0; i < V; i++) {
      if (!visited[i] && bfs(adj, visited, i)) {
        return true;
      }
    }
    return false;
  }

  private boolean bfs(List<List<Integer>> adj, boolean[] visited, int src) {
    Deque<Pair> queue = new ArrayDeque<>();
    queue.offer(new Pair(src, -1));
    visited[src] = true;
    while (!queue.isEmpty()) {
      Pair pop = queue.poll();

      for (int node : adj.get(pop.node)) {
        if (!visited[node]) {
          visited[node] = true;
          queue.offer(new Pair(node, pop.node));
        } else if (pop.parent != node) {
          /**
           * if neighbor node is visited and it isn't the parent of the popped (current)
           * node
           * 
           * it means that it came from some other source and they are converging at this
           * node
           * 
           * hence, a cycle has been detected
           */
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Time: O(V + 2E) <br>
   * for each node, we visit all its adjacent nodes == degree == 2E
   * 
   * Space: O(V)
   * 
   * @param V
   * @param adj
   * @return
   */
  public boolean isCycle_DFS(int V, List<List<Integer>> adj) {
    /**
     * DFS ALgorithm
     */
    boolean[] visited = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        if (dfs(adj, visited, new Pair(i, -1))) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean dfs(List<List<Integer>> adj, boolean[] visited, Pair src) {
    visited[src.node] = true;
    for (int node : adj.get(src.node)) {
      if (!visited[node]) {
        /**
         * Traverse recursively
         */
        if (dfs(adj, visited, new Pair(node, src.node))) {
          return true;
        }
      } else if (src.parent != node) {
        return true;
      }
    }

    return false;
  }

}
