package com.code.ds.striver.graphs;

import java.util.List;
import java.util.Arrays;

/**
 * Given a weighted, directed and connected graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S.
Note: If the Graph contains a negative cycle then return an array consisting of only -1.

Example 1:

Input:

E = [[0,1,9]]
S = 0
Output:
0 9
Explanation:
Shortest distance of all nodes from
source is printed.
Example 2:

Input:

E = [[0,1,5],[1,0,3],[1,2,-1],[2,0,1]]
S = 2
Output:
1 6 0
Explanation:
For nodes 2 to 0, we can follow the path-
2-0. This has a distance of 1.
For nodes 2 to 1, we cam follow the path-
2-0-1, which has a distance of 1+5 = 6,
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function bellman_ford( ) which takes a number of vertices V 
and an E-sized list of lists of three integers where the three integers are u,v, and w; denoting there's an edge from u to v, which has a weight of w 
and source node S as input parameters and returns a list of integers where the ith integer denotes the distance of an ith node from the source node.

If some node isn't possible to visit, then its distance should be 100000000(1e8). Also, If the Graph contains a negative cycle then return an array consisting of only -1.

 

Expected Time Complexity: O(V*E).
Expected Auxiliary Space: O(V).

 

Constraints:
1 ≤ V ≤ 500
1 ≤ E ≤ V*(V-1)
-1000 ≤ adj[i][j] ≤ 1000
0 ≤ S < V
 * 
 * @author sukh
 *
 */
public class _42_BellmanFordAlgorithm {

  /**
   * Time: O(V * E) <br>
   * Space: O(V)
   * 
   * @param V
   * @param edges
   * @param S
   * @return
   */
  int[] bellman_ford(int V, List<List<Integer>> edges, int S) {
    /**
     * Bellman Ford Algorithm - Shortest Distance from Source to Node
     * 
     * Works for Directed Graphs
     * 
     * Works for negative weights
     * 
     * Detects negative weight cycle
     */
    final int MAX = (int) 1e8;

    int[] distances = new int[V];
    Arrays.fill(distances, MAX);
    distances[S] = 0;

    /**
     * Iterate n-1 times to Relax the edges
     */
    for (int i = 1; i < V; i++) {
      for (List<Integer> edge : edges) {
        int u = edge.get(0);
        int v = edge.get(1);
        int wt = edge.get(2);

        /**
         * Relaxing the Edges
         */
        if (distances[u] != MAX && distances[u] + wt < distances[v]) {
          distances[v] = distances[u] + wt;
        }
      }
    }
    /**
     * if n-th iteration finds a shortest distance --> it means a negative weight
     * cycle is found
     */
    for (List<Integer> edge : edges) {
      int u = edge.get(0);
      int v = edge.get(1);
      int wt = edge.get(2);

      if (distances[u] != MAX && distances[u] + wt < distances[v]) {
        return new int[] { -1 };
      }
    }
    return distances;
  }

}
