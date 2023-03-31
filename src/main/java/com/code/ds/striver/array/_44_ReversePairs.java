package com.code.ds.striver.array;

import java.util.Arrays;

/**
 * Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where:

0 <= i < j < nums.length and
nums[i] > 2 * nums[j].
 

Example 1:

Input: nums = [1,3,2,3,1]
Output: 2
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
Example 2:

Input: nums = [2,4,3,5,1]
Output: 3
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
 

Constraints:

1 <= nums.length <= 5 * 104
-231 <= nums[i] <= 231 - 1

 * @author sukh
 *
 */
public class _44_ReversePairs {

  /**
   * Time: O(n log n)<br>
   * Space: O(n)
   * @param nums
   * @return
   */
  public int reversePairs(int[] nums) {
    return mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
  }

  private int mergeSort(int[] nums, int left, int right, int[] temp) {
    int count = 0;
    if (left < right) {
      int mid = left + (right - left) / 2;
      count += mergeSort(nums, left, mid, temp);
      count += mergeSort(nums, mid + 1, right, temp);
      count += merge(nums, left, mid, right, temp);
    }
    return count;
  }

  private int merge(int[] nums, int leftStart, int mid, int rightEnd, int[] temp) {
    int count = 0;
    int left = leftStart;
    int right = mid + 1;
    int index = leftStart;

    long prod = 1l;
    for (int l = leftStart, r = right; l <= mid; l++) {
      while (r <= rightEnd) {
        prod = 2l * nums[r];
        if (nums[l] > prod) {
          r++;
        } else {
          break;
        }
      }
      count += r - right;
    }

    while (left <= mid && right <= rightEnd) {
      if (nums[left] <= nums[right]) {
        temp[index++] = nums[left++];
      } else {
        temp[index++] = nums[right++];
      }
    }

    while (left <= mid) {
      temp[index++] = nums[left++];
    }

    while (right <= rightEnd) {
      temp[index++] = nums[right++];
    }

    while (leftStart <= rightEnd) {
      nums[leftStart] = temp[leftStart++];
    }

    return count;
  }

  public static void main(String[] args) {
    _44_ReversePairs obj = new _44_ReversePairs();
    int[] arr = { 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647 };
    System.out.println(obj.reversePairs(arr));
    System.out.println(Arrays.toString(arr));
  }

}
