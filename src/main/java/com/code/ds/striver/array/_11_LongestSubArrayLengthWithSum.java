package com.code.ds.striver.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array containing N integers and an integer K., Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.

 

Example 1:
 

Input :
A[] = {10, 5, 2, 7, 1, 9}
K = 15
Output : 4
Explanation:
The sub-array is {5, 2, 7, 1}.
Example 2:

Input : 
A[] = {-1, 2, 3}
K = 6
Output : 0
Explanation: 
There is no such sub-array with sum 6.
 * 
 * @author sukh
 *
 */
public class _11_LongestSubArrayLengthWithSum {

  /**
   *  // if (!prefixSumMaxLen.containsKey(prefixSum)) {
        prefixSumMaxLen.put(prefixSum, i);
      //}
   * 
   * {0=-1, 36=15, -7=2, 8=3, 41=6, 43=13, -13=1, 45=14, 46=12, 24=4, 26=5, 27=11,
   * 29=7, 30=16}
   * 
   * 4
   */

  /**
   *  if (!prefixSumMaxLen.containsKey(prefixSum)) {
        prefixSumMaxLen.put(prefixSum, i);
      }
   * 
   * {0=-1, 36=15, -7=2, 8=3, 41=6, 43=13, -13=0, 45=14, 46=8, 24=4, 26=5, 27=11,
   * 29=7, 30=9}
   * 
   * 5
   * 
   */

  /**
   * Time: O(n)<br>
   * Space: O(n)
   * @param arr
   * @param k
   * @return
   */
  public static int longestSubArray(int[] A, int K) {
    int max = 0;

    Map<Integer, Integer> prefixSumMaxLen = new HashMap<>();
    prefixSumMaxLen.put(0, -1);

    int prefixSum = 0;
    for (int i = 0; i < A.length; i++) {
      prefixSum += A[i];

      if (prefixSumMaxLen.containsKey(prefixSum - K)) {
        max = Math.max(max, i - prefixSumMaxLen.get(prefixSum - K));
      }
      /**
       * NOTE: if we keep on updating the length, we end up finding the shortest
       * sub-array.<br>
       * If we put just the initial length and not the latest length for the same
       * prefix sum,<br>
       * then, (i - initial_prefixSumLength) > (i - latest_prefixSumLength)
       */
      if (!prefixSumMaxLen.containsKey(prefixSum)) {
        prefixSumMaxLen.put(prefixSum, i);
      }
    }

    return max;
  }

  public static void main(String[] args) {
    int[] arr = { -13, 0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6 };
    int k = 15;
    System.out.println(longestSubArray(arr, k));
  }

}
