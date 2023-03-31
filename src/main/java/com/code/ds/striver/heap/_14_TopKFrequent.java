package com.code.ds.striver.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * 
 * @author sukh
 *
 */
public class _14_TopKFrequent {

  /**
   * Time: O(n log k) <br>
   * Space: O(k)
   * 
   * @param nums
   * @param k
   * @return
   */
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int i : nums) {
      freq.put(i, freq.getOrDefault(i, 0) + 1);
    }
    PriorityQueue<Integer> queue = new PriorityQueue<>(
        (a, b) -> freq.get(a) - freq.get(b));
    for (int i : freq.keySet()) {
      queue.offer(i);
      if (queue.size() > k) {
        queue.poll();
      }
    }
    int[] res = new int[k];
    for (int i = k - 1; i >= 0; i--) {
      res[i] = queue.poll();
    }
    return res;
  }

}
