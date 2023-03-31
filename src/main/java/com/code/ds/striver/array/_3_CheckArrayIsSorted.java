package com.code.ds.striver.array;

/**
 * Example 1:

Input:
N = 5
arr[] = {10, 20, 30, 40, 50}
Output: 1
Explanation: The given array is sorted.
Example 2:

Input:
N = 6
arr[] = {90, 80, 100, 70, 40, 30}
Output: 0
Explanation: The given array is not sorted.
 * 
 * @author sukh
 *
 */
public class _3_CheckArrayIsSorted {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param arr
   * @return
   */
  public boolean isSorted(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
      if (arr[i] < arr[i - 1]) {
        return false;
      }
    }
    return true;
  }

}
