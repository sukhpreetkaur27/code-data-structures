package com.code.ds.hashtable.hashset;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
 * @author sukh
 *
 */
public class ContainsDuplicates_1_217 {

  /**
   * Time: O(n)<br>
   * Space: O(n)
   * @param arr
   * @return
   */
  public boolean findDuplicates(List<Integer> arr) {
    Set<Integer> set = new HashSet<>();
    for (Integer i : arr) {
      if (set.contains(i)) {
        return true;
      }
      set.add(i);
    }
    return false;
  }

}
