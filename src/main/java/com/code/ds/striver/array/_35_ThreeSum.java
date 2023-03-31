package com.code.ds.striver.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * 
 * @author sukh
 *
 */
public class _35_ThreeSum {
  
  /**
   * NOTE:<br>
   * 1. Brute Force<br>
   * 2. Hashing<br>
   * 3. Two Pointer
   */

  /**
   * Time: O(n^2)<br>
   * Space: O(1)
   * @param arr
   * @return
   */
  public List<List<Integer>> threeSum(int[] arr) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(arr);
    for (int i = 0; i < arr.length && arr[i] <= 0; i++) {
      if (i == 0 || arr[i] != arr[i - 1]) {
        threeSum(arr, i, list);
      }
    }
    return list;
  }

  private void threeSum(int[] arr, int i, List<List<Integer>> list) {
    int lo = i + 1;
    int hi = arr.length - 1;

    while (lo < hi) {
      int s = arr[i] + arr[lo] + arr[hi];

      if (s < 0) {
        lo++;
      } else if (s > 0) {
        hi--;
      } else {
        list.add(Arrays.asList(arr[i], arr[lo], arr[hi]));
        lo++;
        hi--;
        while (lo < hi && arr[lo] == arr[lo - 1]) {
          lo++;
        }
      }
    }
  }

}
