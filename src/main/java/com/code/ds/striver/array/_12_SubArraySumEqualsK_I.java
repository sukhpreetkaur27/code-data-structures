package com.code.ds.striver.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 * 
 * @author sukh
 *
 */
public class _12_SubArraySumEqualsK_I {

  /**
   * Time: O(n)<br>
   * Space: O(n)
   * @param arr
   * @param k
   * @return
   */
  public int noOfSubArrays(int[] arr, int k) {
    int count = 0;

    /**
     * Stores the prefix sum a.k.a cumulative sum and its frequency
     */
    Map<Integer, Integer> prefixSumFreq = new HashMap<>();
    /**
     * NOTE: Edge case<br>
     * if prefix sum - k = 0<br>
     * i.e., from start till j-th position
     */
    prefixSumFreq.put(0, 1);

    int prefixSum = 0;
    for (int i = 0; i < arr.length; i++) {
      prefixSum += arr[i];

      if (prefixSumFreq.containsKey(prefixSum - k)) {
        count += prefixSumFreq.get(prefixSum - k);
      }
      prefixSumFreq.put(prefixSum, prefixSumFreq.getOrDefault(prefixSum, 0) + 1);
    }

    return count;
  }

}
