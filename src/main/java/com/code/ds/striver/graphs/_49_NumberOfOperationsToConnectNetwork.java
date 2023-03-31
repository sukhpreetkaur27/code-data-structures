package com.code.ds.striver.graphs;

/**
 * There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] 
 * represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them 
between any pair of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.

 

Example 1:


Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
Example 2:


Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
Output: 2
Example 3:

Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
Output: -1
Explanation: There are not enough cables.
 

Constraints:

1 <= n <= 105
1 <= connections.length <= min(n * (n - 1) / 2, 105)
connections[i].length == 2
0 <= ai, bi < n
ai != bi
There are no repeated connections.
No two computers are connected by more than one cable.
 * 
 * @author sukh
 *
 */
public class _49_NumberOfOperationsToConnectNetwork {

  /**
   * Time: O(E * log n + n log n) (or) O(E * 4 * alpha + n * 4 * alpha) <br>
   * Space: O(n)
   * 
   * @param n
   * @param connections
   * @return
   */
  public int makeConnected(int n, int[][] connections) {
    /**
     * n components can be connected with n-1 edges
     * 
     * check for extra edges per component
     * 
     * use DSU --> dynamic graph with check if connected
     */
    /**
     * 0-based indexing DSU
     */
    /**
     * Time: O(n) <br>
     * Space: O(2n)
     */
    _0_DisjointSet_UnionFind obj = new _0_DisjointSet_UnionFind(n);
    int extraEdges = 0;
    /**
     * Time: O(E log n)
     */
    for (int[] i : connections) {
      if (obj.isConnected(i[0], i[1])) {
        extraEdges++;
      } else {
        obj.unionBySize(i[0], i[1]);
      }
    }
    int components = 0;
    /**
     * Time: O(n log n)
     */
    for (int i = 0; i < n; i++) {
      if (obj.find(i) == i) {
        components++;
      }
    }
    /**
     * extra edges >= # components - 1
     */
    if (extraEdges >= components - 1) {
      return components - 1;
    }
    return -1;
  }

}
