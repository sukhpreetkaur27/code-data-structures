package com.code.ds.striver.heap;

import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

You must solve it in O(n) time complexity.

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
 * 
 * @author sukh
 *
 */
public class _9_KthLargest {
  
  /**
   * NOTE: check Quick select solution also
   */

  /**
   * Time: O(n log k) <br>
   * Space: O(k)
   * 
   * @param nums
   * @param k
   * @return
   */
  public int findKthLargest(int[] nums, int k) {
    /**
     * maintain a min-heap of size k
     */
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
    int n = nums.length;
    for (int i = 0, top = 0; i < n; i++) {
      if (i < k) {
        minHeap.offer(nums[i]);
      } else {
        top = minHeap.peek();
        if (top < nums[i]) {
          minHeap.poll();
          minHeap.offer(nums[i]);
        }
      }
    }
    return minHeap.peek();
  }

}
