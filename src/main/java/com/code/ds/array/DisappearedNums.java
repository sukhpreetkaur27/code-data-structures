package com.code.ds.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
 * @author sukh
 *
 */
public class DisappearedNums {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param arr
   * @return
   */
  public List<Integer> missing(int[] arr) {
    List<Integer> res = new ArrayList<>();
    int newIndex;
    for (int i = 0; i < arr.length; i++) {
      newIndex = Math.abs(arr[i]) - 1;
      if (arr[newIndex] > 0) {
        arr[newIndex] *= -1;
      }
    }

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > 0) {
        res.add(i + 1);
      }
    }
    return res;
  }

}
