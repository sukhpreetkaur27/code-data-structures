package com.code.ds.binarySearchTree;

import java.util.Set;
import java.util.TreeSet;

/**
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
 * @author sukh
 *
 */
public class ContainsDuplicate_2_219 {

  /**
   * Sliding-Window
   */
  
  /**
   * Time Limit Exceeded for larger values of n<br>
   * Time: O(n * log(min(n,k)))<br>
   * Space: O(min(n,k))
   * @param arr
   * @param k
   * @return
   */
  public boolean containsNearByDuplicate(int[] arr, int k) {
    Set<Integer> set = new TreeSet<>();
    for (int i = 0; i < arr.length; i++) {
      if (set.contains(arr[i])) {
        return true;
      }
      set.add(arr[i]);
      if (set.size() > k) {
        /**
         * Remove the oldest element
         */
        set.remove(arr[i - k]);
      }
    }
    return false;
  }

}
