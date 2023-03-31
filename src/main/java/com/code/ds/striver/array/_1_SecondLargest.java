package com.code.ds.striver.array;

/**
 * Example 1:

Input: 
N = 6
Arr[] = {12, 35, 1, 10, 34, 1}
Output: 34
Explanation: The largest element of the 
array is 35 and the second largest element
is 34.
 * 
 * @author sukh
 *
 */
public class _1_SecondLargest {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param arr
   * @return
   */
  public int secondLargest(int[] arr) {
    int n = arr.length;
    int max = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      if (arr[i] > max) {
        max2 = max;
        max = arr[i];
      } else if (arr[i] > max2 && arr[i] != max) {
        max2 = arr[i];
      }
    }
    return max2;
  }

}
