package com.code.ds.striver.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
 * 
 * @author sukh
 *
 */
public class _5_SlidingWindowMaximum {

  /**
   * Time: O(n) <br>
   * Space: O(k)
   * @param nums
   * @param k
   * @return
   */
  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    // +1 for the 1st sub-array
    int[] subArrays = new int[n - k + 1];

    // the deque maintains a size of k
    Deque<Integer> deque = new ArrayDeque<>(k);

    for (int i = 0, index = 0; i < n; i++) {
      // out of bounds
      if (!deque.isEmpty() && deque.peek() == i - k) {
        deque.poll();
      }
      // monotonic decreasing order
      while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
        /**
         * Intuition : the scanned element is > the top element, so the current could be
         * the maximum
         */
        deque.pollLast();
      }
      deque.offer(i);

      // max of current sub-array
      if (i >= k - 1) {
        // -1 due to 0-based indexing
        subArrays[index++] = nums[deque.peek()];
      }
    }

    return subArrays;
  }

}
