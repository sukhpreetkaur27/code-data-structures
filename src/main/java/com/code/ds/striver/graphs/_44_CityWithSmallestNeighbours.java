package com.code.ds.striver.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge 
 * between cities fromi and toi, and given the integer distanceThreshold.

Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, If there are multiple such cities, 
return the city with the greatest number.

Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.

 

Example 1:


Input: n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
Output: 3
Explanation: The figure above describes the graph. 
The neighboring cities at a distanceThreshold = 4 for each city are:
City 0 -> [City 1, City 2] 
City 1 -> [City 0, City 2, City 3] 
City 2 -> [City 0, City 1, City 3] 
City 3 -> [City 1, City 2] 
Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we have to return city 3 since it has the greatest number.
Example 2:


Input: n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], distanceThreshold = 2
Output: 0
Explanation: The figure above describes the graph. 
The neighboring cities at a distanceThreshold = 2 for each city are:
City 0 -> [City 1] 
City 1 -> [City 0, City 4] 
City 2 -> [City 3, City 4] 
City 3 -> [City 2, City 4]
City 4 -> [City 1, City 2, City 3] 
The city 0 has 1 neighboring city at a distanceThreshold = 2.
 

Constraints:

2 <= n <= 100
1 <= edges.length <= n * (n - 1) / 2
edges[i].length == 3
0 <= fromi < toi < n
1 <= weighti, distanceThreshold <= 10^4
All pairs (fromi, toi) are distinct.
 * 
 * @author sukh
 *
 */
public class _44_CityWithSmallestNeighbours {

  class Pair {
    int node;
    int distance;

    Pair(int node, int distance) {
      this.node = node;
      this.distance = distance;
    }
  }

  class PairComparator implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
      if (a.distance == b.distance) {
        return a.node - b.node;
      }
      return a.distance - b.distance;
    }
  }

  /**
   * Time: O(n^3 + n^2) <br>
   * Space: O(n^2)
   * 
   * @param n
   * @param edges
   * @param distanceThreshold
   * @return
   */
  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    /**
     * Floyd Warshall
     */
    /**
     * Shortest Distance from a node to other nodes
     */
    int[][] distances = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(distances[i], Integer.MAX_VALUE);
    }
    /**
     * Default distance from a source node to itself = 0
     */
    for (int i = 0; i < n; i++) {
      distances[i][i] = 0;
    }
    /**
     * Picking edge weights
     */
    for (int[] edge : edges) {
      distances[edge[0]][edge[1]] = edge[2];
      distances[edge[1]][edge[0]] = edge[2];
    }

    for (int via = 0; via < n; via++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0, dist = 0; j < n; j++) {
          if (distances[i][via] == Integer.MAX_VALUE
              || distances[via][j] == Integer.MAX_VALUE) {
            continue;
          }
          dist = distances[i][via] + distances[via][j];
          if (dist < distances[i][j]) {
            distances[i][j] = dist;
          }
        }
      }
    }
    int city = -1;
    int min = n;
    int count = 0;
    for (int i = 0; i < n; i++) {
      count = 0;
      for (int j : distances[i]) {
        /**
         * if distance <= threshold
         * 
         * consider the city
         */
        if (j <= distanceThreshold) {
          count++;
        }
      }
      if (count <= min) {
        min = count;
        city = i;
      }
    }
    return city;
  }

  /**
   * Time: O(n * E log n + n^2) <br>
   * Space: O(n^2)
   * 
   * @param n
   * @param edges
   * @param distanceThreshold
   * @return
   */
  public int findTheCity_1(int n, int[][] edges, int distanceThreshold) {
    /**
     * Dijkstra's Algorithm
     */
    /**
     * Adjacency List
     */
    List<List<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<Pair>());
    }
    for (int[] edge : edges) {
      adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
      adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
    }
    /**
     * Shortest Distance from a node to other nodes
     */
    int[][] distances = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(distances[i], Integer.MAX_VALUE);
    }
    /**
     * Default distance from a source node to itself = 0
     */
    for (int i = 0; i < n; i++) {
      distances[i][i] = 0;
    }
    Queue<Pair> pq = new PriorityQueue<>(new PairComparator());
    /**
     * Perform Dijkstra on all the nodes as source
     */
    for (int source = 0; source < n; source++) {
      pq.clear();
      pq.offer(new Pair(source, 0));
      while (!pq.isEmpty()) {
        Pair pop = pq.poll();
        for (Pair pair : adj.get(pop.node)) {
          int dist = pop.distance + pair.distance;
          if (dist < distances[source][pair.node]) {
            distances[source][pair.node] = dist;
            pq.offer(new Pair(pair.node, dist));
          }
        }
      }
    }
    int city = -1;
    int min = n;
    int count = 0;
    for (int i = 0; i < n; i++) {
      count = 0;
      /**
       * if distance <= threshold
       * 
       * consider the city
       */
      for (int j : distances[i]) {
        if (j <= distanceThreshold) {
          count++;
        }
      }
      if (count <= min) {
        min = count;
        city = i;
      }
    }
    return city;
  }

}
