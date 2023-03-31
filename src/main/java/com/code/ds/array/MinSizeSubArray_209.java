package com.code.ds.array;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 

Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104
 

Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 * @author sukh
 *
 */
public class MinSizeSubArray_209 {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param nums
   * @param target
   * @return
   */
  public int minSubArrayLen(int[] nums, int target) {
    int minLen = Integer.MAX_VALUE;

    for (int right = 0, left = 0, sum = 0; right < nums.length; right++) {
      sum += nums[right];
      while (sum >= target) {
        minLen = Math.min(minLen, right - left + 1);
        sum -= nums[left++];
      }
    }

    return minLen == Integer.MAX_VALUE ? 0 : minLen;
  }

}
