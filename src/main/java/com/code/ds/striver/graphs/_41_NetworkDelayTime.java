package com.code.ds.striver.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), 
 * where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, 
return -1.

 

Example 1:


Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 

Constraints:

1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
 * 
 * @author sukh
 *
 */
public class _41_NetworkDelayTime {

  class Pair {
    int time;
    int node;

    Pair(int node, int time) {
      this.node = node;
      this.time = time;
    }
  }

  class PairComparator implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
      if (a.time == b.time) {
        return a.node - b.node;
      }
      return a.time - b.time;
    }
  }

  /**
   * Time: O(V + E log V) <br>
   * Space: O(V + E)
   * 
   * @param times
   * @param n
   * @param source
   * @return
   */
  public int networkDelayTime(int[][] times, int n, int source) {
    /**
     * Dijkstra's Algorithm
     */
    List<List<Pair>> adj = new ArrayList<>();
    /**
     * Adjacency List
     */
    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<>());
    }
    /**
     * Directed Graph
     */
    for (int[] time : times) {
      adj.get(time[0]).add(new Pair(time[1], time[2]));
    }
    /**
     * Shortest time per node
     */
    int[] distances = new int[n + 1];
    Arrays.fill(distances, Integer.MAX_VALUE);
    /**
     * 1-based indexing
     * 
     * default [0] = 0
     */
    distances[0] = 0;
    distances[source] = 0;

    Queue<Pair> pq = new PriorityQueue<>(new PairComparator());
    pq.offer(new Pair(source, 0));

    while (!pq.isEmpty()) {
      Pair pop = pq.poll();

      for (Pair time : adj.get(pop.node)) {
        int dist = pop.time + time.time;
        if (distances[time.node] > dist) {
          distances[time.node] = dist;
          pq.offer(new Pair(time.node, dist));
        }
      }
    }
    int min = 0;
    /**
     * Minimum Time = Maximum Time of all the shortest time per node
     */
    for (int time : distances) {
      if (time == Integer.MAX_VALUE) {
        return -1;
      }
      min = Math.max(min, time);
    }
    return min;
  }

}
