package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * You are given an Undirected Graph having unit weight, Find the shortest path from src(0) to all the vertex and if it is unreachable to reach any vertex, 
 * then return -1 for that vertex.

Example:

Input:
n = 9, m= 10
edges=[[0,1],[0,3],[3,4],[4 ,5]
,[5, 6],[1,2],[2,6],[6,7],[7,8],[6,8]] 
src=0
Output:
0 1 2 1 2 3 3 4 4
Your Task:

You don't need to print or input anything. Complete the function shortest path() which takes a 2d vector or array edges representing the edges of undirected graph with unit weight, 
an integer N as number nodes, an integer M as number of edges and an integer src as the input parameters and returns an integer array or vector, 
denoting the vector of distance from src to all nodes.

Constraint:
1<=n,m<=100
1<=adj[i][j]<=100

Expected Time Complexity: O(N + E), where N is the number of nodes and E is edges
Expected Space Complexity: O(N)
 * 
 * @author sukh
 *
 */
public class _29_ShortestPath_UndirectedGraph {

  /**
   * Time: O(V + E) <br>
   * Space: O(V)
   * 
   * @param edges
   * @param n
   * @param m
   * @param src
   * @return
   */
  public int[] shortestPath(int[][] edges, int n, int m, int src) {
    /**
     * Shortest Path Undirected Graph = BFS
     * 
     * Why ?
     * 
     * Because if we start from the source level wise with each edge of unit size,
     * it is automatically sorted in increasing order
     */
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] i : edges) {
      adj.get(i[0]).add(i[1]);
      adj.get(i[1]).add(i[0]);
    }

    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    Deque<Integer> queue = new ArrayDeque<>();
    queue.offer(src);

    while (!queue.isEmpty()) {
      int top = queue.poll();
      for (int i : adj.get(top)) {
        int d = dist[top] + 1;
        if (dist[i] > d) {
          dist[i] = d;
          queue.offer(i);
        }
      }
    }

    for (int i = 0; i < n; i++) {
      if (dist[i] == Integer.MAX_VALUE) {
        dist[i] = -1;
      }
    }
    return dist;
  }

}
