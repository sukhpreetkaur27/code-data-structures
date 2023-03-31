package com.code.ds.striver.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given a weighted undirected graph having n+1 vertices numbered from 0 to n and m edges describing there are edges between a to b with some weight, 
 * find the shortest path between the vertex 1 and the vertex n and if path does not exist then return a list consisting of only -1.

Example:
Input:
n = 5, m= 6
edges = [[1,2,2], [2,5,5], [2,3,4], [1,4,1],[4,3,3],[3,5,1]]
Output:
1 4 3 5
Explaination:
Shortest path from 1 to n is by the path 1 4 3 5

Your Task:
You don't need to read input or print anything. Your task is to complete the function shortestPath() which takes n vertex and m edges and vector of edges having weight as inputs
 and returns the shortest path between vertex 1 to n.

Expected Time Complexity: O(m* log(n))
Expected Space Complexity: O(n)

Constraint:
2 <= n <= 105
0 <= m <= 105
0<= a, b <= n
1 <= w <= 105
 * 
 * @author sukh
 *
 */
public class _35_ShortestPath_UndirectedGraph_Dijkstra {

  class Pair {
    int node;
    int distance;

    Pair(int node, int distance) {
      this.node = node;
      this.distance = distance;
    }
  }

  /**
   * Comparator
   * 
   * compares for distance
   * 
   * if distance is equal, compare for node values
   * 
   * @author sukh
   *
   */
  class PairComparator implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
      if (a.distance == b.distance) {
        return a.node - b.node;
      }
      return a.distance - b.distance;
    }
  }

  /**
   * Time: O(E log E) for Dijkstra + O(V + E) <br>
   * 
   * there can be more than one instance of a node in the priority queue as a
   * result the size of the priority queue can be E --> hence, the log E (to
   * insert + delete)
   * 
   * Space: O(E log E) for Dijkstra + O(V + E)
   * 
   * @param n
   * @param m
   * @param edges
   * @return
   */
  public List<Integer> dijkstra(int n, int edges[][]) {
    /**
     * Dijkstra's Algorithm - Priority Queue (Min Heap)
     * 
     * 1. To find the shortest path from source to a node
     * 
     * 2. Doesn't works for negative weights as it results in an infinite cycle
     */
    /**
     * 1-base indexing
     */
    int source = 1;
    int destination = n;

    /**
     * Prepare weighted adjacency list
     */
    List<List<Pair>> adj = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] i : edges) {
      adj.get(i[0]).add(new Pair(i[1], i[2]));
      adj.get(i[1]).add(new Pair(i[0], i[2]));
    }

    int[] distance = new int[n + 1];
    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[source] = 0;

    /**
     * Memoization
     * 
     * Remember the last parent per node (for the shortest path)
     * 
     * Set default parent as the node itself
     */
    int[] parent = new int[n + 1];
    for (int i = 0; i < n + 1; i++) {
      parent[i] = i;
    }

    PriorityQueue<Pair> pqueue = new PriorityQueue<>(new PairComparator());
    pqueue.offer(new Pair(source, 0));

    /**
     * Time: O(E log E)
     */
    while (!pqueue.isEmpty()) {
      Pair pop = pqueue.poll();

      /**
       * Time: O(log E)
       */
      for (Pair pair : adj.get(pop.node)) {
        int p_node = pair.node;
        int dist = pop.distance + pair.distance;
        if (dist < distance[p_node]) {
          parent[p_node] = pop.node;
          distance[p_node] = dist;
          pqueue.offer(new Pair(p_node, dist));
        }
      }
    }
    List<Integer> list = new ArrayList<>();
    /**
     * if destination unreachable from source
     */
    if (distance[destination] == Integer.MAX_VALUE) {
      list.add(-1);
      return list;
    }
    /**
     * Prepare the shortest path by backtracking from the parent of the destination
     * 
     * NOTE:
     * 
     * parent[source] = source
     * 
     * this serves as the exit point
     */
    int node = n;
    while (parent[node] != node) {
      list.add(node);
      node = parent[node];
    }
    list.add(source);
    Collections.reverse(list);
    return list;
  }

}
