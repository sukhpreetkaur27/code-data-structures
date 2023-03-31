package com.code.ds.striver.graphs;

/**
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, 
 * then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

 

Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 

Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
 * 
 * @author sukh
 *
 */
public class _48_NumberOfProvinces {
  
  /**
   * Similar to Number of Connected Components in an Undirected Graph
   * 
   * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
   */

  /**
   * Time: O(n^2 log n) (or) O(n^2 * 4 * alpha) <br>
   * Space: O(2n) by DSU
   * 
   * @param isConnected
   * @return
   */
  public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length;
    /**
     * Time: O(n) <br>
     * Space: O(2n)
     */
    _0_DisjointSet_UnionFind obj = new _0_DisjointSet_UnionFind(n + 1);
    /**
     * Time: O(n^2 log n)
     */
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (isConnected[i][j] == 1) {
          obj.unionByRank(i + 1, j + 1);
        }
      }
    }
    int count = 0;
    /**
     * Time: O(n)
     */
    for (int i = 1; i <= n; i++) {
      if (obj.find(i) == i) {
        count++;
      }
    }
    /**
     * if parents are visible
     */
//    for (int i = 1; i <= n; i++) {
//      if (obj.parent.get(i) == i) {
//        count++;
//      }
//    }
    return count;
  }

}
