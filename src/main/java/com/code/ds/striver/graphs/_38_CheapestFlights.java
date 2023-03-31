package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates 
 * that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

 

Example 1:


Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
Example 2:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
Example 3:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
 

Constraints:

1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 104
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst
 * 
 * @author sukh
 *
 */
public class _38_CheapestFlights {

  class Pair {
    int node;
    int cost;

    Pair(int node, int cost) {
      this.node = node;
      this.cost = cost;
    }
  }

  class Tuple {
    int node;
    int stops;
    int cost;

    Tuple(int node, int stops, int cost) {
      this.node = node;
      this.stops = stops;
      this.cost = cost;
    }
  }

  /**
   * Time: O(E); as no PQ is used <br>
   * Space: O(E)
   * 
   * @param n
   * @param flights
   * @param src
   * @param dst
   * @param k
   * @return
   */
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    /**
     * Dijkstra's Algorithm - Queue
     */
    /**
     * PQ - distance will not be our first priority, <br>
     * a. as there might be paths to a node with larger distance but minimum stops
     * and minimum distance to the destination <br>
     * b. There might be nodes with shorter distance but more stops which will not
     * be able to reach the destination in the visited array. <br>
     * (b) will not allow us to go with (a), which could have lead us to the answer.
     * 
     * Hence, use PQ - stops as priority <br>
     * because we need to reach the destination with the shortest distance but with
     * at most k stops
     */
    /**
     * NOTE: we don't need a PQ, else a Queue will suffice. Why ?
     * 
     * As we consider stops as our priority, which increment by 1 --> as a result,
     * the Queue is always in ascending order by stops
     */
    List<List<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<Pair>());
    }
    for (int[] i : flights) {
      adj.get(i[0]).add(new Pair(i[1], i[2]));
    }

    Deque<Tuple> queue = new ArrayDeque<>();
    queue.offer(new Tuple(src, 0, 0));

    int[] costs = new int[n];
    Arrays.fill(costs, Integer.MAX_VALUE);

    while (!queue.isEmpty()) {
      Tuple pop = queue.poll();
      if (pop.stops > k) {
        continue;
      }
      for (Pair i : adj.get(pop.node)) {
        int cost = pop.cost + i.cost;

        if (costs[i.node] > cost) {
          costs[i.node] = cost;
          queue.offer(new Tuple(i.node, pop.stops + 1, cost));
        }
      }
    }

    return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
  }

}
