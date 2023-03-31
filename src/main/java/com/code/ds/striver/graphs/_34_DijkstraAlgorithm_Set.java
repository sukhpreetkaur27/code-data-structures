package com.code.ds.striver.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given a weighted, undirected and connected graph of V vertices and an adjacency list adj where adj[i] is a list of lists containing two integers 
 * where the first integer of each list j denotes there is edge between i and j , second integers corresponds to the weight of that  edge . 
 * You are given the source vertex S and You to Find the shortest distance of all the vertex's from the source vertex S. You have to return a list of integers 
 * denoting shortest distance between each node and Source vertex S.
 

Note: The Graph doesn't contain any negative weight cycle.

 

Example 1:

Input:
V = 2
adj [] = {{{1, 9}}, {{0, 9}}}
S = 0
Output:
0 9
Explanation:

The source vertex is 0. Hence, the shortest 
distance of node 0 is 0 and the shortest 
distance from node 1 is 9.
 

Example 2:

Input:
V = 3, E = 3
adj = {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}}
S = 2
Output:
4 3 0
Explanation:

For nodes 2 to 0, we can follow the path-
2-1-0. This has a distance of 1+3 = 4,
whereas the path 2-0 has a distance of 6. So,
the Shortest path from 2 to 0 is 4.
The shortest distance from 0 to 1 is 1 .
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function dijkstra()  which takes the number of vertices V 
and an adjacency list adj as input parameters and Source vertex S returns a list of integers, where ith integer denotes the shortest distance of the ith node from the Source node. 
Here adj[i] contains a list of lists containing two integers where the first integer j denotes that there is an edge between i and j 
and the second integer w denotes that the weight between edge i and j is w.

 

Expected Time Complexity: O(V2).
Expected Auxiliary Space: O(V2).

 

Constraints:
1 ≤ V ≤ 1000
0 ≤ adj[i][j] ≤ 1000
1 ≤ adj.size() ≤ [ (V*(V - 1)) / 2 ]
0 ≤ S < V
 * 
 * @author sukh
 *
 */
public class _34_DijkstraAlgorithm_Set {

  /**
   * Time: O(E log V) <br>
   * 
   * there can be one instance of a node in the tree set as a result the size of
   * the tree set can be V → Hence, the log V (to insert + delete)
   * 
   * Space: O(V)
   * 
   * @param V
   * @param adj
   * @param S
   * @return
   */
  public int[] dijkstra(int V, List<List<List<Integer>>> adj, int S) {
    /**
     * Dijkstra's Algorithm - Tree Set
     * 
     * 1. To find the shortest path from source to a node
     * 
     * Why Tree Set ? <br>
     * Saves unnecessary iterations as in case of PQ due to uniqueness property
     * (node)
     * 
     * Drawback <br>
     * O(log n) time to erase and O(log n) time to insert (if required) for the same
     * node to maintain the uniqueness property
     * 
     * We cannot say PQ is better than Set for Dijkstra’s Algo <br>
     * explanation: the above as it solely depends on the input data
     * 
     * 2. Doesn't works for negative weights as it results in an infinite cycle
     */
    int[] distance = new int[V];
    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[S] = 0;

    Set<Pair> set = new TreeSet<>(new PairComparator());
    set.add(new Pair(S, 0));

    /**
     * Time: O(E log V)
     */
    while (!set.isEmpty()) {
      Pair pop = set.iterator().next();
      set.remove(pop);

      /**
       * Time: O(log V)
       */
      for (List<Integer> j : adj.get(pop.node)) {
        int dist = pop.distance + j.get(1);
        if (dist < distance[j.get(0)]) {
          Pair pair = new Pair(j.get(0), distance[j.get(0)]);
          /**
           * Extra check for removal from set
           */
          if (set.contains(pair)) {
            set.remove(pair);
          }
          distance[j.get(0)] = dist;
          set.add(new Pair(j.get(0), dist));
        }
      }
    }
    return distance;
  }

  public static void main(String[] args) {
    _33_DijkstraAlgorithm_PQ obj = new _33_DijkstraAlgorithm_PQ();
    int v = 2;
    List<List<List<Integer>>> adj = new ArrayList<>();
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> nodes = new ArrayList<>();
    nodes.add(1);
    nodes.add(9);
    list.add(nodes);
    adj.add(list);
    List<List<Integer>> list1 = new ArrayList<>();
    List<Integer> nodes1 = new ArrayList<>();
    nodes1.add(0);
    nodes1.add(9);
    list1.add(nodes1);
    adj.add(list1);
    System.out.println(Arrays.toString(obj.dijkstra(v, adj, 0)));
  }

}

class Pair {
  int node;
  int distance;

  Pair(int node, int distance) {
    this.node = node;
    this.distance = distance;
  }

  @Override
  public int hashCode() {
    return Objects.hash(distance, node);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Pair other = (Pair) obj;
    return distance == other.distance && node == other.node;
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
