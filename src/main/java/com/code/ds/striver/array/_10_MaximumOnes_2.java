package com.code.ds.striver.array;

/**
 * Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2
 * 
 * @author sukh
 *
 */
public class _10_MaximumOnes_2 {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param arr
   * @return
   */
  public static int maxOnes(int[] arr) {
    int max = 0;
    for (int i = 0, count = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        count = 0;
      } else {
        count++;
      }
      max = Math.max(max, count);
    }
    return max;
  }

}
