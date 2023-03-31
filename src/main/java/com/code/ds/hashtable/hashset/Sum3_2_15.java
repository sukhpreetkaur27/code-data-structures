package com.code.ds.hashtable.hashset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 * @author sukh
 *
 */
public class Sum3_2_15 {
  
  /**
   * NOTE:<br>
   * No-Sort Approach
   */

  /**
   * Time: O(n^2)<br>
   * Space: O(n)
   * @param nums
   * @return
   */
  public List<List<Integer>> threeSum(int[] nums) {
    /**
     * To store the unique triplets
     */
    Set<List<Integer>> res = new HashSet<>();

    /**
     * To avoid duplicates
     */
    Set<Integer> dups = new HashSet<>();
    /**
     * To keep track of the upcoming numbers are part of the i-th number
     */
    Map<Integer, Integer> seen = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (dups.add(nums[i])) {
        for (int j = i + 1; j < nums.length; j++) {
          int complement = -nums[i] - nums[j];
          if (seen.containsKey(complement) && seen.get(complement) == i) {
            List<Integer> tmp = Arrays.asList(nums[i], nums[j], complement);
            Collections.sort(tmp);
            res.add(tmp);
          }
          seen.put(nums[j], i);
        }
      }
    }
    return new ArrayList<>(res);
  }

}
