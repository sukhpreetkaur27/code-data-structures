package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
Note: One can move from node u to node v only if there's an edge from u to v and find the BFS traversal of the graph starting from the 0th vertex, 
from left to right according to the graph. Also, you should only take nodes directly or indirectly connected from Node 0 in consideration.


Example 1:

Input:

Output: 0 1 2 3 4
Explanation: 
0 is connected to 1 , 2 , 3.
2 is connected to 4.
so starting from 0, it will go to 1 then 2
then 3.After this 2 to 4, thus bfs will be
0 1 2 3 4.
Example 2:

Input:

Output: 0 1 2
Explanation:
0 is connected to 1 , 2.
so starting from 0, it will go to 1 then 2,
thus bfs will be 0 1 2. 

Your task:
You dont need to read input or print anything. Your task is to complete the function bfsOfGraph() which takes the integer V denoting the number of vertices 
and adjacency list as input parameters and returns  a list containing the BFS traversal of the graph starting from the 0th vertex from left to right.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ V, E ≤ 104
 * 
 * @author sukh
 *
 */
public class _5_BFS {

  /**
   * Time: O(V + E) <br>
   * Space: O(V)
   * 
   * @param V the number of vertices
   * @param adj adjacency list
   * @return
   */
  public List<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    /**
     * Level Order Traversal
     * 
     * Level = Distance from the starting node
     */
    List<Integer> bfs = new ArrayList<Integer>();

    /**
     * Visited Nodes
     * 
     * if 1-based indexing --> size = V + 1
     */
    boolean[] visited = new boolean[V];

    Deque<Integer> queue = new ArrayDeque<>();
    /**
     * Start from 0
     */
    queue.offer(0);
    visited[0] = true;

    /**
     * Outer while loop run for V times
     */
    while (!queue.isEmpty()) {
      Integer pop = queue.poll();
      bfs.add(pop);
      /**
       * For each V, the inner for loop runs for 2 times in case of un-directed graph
       * and once for directed graph
       * 
       * as Degree of a Graph = 2 * # of Edges
       */
      /**
       * Check for edges from the adjacency list
       */
      for (Integer v : adj.get(pop)) {
        /**
         * If node not visited, add it to queue
         */
        if (!visited[v]) {
          queue.offer(v);
          visited[v] = true;
        }
      }
    }

    return bfs;
  }

}
