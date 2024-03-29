package com.code.ds.striver.array;

/**
 * Given an integer array nums, find the subarray which has the largest sum and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
 * 
 * @author sukh
 *
 */
public class _22_MaximumSubArraySum_I {

  /**
   * NOTE: <br>
   * Kadane's Algorithm
   */

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param arr
   * @return
   */
  public int max(int[] arr) {
    int max = arr[0];
    int sum = 0;
    for (int n : arr) {
      sum += n;
      max = Math.max(max, sum);
      if (sum < 0) {
        sum = 0;
      }
    }
    return max;
  }

}
