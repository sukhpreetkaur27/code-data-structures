package com.code.ds.striver.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.

Return the sum of all subarray ranges of nums.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0 
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
Example 2:

Input: nums = [1,3,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[3], range = 3 - 3 = 0
[3], range = 3 - 3 = 0
[1,3], range = 3 - 1 = 2
[3,3], range = 3 - 3 = 0
[1,3,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
Example 3:

Input: nums = [4,-2,-3,4,1]
Output: 59
Explanation: The sum of all subarray ranges of nums is 59.
 

Constraints:

1 <= nums.length <= 1000
-109 <= nums[i] <= 109
 

Follow-up: Could you find a solution with O(n) time complexity?
 * 
 * @author sukh
 *
 */
public class _30_SumOfSubArrayRanges {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * @param nums
   * @return
   */
  public long subArrayRanges(int[] nums) {
    /**
     * Range of a SubArray= Max - Min; <br>
     * Sum (of all Ranges) = Sum(Max) - Sum(Min);
     */
    long sum = 0;
    int n = nums.length;
    long count = 0;

    Deque<Integer> stack = new ArrayDeque<>();

    /**
     * Sum(Min)
     */
    for (int right = 0, min = 0, left = 0; right <= n; right++) {
      while (!stack.isEmpty() && (right == n || nums[stack.peek()] >= nums[right])) {
        min = stack.pop();
        left = stack.isEmpty() ? -1 : stack.peek();
        /**
         * count of sub-arrays with top as min = <br>
         * ( # of elements (inclusive of min) on the left ) * ( # of elements (inclusive
         * of min) on the right ) ; <br>
         * count = (right - min) * (min - left)
         */
        count = (long) (right - min) * (min - left);
        sum -= (long) (count * nums[min]);
      }
      stack.push(right);
    }

    stack.clear();

    /**
     * Sum(Max)
     */
    for (int right = 0, min = 0, left = 0; right <= n; right++) {
      while (!stack.isEmpty() && (right == n || nums[stack.peek()] <= nums[right])) {
        min = stack.pop();
        left = stack.isEmpty() ? -1 : stack.peek();
        /**
         * count of sub-arrays with top as max = <br>
         * ( # of elements (inclusive of max) on the left ) * ( # of elements (inclusive
         * of max) on the right ) ; <br>
         * count = (right - max) * (min - max)
         */
        count = (long) (right - min) * (min - left);
        sum += (long) (count * nums[min]);
      }
      stack.push(right);
    }

    return sum;
  }

}
