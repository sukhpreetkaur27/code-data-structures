package com.code.ds.striver.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a weighted, undirected and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.

 

Example 1:

Input:
3 3
0 1 5
1 2 3
0 2 1

Output:
4
Explanation:

The Spanning Tree resulting in a weight
of 4 is shown above.
Example 2:

Input:
2 1
0 1 5

Output:
5
Explanation:
Only one Spanning Tree is possible
which has a weight of 5.
 

Your task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function  spanningTree() which takes number of vertices V 
and an adjacency matrix adj as input parameters and returns an integer denoting the sum of weights of the edges of the Minimum Spanning Tree. 
Here adj[i] contains a list of lists containing two integers where the first integer a[i][0] denotes that there is an edge between i and a[i][0][0] 
and second integer a[i][0][1] denotes that the distance between edge i and a[i][0][0] is a[i][0][1].

In other words , adj[i][j] is of form  { u , wt } . So,this denotes that i th node is connected to u th node with  edge weight equal to wt.

 

Expected Time Complexity: O(ElogV).
Expected Auxiliary Space: O(V2).
 

Constraints:
2 ≤ V ≤ 1000
V-1 ≤ E ≤ (V*(V-1))/2
1 ≤ w ≤ 1000
Graph is connected and doesn't contain self loops & multiple edges.
 * 
 * @author sukh
 *
 */
public class _45_MinimumSpanningTree {

  class Pair {
    int node;
    int weight;

    Pair(int node, int weight) {
      this.node = node;
      this.weight = weight;
    }
  }

  class Tuple {
    int weight;
    int node;
    int parent;

    Tuple(int weight, int node, int parent) {
      this.weight = weight;
      this.node = node;
      this.parent = parent;
    }
  }

  class TupleComparator implements Comparator<Tuple> {
    public int compare(Tuple a, Tuple b) {
      if (a.weight == b.weight) {
        if (a.node == b.node) {
          return a.parent - b.parent;
        }
        return a.node - b.node;
      }
      return a.weight - b.weight;
    }
  }

  /**
   * Time: O(E log V) <br>
   * Time is similar to Dijkstra <br>
   * 
   * Space: O(E + V) <br>
   * O(E) for PQ <br>
   * O(V) for visited array
   * 
   * @param V
   * @param E
   * @param edges
   * @return
   */
  int spanningTree(int V, int E, int edges[][]) {
    /**
     * Prim's Algorithm - Find the MST and its weight
     * 
     * Intuition: Greedy
     * 
     * we start with a source, and since it's an MST, so it must be connected to an
     * adjacent node, so we pick greedily the smallest edge weight
     * 
     * next time if we encounter the same node or adjacent node, we will not pick it
     * as it has already been picked up greedily in the MST
     */
    /**
     * Adjacency List
     */
    List<List<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<Pair>());
    }
    for (int[] edge : edges) {
      adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
      adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
    }
    /**
     * Store the MST edges
     */
    List<List<Integer>> mst = new ArrayList<>();
    /**
     * MST edge weight sum
     */
    int sum = 0;
    /**
     * Mark the nodes as visited
     */
    boolean[] visited = new boolean[V];
    /**
     * Default source node to start with
     */
    final int SOURCE = 0;
    /**
     * Priority Queue
     */
    Queue<Tuple> pq = new PriorityQueue<>(new TupleComparator());
    /**
     * Default Source Node = 0 <br>
     * Source Weight = 0 <br>
     * Source Parent = -1;
     * 
     * Time: O(E log E)
     */
    pq.offer(new Tuple(0, SOURCE, -1));
    while (!pq.isEmpty()) {
      Tuple pop = pq.poll();
      /**
       * If node is unvisited
       */
      if (!visited[pop.node]) {
        visited[pop.node] = true;
        /**
         * MST Edge Weight
         */
        sum += pop.weight;
        /**
         * MST Edge : (parent, node)
         */
        List<Integer> edge = new ArrayList<>();
        edge.add(pop.parent);
        edge.add(pop.node);
        mst.add(edge);
        /**
         * Look for adjacent nodes
         * 
         * Time: E log E
         */
        for (Pair pair : adj.get(pop.node)) {
          /**
           * if node is unvisited --> add to queue
           */
          if (!visited[pair.node]) {
            pq.offer(new Tuple(pair.weight, pair.node, pop.node));
          }
        }
      }
    }
    return sum;
  }

}
