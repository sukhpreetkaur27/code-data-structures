package com.code.ds.striver.graphs;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.

 

Example 1:


Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
Explanation: 

We can connect the points as shown above to get the minimum cost of 20.
Notice that there is a unique path between every pair of points.
Example 2:

Input: points = [[3,12],[-2,5],[-4,1]]
Output: 18
 

Constraints:

1 <= points.length <= 1000
-106 <= xi, yi <= 106
All pairs (xi, yi) are distinct.
 * 
 * @author sukh
 *
 */
public class _46_MinCostToConnectAllPoints {

  class Edge {
    int point1;
    int point2;
    int cost;

    Edge(int point1, int point2, int cost) {
      this.point1 = point1;
      this.point2 = point2;
      this.cost = cost;
    }
  }

  class EdgeComparator implements Comparator<Edge> {
    public int compare(Edge a, Edge b) {
      return a.cost - b.cost;
    }
  }

  /**
   * Time: O(N^2 log N) <br>
   * Space: O(N^2)
   * 
   * @param points
   * @return
   */
  public int minCostConnectPoints(int[][] points) {
    /**
     * Prim's Algorithm
     */
    /**
     * Consider each points[i] as a node --> therefore, n nodes
     */
    int min_cost = 0;
    int n = points.length;
    boolean[] visited = new boolean[n];
    Queue<Edge> pq = new PriorityQueue<>(new EdgeComparator());
    /**
     * Start with the first point
     */
    int src = 0;
    int[] point_src = points[src];
    /**
     * Push all costs from the first point
     */
    for (int i = 1, cost = 0; i < n; i++) {
      cost = Math.abs(point_src[0] - points[i][0])
          + Math.abs(point_src[1] - points[i][1]);
      pq.offer(new Edge(src, i, cost));
    }
    /**
     * mark the first node as visited
     */
    visited[src] = true;
    /**
     * keep a count of the visited nodes to exit the queue traversal
     */
    int count = n - 1;

    while (!pq.isEmpty() && count > 0) {
      Edge pop = pq.poll();
      if (!visited[pop.point2]) {
        visited[pop.point2] = true;
        min_cost += pop.cost;
        /**
         * Move to all other points(nodes) from the point2
         */
        for (int i = 0, cost = 0; i < n; i++) {
          if (!visited[i]) {
            cost = Math.abs(points[pop.point2][0] - points[i][0])
                + Math.abs(points[pop.point2][1] - points[i][1]);
            pq.offer(new Edge(pop.point2, i, cost));
          }
        }
        count--;
      }
    }
    return min_cost;
  }

}
