package com.code.ds.striver.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.

A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.

Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.

 

Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
Explanation: One way to remove 5 stones is as follows:
1. Remove stone [2,2] because it shares the same row as [2,1].
2. Remove stone [2,1] because it shares the same column as [0,1].
3. Remove stone [1,2] because it shares the same row as [1,0].
4. Remove stone [1,0] because it shares the same column as [0,0].
5. Remove stone [0,1] because it shares the same row as [0,0].
Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.
Example 2:

Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3
Explanation: One way to make 3 moves is as follows:
1. Remove stone [2,2] because it shares the same row as [2,0].
2. Remove stone [2,0] because it shares the same column as [0,0].
3. Remove stone [0,2] because it shares the same row as [0,0].
Stones [0,0] and [1,1] cannot be removed since they do not share a row/column with another stone still on the plane.
Example 3:

Input: stones = [[0,0]]
Output: 0
Explanation: [0,0] is the only stone on the plane, so you cannot remove it.
 

Constraints:

1 <= stones.length <= 1000
0 <= xi, yi <= 104
No two stones are at the same coordinate point.
 * 
 * @author sukh
 *
 */
public class _53_RemoveStones {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param stones
   * @return
   */
  public int removeStones(int[][] stones) {
    /**
     * DSU - Connecting Nodes
     * 
     * Consider each row and each column as a node
     * 
     * eg: 4 * 4 matrix <br>
     * 4 rows = 0 - 3 <br>
     * 4 cols = 4 - 7 <br>
     * 
     * column node = rows + column_index + 1
     * 
     * merge (union) row node and column node for a stone
     * 
     * stones on the same row and same column form part of a connected component
     * 
     * if there are 4 stones in a component, only 1 stone will remain after
     * canceling all other stones (in the component) <br>
     * therefore, number of stones removed = 4 - 1 = 3
     * 
     * eg: n stones <br>
     * component 1 = x1 stones <br>
     * component 2 = x2 stones <br>
     * n = x1 + x2 <br>
     * stones removed = x1 - 1 + x2 - 1 = (x1 + x2) - (1 + 1) = n - 2 = n - #
     * components
     */
    int rows = 0;
    int cols = 0;
    /**
     * Count the max row and max column as per the stones coordinates
     */
    for (int[] i : stones) {
      rows = Math.max(rows, i[0]);
      cols = Math.max(cols, i[1]);
    }
    /**
     * +2 for both row and column due to 0-based indexing of stones[][]
     */
    _0_DisjointSet_UnionFind dsu = new _0_DisjointSet_UnionFind(rows + cols + 2);
    /**
     * Store the stone nodes
     */
    Set<Integer> stoneNodes = new HashSet<>();
    for (int[] i : stones) {
      int rowNode = i[0];
      int colNode = rows + i[1] + 1;
      /**
       * union of row node and column node
       */
      dsu.unionBySize(rowNode, colNode);
      stoneNodes.add(rowNode);
      stoneNodes.add(colNode);
    }
    int components = 0;
    for (Integer i : stoneNodes) {
      /**
       * if ultimate parent of stone node == stone node
       * 
       * increment component count
       */
      if (dsu.find(i) == i) {
        components++;
      }
    }
    return stones.length - components;
  }
  
  

}
