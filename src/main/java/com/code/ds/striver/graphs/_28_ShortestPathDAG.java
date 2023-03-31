package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer array(or vector) edges[ ][ ] of length M, 
 * where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i, 0<=i

Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.

 

Example:

Input:
n = 6, m= 7
edge=[[0,1,2],[0,4,1],[4,5,4]
,[4,2,2],[1,2,3],[2,3,6],[5,3,1]]

Output:
0 2 3 6 1 5
 

Your Task:

You don't need to print or input anything. Complete the function shortest path() which takes an integer N as number of vertices, 
an integer M as number of edges and a 2D Integer array(or vector) edges as the input parameters and returns an integer array(or vector), 
denoting the list of distance from src to all nodes.

 

Constraint:

1 <= n,m <= 100
0 <= edgei,0,edgei,1 < n
 
 

Expected Time Complexity: O(N+E), where N is the number of nodes and E is edges

Expected Space Complexity: O(N)
 * 
 * @author sukh
 *
 */
public class _28_ShortestPathDAG {

  class Pair {
    int n;
    int w;

    Pair(int n, int w) {
      this.n = n;
      this.w = w;
    }
  }

  /**
   * Time: O(V + E) <br>
   * Space: O(V + E)
   * 
   * @param N
   * @param M
   * @param edges
   * @param source
   * @return
   */
  public int[] shortestPath(int N, int M, int[][] edges, int source) {
    /**
     * Algorithm:
     * 
     * 1. Topo Sort (DFS or BFS) (DFS is simple) == Stack output
     * 
     * 2. Relax the edges, i.e.,
     * 
     * Pop the stack
     * 
     * check dist[top] + adjacent_node.weight < dist[adjacent_node] <br>
     * dist[adjacent_node] = dist[top] + adjacent_node.weight
     * 
     * 
     * dist[] = shortest distance from source
     * 
     */
    /**
     * NOTE: Why Topo Sort ?
     * 
     * Finding the shortest path to a vertex is easy if you already know the
     * shortest paths to all the vertices that can precede it.
     * 
     * Finding the longest path to a vertex is easy if you already know the longest
     * paths to all the vertices that can precede it.
     * 
     * Topo Sort for DAGs
     * 
     * Dijkstra's Algorithm for graphs that can contain cycle because they can't be
     * topologically sorted
     */
    List<List<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      adj.add(new ArrayList<>());
    }
    /**
     * Adjacency List
     */
    for (int[] i : edges) {
      adj.get(i[0]).add(new Pair(i[1], i[2]));
    }
    Deque<Integer> sort = new ArrayDeque<>();
    boolean[] visited = new boolean[N];
    /**
     * Topo Sort
     */
    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        dfs(visited, sort, i, adj);
      }
    }

    int[] dist = new int[N];
    /**
     * Default distance = Infinity
     */
    Arrays.fill(dist, Integer.MAX_VALUE);
    /**
     * distance from source to source = 0
     */
    dist[source] = 0;
    while (!sort.isEmpty()) {
      Integer top = sort.pop();
      /**
       * Check for shortest distance
       */
//      if (dist[top] != Integer.MAX_VALUE) {
        for (Pair i : adj.get(top)) {
          if (dist[top] + i.w < dist[i.n]) {
            dist[i.n] = dist[top] + i.w;
          }
        }
//      }
    }

    for (int i = 0; i < N; i++) {
      /**
       * for invalid paths from source to a node
       * 
       * mark distance as -1
       */
      if (dist[i] == Integer.MAX_VALUE) {
        dist[i] = -1;
      }
    }
    return dist;
  }

  /**
   * Topo Sort
   */
  private void dfs(boolean[] visited, Deque<Integer> stack, int node,
      List<List<Pair>> adj) {
    visited[node] = true;
    for (Pair i : adj.get(node)) {
      if (!visited[i.n]) {
        dfs(visited, stack, i.n, adj);
      }
    }
    stack.push(node);
  }

}
