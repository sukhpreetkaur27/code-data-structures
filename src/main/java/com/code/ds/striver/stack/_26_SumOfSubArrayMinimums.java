package com.code.ds.striver.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. 
 * Since the answer may be large, return the answer modulo 109 + 7.

 

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444
 

Constraints:

1 <= arr.length <= 3 * 104
1 <= arr[i] <= 3 * 104
 * 
 * @author sukh
 *
 */
public class _26_SumOfSubArrayMinimums {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * @param arr
   * @return
   */
  public int sumSubarrayMins(int[] arr) {
    /**
     * 1. Find left small and right small for each element <br>
     * 2. left count = # of elements (inclusive of current) on the left <br>
     * 3. right count = # of elements (inclusive of current) on the right <br>
     * 4. count = count of sub-arrays with current element as min = ( left count *
     * right count) <br>
     * 5. sum += min_value * count
     */

    int MOD = (int) 1e9 + 7;
    long sum = 0;
    int n = arr.length;
    Deque<Integer> stack = new ArrayDeque<>();

    long count, minValue;
    for (int i = 0, curr = 0, leftSmall = 0; i <= n; i++) {
      while (!stack.isEmpty() && (i == n || arr[stack.peek()] >= arr[i])) {
        curr = stack.peek();
        stack.pop();
        leftSmall = stack.isEmpty() ? -1 : stack.peek();
        /**
         * count of sub-arrays with curr as min = ( # of elements (inclusive of min) on
         * the left ) * ( # of elements (inclusive of min) on the right ) ; <br>
         * count = (i - curr) * (curr - leftSmall)
         */
        count = ((i - curr) * (curr - leftSmall)) % MOD;
        minValue = (count * arr[curr]) % MOD;
        sum = (sum + minValue) % MOD;
      }
      stack.push(i);
    }

    return (int) sum;
  }

}
