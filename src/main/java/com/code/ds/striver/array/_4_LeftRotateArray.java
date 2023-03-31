package com.code.ds.striver.array;

/**
 * Example 1:

Input: N = 7, K = 2
arr[] = {1, 2, 3, 4, 5, 6, 7}
Output: 3 4 5 6 7 1 2
Explanation: Rotation of the above 
array by 2 will make the output array .

 * @author sukh
 *
 */
public class _4_LeftRotateArray {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param arr
   * @param k
   */
  public void leftRotate(int[] arr, int k) {
    int n = arr.length;

    reverse(arr, 0, n - 1);
    reverse(arr, 0, n - k - 1);
    reverse(arr, n - k, n - 1);
  }

  private void reverse(int[] arr, int start, int end) {
    while (start < end) {
      int temp = arr[start];
      arr[start++] = arr[end];
      arr[end--] = temp;
    }
  }

}
