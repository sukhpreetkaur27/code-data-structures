package com.code.ds.array;

/**
 * Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

 

Example 1:

Input: arr = [2,1]
Output: false
Example 2:

Input: arr = [3,5,5]
Output: false
Example 3:

Input: arr = [0,3,2,1]
Output: true
 

Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 104
 * @author sukh
 *
 */
public class ValidMountainArray {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param arr
   * @return
   */
  public boolean mySolution(int[] arr) {
    int size = arr.length;
    if (arr == null || size < 3) {
      return false;
    }
    int i;
    for (i = 0; i < size - 2; i++) {
      if (arr[i + 1] < arr[i]) {
        break;
      }
    }
    if (i == 0) {
      return false;
    }
    for (int j = i; j < size - 1; j++) {
      if (arr[j + 1] > arr[j]) {
        return false;
      }
    }
    return true;
  }

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param arr
   * @return
   */
  public boolean leetCodeSolution(int[] arr) {
    int size = arr.length;
    if (arr == null || size < 3) {
      return false;
    }
    int i = 0;
    while (i + 1 < size && arr[i] < arr[i + 1]) {
      i++;
    }
    if (i == 0 || i == size - 1) {
      return false;
    }
    while (i + 1 < size && arr[i] > arr[i + 1]) {
      i++;
    }
    return i == size - 1;
  }

}
