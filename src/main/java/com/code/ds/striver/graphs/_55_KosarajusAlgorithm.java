package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, Find the number of strongly connected components in the graph.
 

Example 1:

Input:

Output:
3
Explanation:

We can clearly see that there are 3 Strongly
Connected Components in the Graph
Example 2:

Input:

Output:
1
Explanation:
All of the nodes are connected to each other.
So, there's only one SCC.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function kosaraju() which takes the number of vertices V 
and adjacency list of the graph as inputs and returns an integer denoting the number of strongly connected components in the given graph.
 

Expected Time Complexity: O(V+E).
Expected Auxiliary Space: O(V).
 

Constraints:
1 ≤ V ≤ 5000
0 ≤ E ≤ (V*(V-1))
0 ≤ u, v ≤ N-1
Sum of E over all testcases will not exceed 25*106
 * 
 * @author sukh
 *
 */
public class _55_KosarajusAlgorithm {

  /**
   * Time: O(V + E) <br>
   * Space: O(V + E)
   * 
   * @param V
   * @param adj
   * @return
   */
  public int kosaraju(int V, List<List<Integer>> adj) {
    /**
     * Kosaraju's Algorithm - Strongly Connected Components (SCC)
     * 
     * SCC - each node is reachable from every other node in a component
     * 
     * 1. works for directed graphs
     * 
     * 2. sort nodes as per the finishing time in order to start from a SCC node and
     * move to the next SCC --> stack
     * 
     * 3. reverse the graph in order to disconnect connected SCCs
     * 
     * 4. pop the stack (start of each SCC) --> perform DFS to find the SCC nodes
     */
    /**
     * Keep track of visited nodes
     */
    boolean[] visited = new boolean[V];
    /**
     * Sort nodes as per the finishing time
     */
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        dfs(adj, i, stack, visited);
      }
    }
    List<List<Integer>> adj1 = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj1.add(new ArrayList<>());
    }
    /**
     * Reverse the graph
     */
    for (int i = 0; i < V; i++) {
      for (Integer j : adj.get(i)) {
        adj1.get(j).add(i);
      }
    }
    int scc = 0;
    Arrays.fill(visited, false);
    /**
     * Perform DFS on each popped node from the sorted stack
     */
    while (!stack.isEmpty()) {
      Integer pop = stack.pop();
      if (!visited[pop]) {
        scc++;
        dfs(adj1, pop, visited);
      }
    }
    return scc;
  }

  private void dfs(List<List<Integer>> adj, int node, boolean[] visited) {
    visited[node] = true;
    for (Integer i : adj.get(node)) {
      if (!visited[i]) {
        dfs(adj, i, visited);
      }
    }
  }

  private void dfs(List<List<Integer>> adj, int node, Deque<Integer> stack,
      boolean[] visited) {
    visited[node] = true;
    for (Integer i : adj.get(node)) {
      if (!visited[i]) {
        dfs(adj, i, stack, visited);
        // stack.push(i);
      }
    }
    stack.push(node);
  }

}
