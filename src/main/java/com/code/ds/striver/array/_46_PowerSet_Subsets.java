package com.code.ds.striver.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
 * 
 * @author sukh
 *
 */
public class _46_PowerSet_Subsets {

  /**
   * Time: O((2^n) * n) <br>
   * Space: O(1)
   * @param nums
   * @return
   */
  public List<List<Integer>> subset(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    int n = nums.length;
    /**
     * # of subsets = 2^n
     */
    int end = (1 << n) - 1;
    for (int i = 0; i <= end; i++) {
      List<Integer> subset = new ArrayList<>();
      for (int j = 0, bit = 0; j < n; j++) {
        /**
         * if the i-th bit is set, use nums[i] as part of the subset
         */
        bit = i & (1 << j);
        if (bit != 0) {
          subset.add(nums[j]);
        }
      }
      list.add(subset);
    }

    return list;
  }

}
