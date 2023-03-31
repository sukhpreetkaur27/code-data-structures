package com.code.ds.striver.array;

/**
 * 
 * Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * @author sukh
 *
 */
public class _4_RightRotateArray {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param arr
   * @param k
   */
  public void rightRotate(int[] arr, int k) {
    int n = arr.length;

    reverse(arr, 0, n - 1);
    reverse(arr, 0, k - 1);
    reverse(arr, k, n - 1);
  }

  private void reverse(int[] arr, int start, int end) {
    while (start < end) {
      int temp = arr[start];
      arr[start++] = arr[end];
      arr[end--] = temp;
    }
  }

}
