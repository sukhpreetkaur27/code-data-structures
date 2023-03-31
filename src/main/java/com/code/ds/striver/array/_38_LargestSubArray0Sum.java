package com.code.ds.striver.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Example 1:

Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with
sum 0 will be -2 2 -8 1 7.
Your Task:
You just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
-1000 <= A[i] <= 1000, for each valid i


 * 
 * @author sukh
 *
 */
public class _38_LargestSubArray0Sum {

  /**
   * Time: O(n)<br>
   * Space: O(n)
   * @param arr
   * @return
   */
  public int maxLen(int[] arr) {
    int max = 0;
    Map<Integer, Integer> map = new HashMap<>();
    /**
     * if sum of all the elements = 0
     */
    map.put(0, -1);
    for (int i = 0, s = 0; i < arr.length; i++) {
      s += arr[i];
      if (map.containsKey(s)) {
        max = Math.max(max, i - map.get(s));
      } else {
        map.put(s, i);
      }
    }
    return max;
  }

}
