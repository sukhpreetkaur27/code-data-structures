package com.code.ds.striver.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

 

Example 1:

Input: nums = [1,2,2,3,1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:

Input: nums = [1,2,2,3,1,4,2]
Output: 6
Explanation: 
The degree is 3 because the element 2 is repeated 3 times.
So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 

Constraints:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.
 * 
 * @author sukh
 *
 */
public class _49_DegreeOfArray {

  /**
   * Time: O(2N) <br>
   * Space: O(3N)
   * 
   * @param nums
   * @return
   */
  public int findShortestSubArray_brute(int[] nums) {
    /**
     * An array that has degree d, must have some element x occur d times. If some
     * subarray has the same degree, then some element x (that occured d times),
     * still occurs d times. The shortest such subarray would be from the first
     * occurrence of x until the last occurrence.
     */
    Map<Integer, Integer> freq = new HashMap<>();
    Map<Integer, Integer> left = new HashMap<>();
    Map<Integer, Integer> right = new HashMap<>();

    int degree = 1;
    for (int i = 0, count = 0; i < nums.length; i++) {
      count = freq.getOrDefault(nums[i], 0) + 1;
      degree = Math.max(degree, count);
      freq.put(nums[i], count);
      left.putIfAbsent(nums[i], i);
      right.put(nums[i], i);
    }

    int ans = nums.length;
    for (int i : freq.keySet()) {
      if (freq.get(i) == degree) {
        ans = Math.min(ans, right.get(i) - left.get(i) + 1);
      }
    }
    return ans;
  }

  /**
   * Time: O(N) <br>
   * Space: O(2N)
   * 
   * @param nums
   * @return
   */
  public int findShortestSubArray_optimal(int[] nums) {
    Map<Integer, Integer> freq = new HashMap<>();
    Map<Integer, Integer> left = new HashMap<>();

    int ans = nums.length;
    int degree = 0;
    for (int i = 0, count = 0; i < nums.length; i++) {
      left.putIfAbsent(nums[i], i);
      count = freq.getOrDefault(nums[i], 0) + 1;
      /**
       * if count > degree
       * 
       * then, degree = count
       * 
       * and our new sub-array with degree == array degree ends at i
       */
      if (count > degree) {
        degree = count;
        ans = i - left.get(nums[i]) + 1;
      }
      /**
       * if count == degree
       * 
       * it means we have already found a sub-array of same degree, we just need to
       * pick the minimum of these 2
       */
      else if (count == degree) {
        ans = Math.min(ans, i - left.get(nums[i]) + 1);
      }
      freq.put(nums[i], count);
    }

    return ans;
  }

}
