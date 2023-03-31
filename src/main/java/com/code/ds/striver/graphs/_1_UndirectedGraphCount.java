package com.code.ds.striver.graphs;

/**
 * Given an integer n representing number of vertices. Find out how many undirected graphs (not necessarily connected) can be constructed out of a given n number of vertices.

 

Example 1:

Input: 2
Output: 2
Example 2:

Input: 5
Output: 1024
 * 
 * @author sukh
 *
 */
public class _1_UndirectedGraphCount {

  /**
   * Time: O(1) <br>
   * Space: O(1)
   * @param nodes
   * @return
   */
  public long count(int nodes) {
    /**
     * undirected graph count = 2 ^ [ n * ( n - 1 ) / 2 ]
     */
    long x = 2l;
    long y = (long) nodes * (nodes - 1l) / 2l;
    return (long) Math.pow(x, y);
  }

}
