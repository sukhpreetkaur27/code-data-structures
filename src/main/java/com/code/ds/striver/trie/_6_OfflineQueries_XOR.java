package com.code.ds.striver.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * You are given an array nums consisting of non-negative integers. You are also given a queries array, where queries[i] = [xi, mi].

The answer to the ith query is the maximum bitwise XOR value of xi and any element of nums that does not exceed mi. 
In other words, the answer is max(nums[j] XOR xi) for all j such that nums[j] <= mi. If all elements in nums are larger than mi, then the answer is -1.

Return an integer array answer where answer.length == queries.length and answer[i] is the answer to the ith query.

 

Example 1:

Input: nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
Output: [3,3,7]
Explanation:
1) 0 and 1 are the only two integers not greater than 1. 0 XOR 3 = 3 and 1 XOR 3 = 2. The larger of the two is 3.
2) 1 XOR 2 = 3.
3) 5 XOR 2 = 7.
Example 2:

Input: nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
Output: [15,-1,5]
 

Constraints:

1 <= nums.length, queries.length <= 105
queries[i].length == 2
0 <= nums[j], xi, mi <= 109
 * 
 * @author sukh
 *
 */
public class _6_OfflineQueries_XOR {

  /**
   * NOTE: This is an extension to com.code.ds.striver.trie._5_MaximumXOR
   */

  private class Query {
    int x;
    int m;
    int index;

    Query(int x, int m, int index) {
      this.x = x;
      this.m = m;
      this.index = index;
    }
  }

  /**
   * Time: O(n log n) + O(q) + O(q log q) + O(q * 32 + n * 32)
   * 
   * @param nums
   * @param queries
   * @return
   */
  public int[] maximizeXor(int[] nums, int[][] queries) {
    /**
     * sort the array
     * 
     * Time: O(n log n)
     */
    Arrays.sort(nums);
    /**
     * convert online queries to offline queries by storing the index
     */
    List<Query> Queries = new ArrayList<>();
    /**
     * Time: O(q)
     */
    for (int i = 0; i < queries.length; i++) {
      Queries.add(new Query(queries[i][0], queries[i][1], i));
    }
    /**
     * sort as per m
     * 
     * Time: O(q log q)
     */
    Collections.sort(Queries, (a, b) -> {
      return a.m - b.m;
    });
    int[] ans = new int[queries.length];
    _5_Trie trie = new _5_Trie();
    int index = 0;
    /**
     * Time: O(q + n)
     */
    for (Query q : Queries) {
      /**
       * Insert into trie values <= query.m
       */
      while (index < nums.length && nums[index] <= q.m) {
        trie.insert(nums[index]);
        index++;
      }
      /**
       * if trie is empty, mark XOR = -1
       */
      if (index == 0) {
        ans[q.index] = -1;
      } else {
        ans[q.index] = trie.maximumXOR(q.x);
      }

    }
    return ans;
  }

}
