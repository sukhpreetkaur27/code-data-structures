package com.code.ds.array;

/**
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.

 

Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 5000
0 <= nums[i] <= 5000
 * @author sukh
 *
 */
public class SortByParity {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param arr
   */
  public void sort(int[] arr) {
    int size = arr.length;
    int left = 0;
    int right = size - 1;

    while (left < right) {
      if (arr[left] % 2 > arr[right] % 2) {
        swap(arr, left, right);
      }
      if (arr[left] % 2 == 0) {
        left++;
      }
      if (arr[right] % 2 != 0) {
        right--;
      }
    }
  }

  private void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }

}
