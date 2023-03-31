package com.code.ds.striver.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109
 

Follow up: Could you solve the problem in linear time and in O(1) space?
 * 
 * @author sukh
 *
 */
public class _21_MajorityElement_II {
  
  /**
   * 1st Approach: Brute Force<br>
   * 2nd Approach: HashMap
   */

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param nums
   * @return
   */
  public List<Integer> majority(int[] nums) {
    int n = nums.length;

    Integer candidate1 = null;
    Integer candidate2 = null;

    int count1 = 0;
    int count2 = 0;

    for (int num : nums) {
      if (candidate1 != null && candidate1 == num) {
        count1++;
      } else if (candidate2 != null && candidate2 == num) {
        count2++;
      } else if (count1 == 0) {
        candidate1 = num;
        count1++;
      } else if (count2 == 0) {
        candidate2 = num;
        count2++;
      } else {
        count1--;
        count2--;
      }
    }

    count1 = 0;
    count2 = 0;
    for (int num : nums) {
      if (candidate1 != null && candidate1 == num) {
        count1++;
      }
      if (candidate2 != null && candidate2 == num) {
        count2++;
      }
    }

    List<Integer> majority = new ArrayList<>();
    if (count1 > (n / 3)) {
      majority.add(candidate1);
    }
    if (count2 > (n / 3)) {
      majority.add(candidate2);
    }

    return majority;
  }

}