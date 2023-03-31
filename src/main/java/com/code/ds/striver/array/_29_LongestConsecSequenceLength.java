package com.code.ds.striver.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
 * 
 * @author sukh
 *
 */
public class _29_LongestConsecSequenceLength {

  /**
   * Time: O(n)<br>
   * Space: O(n)
   * @param arr
   * @return
   */
  public int length(int[] arr) {
    int max = 0;

    Set<Integer> set = new HashSet<>();
    for (int n : arr) {
      set.add(n);
    }

    for (int n : arr) {
      if (!set.contains(n - 1)) {
        int currLen = 1;

        while (set.contains(n + 1)) {
          n++;
          currLen++;
        }

        max = Math.max(max, currLen);
      }
    }

    return max;
  }

}
