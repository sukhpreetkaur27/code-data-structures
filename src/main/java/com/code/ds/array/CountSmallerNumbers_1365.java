package com.code.ds.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.

 

Example 1:

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation: 
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1). 
For nums[3]=2 there exist one smaller number than it (1). 
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
Example 2:

Input: nums = [6,5,4,8]
Output: [2,1,0,3]
Example 3:

Input: nums = [7,7,7,7]
Output: [0,0,0,0]
 

Constraints:

2 <= nums.length <= 500
0 <= nums[i] <= 100
 * 
 * @author sukh
 *
 */
public class CountSmallerNumbers_1365 {

  /**
   * Time: O(n log n) <br>
   * due to the sorting <br>
   * Space: O(n)
   * @param nums
   * @return
   */
  public int[] smallerNumbersThanCurrent(int[] nums) {
    int[] clone = nums.clone();
    Arrays.sort(clone);
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.putIfAbsent(clone[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      clone[i] = map.get(nums[i]);
    }
    return clone;
  }

  /**
   * Approach 2 <br>
   * Use this due to the input constraint
   */
  /**
   * Time: O(n) <br>
   * Space: O(n)
   * @param nums
   * @return
   */
  public int[] countSort(int[] nums) {
    int[] bucket = new int[101];

    /**
     * count the frequency
     */
    for (int i = 0; i < nums.length; i++) {
      bucket[nums[i]]++;
    }

    /**
     * add the frequency of the previous element <br>
     * which implies the # of elements smaller than the current
     */
    for (int i = 1; i < 101; i++) {
      bucket[i] += bucket[i - 1];
    }

    int[] res = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        res[i] = 0;
      } else {
        /**
         * the count till the previous element
         */
        res[i] = bucket[nums[i] - 1];
      }
    }
    return res;
  }

}
