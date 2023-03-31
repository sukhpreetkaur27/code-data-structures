package com.code.ds.striver.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. 
 * The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections 
ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.

 

Example 1:


Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
Output: 4
Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
The four ways to get there in 7 minutes are:
- 0 ➝ 6
- 0 ➝ 4 ➝ 6
- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
Example 2:

Input: n = 2, roads = [[1,0,10]]
Output: 1
Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.
 

Constraints:

1 <= n <= 200
n - 1 <= roads.length <= n * (n - 1) / 2
roads[i].length == 3
0 <= ui, vi <= n - 1
1 <= timei <= 109
ui != vi
There is at most one road connecting any two intersections.
You can reach any intersection from any other intersection.
 * 
 * @author sukh
 *
 */
public class _40_NumberOfWaysToReachDestination {

  class Pair {
    int distance;
    int node;

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
   * Time: O(E log V) <br>
   * Space: O(E)
   * 
   * @param n
   * @param roads
   * @return
   */
  public int countPaths(int n, int[][] roads) {
    int MOD = (int) 1e9 + 7;
    int source = 0;
    int destination = n - 1;
    /**
     * Adjacency List
     */
    List<List<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }
    /**
     * Bi-Directional Undirected Graph
     */
    for (int[] road : roads) {
      adj.get(road[0]).add(new Pair(road[1], road[2]));
      adj.get(road[1]).add(new Pair(road[0], road[2]));
    }
    /**
     * Number of shortest ways per node
     */
    int[] ways = new int[n];
    Arrays.fill(ways, 0);
    ways[source] = 1;
    /**
     * Shortest distance per node
     */
    int[] distances = new int[n];
    Arrays.fill(distances, Integer.MAX_VALUE);
    distances[source] = 0;

    Queue<Pair> pq = new PriorityQueue<>(new PairComparator());
    pq.offer(new Pair(source, 0));

    while (!pq.isEmpty()) {
      Pair pop = pq.poll();

      for (Pair road : adj.get(pop.node)) {
        int dist = pop.distance + road.distance;
        if (distances[road.node] > dist) {
          /**
           * if shortest distance for node found
           * 
           * way count for node = way count [parent]
           * 
           * way count == # of paths via which we reach the current shortest distance for
           * the node
           */
          ways[road.node] = ways[pop.node];
          distances[road.node] = dist;
          pq.offer(new Pair(road.node, dist));
        } else if (distances[road.node] == dist) {
          /**
           * if we again land on the shortest distance via some other path
           * 
           * way count for node = way count [node] + way count [parent]
           */
          ways[road.node] = (ways[road.node] + ways[pop.node] % MOD) % MOD;
        }
      }
    }
    return ways[destination] % MOD;
  }

  public static void main(String[] args) {
    _40_NumberOfWaysToReachDestination obj = new _40_NumberOfWaysToReachDestination();
    int[][] roads = { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 }, { 6, 3, 3 },
        { 3, 5, 1 }, { 6, 5, 1 }, { 2, 5, 1 }, { 0, 4, 5 }, { 4, 6, 2 } };
    System.out.println(obj.countPaths(7, roads));
  }

}
