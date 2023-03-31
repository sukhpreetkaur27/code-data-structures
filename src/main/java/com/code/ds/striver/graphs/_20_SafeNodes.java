package com.code.ds.striver.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph 
 * where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

 

Example 1:

Illustration of graph
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Explanation: The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
Example 2:

Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
Output: [4]
Explanation:
Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
 

Constraints:

n == graph.length
1 <= n <= 104
0 <= graph[i].length <= n
0 <= graph[i][j] <= n - 1
graph[i] is sorted in a strictly increasing order.
The graph may contain self-loops.
The number of edges in the graph will be in the range [1, 4 * 104].
 * 
 * @author sukh
 *
 */
public class _20_SafeNodes {

  /**
   * Time: O(V + E) <br>
   * Space: O(V)
   * 
   * @param graph
   * @return
   */
  public List<Integer> eventualSafeNodes(int[][] graph) {
    /**
     * Terminal Nodes = Out-Degree 0
     * 
     * A node is a safe node if every possible path starting from that node leads to
     * a terminal node (or another safe node).
     * 
     * Detect Cycle in a Directed Graph
     * 
     * Nodes part of the cycle (or) nodes leading to the cycle --> Don't form part
     * of the safe nodes
     * 
     */
    int n = graph.length;
    Set<Integer> safeNodes = new TreeSet<>();
    boolean[] visited = new boolean[n];
    boolean[] pathVisited = new boolean[n];

    /**
     * For multi-component graphs, check for all uncolored nodes
     */
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        if (dfs(graph, visited, pathVisited, i, safeNodes)) {
          safeNodes.add(i);
        }
      }
    }
    return new ArrayList<>(safeNodes);
  }

  private boolean dfs(int[][] graph, boolean[] visited, boolean[] pathVisited, int node,
      Set<Integer> safeNodes) {
    visited[node] = true;
    pathVisited[node] = true;
    for (int i : graph[node]) {
      if (!visited[i]) {
        /**
         * If not visited
         */
        if (!dfs(graph, visited, pathVisited, i, safeNodes)) {
          return false;
        } else {
          /**
           * If DFS leads to terminal node
           * 
           * Mark it as a Safe Node
           */
          safeNodes.add(i);
        }
      } else if (pathVisited[i]) {
        /**
         * If visited and path visited
         */
        return false;
      } else if (!safeNodes.contains(i)) {
        /**
         * If visited but not path visited
         * 
         * check if it's a safe node
         * 
         * if yes, then current node is also a safe node
         */
        return false;
      }
    }
    /**
     * Unmark the path visited node
     */
    pathVisited[node] = false;
    return true;
  }

}
