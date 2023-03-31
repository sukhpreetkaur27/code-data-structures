package com.code.ds.hashtable.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 

Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 * @author sukh
 *
 */
public class IntersectionOfArrays_1_350 {

  /**
   * Time: O(n + m)<br>
   * Space: O(min(n,m))
   * @param a
   * @param b
   * @return
   */
  public int[] intersection(int[] a, int[] b) {
    if (a.length > b.length) {
      return intersection(b, a);
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (int i : a) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    int count = 0;
    int k = 0;
    for (int i : b) {
      count = map.getOrDefault(i, 0);
      if (count > 0) {
        a[k++] = i;
        map.put(i, count - 1);
      }
    }
    return Arrays.copyOf(a, k);
  }

}
