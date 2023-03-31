package com.code.ds.array;

/**
 * Squares of a Sorted Array
 * 
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 * @author sukh
 *
 */
public class SquaresOfSortedArray {

  /**
   * Time: O(n)<br>
   * Space: O(n)
   * @param nums
   * @return
   */
  public int[] sortedSquares(int[] nums) {
    int n = nums.length;
    int[] squares = new int[n];
    int left = 0;
    int right = n - 1;
    int num;
    for (int index = n - 1; index >= 0; index--) {
      if (Math.abs(nums[left]) < Math.abs(nums[right])) {
        num = Math.abs(nums[right]);
        right--;
      } else {
        num = Math.abs(nums[left]);
        left++;
      }
      squares[index] = num * num;
    }
    return squares;
  }

}
