package com.code.ds.striver.array;

/**
 * Example 1:

Input:
N = 5
Arr[] = {3, 5, 0, 0, 4}
Output: 3 5 4 0 0
Explanation: The non-zero elements
preserve their order while the 0
elements are moved to the right.
Example 2:

Input:
N = 4
Arr[] = {0, 0, 0, 4}
Output: 4 0 0 0
Explanation: 4 is the only non-zero
element and it gets moved to the left.
 * 
 * @author sukh
 *
 */
public class _5_MoveZeroes {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param arr
   */
  public void moveZeroes(int[] arr) {
    int n = arr.length;
    int w = 0;
    for (int r = 0; r < n; r++) {
      if (arr[r] != 0) {
        int temp = arr[r];
        arr[r] = arr[w];
        arr[w++] = temp;
      }
    }
  }

}
