package com.code.ds.array;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 * @author sukh
 *
 */
public class MoveZeros {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param arr
   */
  public void move(int[] arr) {
    int size = arr.length;
    int read;
    int write = 0;
    for (read = 0; read < size; read++) {
      if (arr[read] != 0) {
        arr[write++] = arr[read];
      }
    }
    while (write < size) {
      arr[write++] = 0;
    }
  }

}
