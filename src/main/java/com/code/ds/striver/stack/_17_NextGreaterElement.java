package com.code.ds.striver.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, 
which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

 

Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
 

Constraints:

1 <= nums.length <= 104
-109 <= nums[i] <= 109
 * 
 * @author sukh
 *
 */
public class _17_NextGreaterElement {

  /**
   * Decreasing Monotonic Stack <br>
   * Top of stack = next greater element = the smallest element in the stack
   */

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * @param nums
   * @return
   */
  public int[] nextGreaterElements(int[] nums) {
    Deque<Integer> stack = new ArrayDeque<>();
    int[] res = new int[nums.length];
    int n = nums.length;

    for (int i = 2 * n - 1; i >= 0; i--) {
      /**
       * Time: O(n) at max, as it doesn't run for every i <br>
       * i.e. Each of the stack's n elements are pushed and popped exactly once.
       */
      while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
        stack.pop();
      }
      if (i < n) {
        res[i] = stack.isEmpty() ? -1 : stack.peek();
      }

      stack.push(nums[i % n]);
    }
    return res;
  }

}
