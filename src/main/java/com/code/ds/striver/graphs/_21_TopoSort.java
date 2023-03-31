package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.


Example 1:

Input:

Output:
1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible Topological order for the
graph is 3, 2, 1, 0.
Example 2:

Input:

Output:
1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible Topological order for the
graph is 5, 4, 2, 1, 3, 0.

Your Task:
You don't need to read input or print anything. Your task is to complete the function topoSort()  which takes the integer V denoting the number of vertices 
and adjacency list as input parameters and returns an array consisting of a the vertices in Topological order. As there are multiple Topological orders possible, 
you may return any of them. If your returned topo sort is correct then console output will be 1 else 0.


Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).


Constraints:
2 ≤ V ≤ 104
1 ≤ E ≤ (N*(N-1))/2
 * 
 * @author sukh
 *
 */
public class _21_TopoSort {

  /**
   * Time: O(V + E) <br>
   * Space: O(V)
   * 
   * @param V
   * @param adj
   * @return
   */
  public int[] topoSort(int V, List<List<Integer>> adj) {
    /**
     * Topological Sort:
     * 
     * Linear ordering of vertices such that if there is an edge between u and v, u
     * always appears before v in the sort order.
     * 
     * Exists only for DAG ( Directed Acyclic Graph )
     */
    Deque<Integer> stack = new ArrayDeque<>();
    boolean[] visited = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        dfs(i, adj, visited, stack);
      }
    }
    int[] sort = new int[stack.size()];
    int i = 0;
    while (!stack.isEmpty()) {
      sort[i++] = stack.pop();
    }
    return sort;
  }

  private void dfs(int node, List<List<Integer>> adj, boolean[] visited,
      Deque<Integer> stack) {
    visited[node] = true;

    for (Integer i : adj.get(node)) {
      if (i != null && !visited[i]) {
        dfs(i, adj, visited, stack);
      }
    }
    /**
     * Push the node in the stack at last after visiting all the adjacent nodes
     * depth-wise
     * 
     * such that the top = the node from which the directed edge starts
     */
    stack.push(node);
  }

}
