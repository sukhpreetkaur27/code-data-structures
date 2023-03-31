package com.code.ds.hashtable.hashset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 * @author sukh
 *
 */
public class IntersectionOfArrays_349 {

  /**
   * Time: O(n + m)<br>
   * Space: O(n + m)
   * @param a
   * @param b
   * @return
   */
  public int[] intersection(int[] a, int[] b) {
    Set<Integer> s1 = new HashSet<>();
    for (int i : a) {
      s1.add(i);
    }

    Set<Integer> s2 = new HashSet<>();
    for (int i : b) {
      s2.add(i);
    }

    if (s1.size() < s2.size()) {
      return intersection(s1, s2);
    } else {
      return intersection(s2, s1);
    }
  }

  private int[] intersection(Set<Integer> a, Set<Integer> b) {
    int[] res = new int[a.size()];
    int idx = 0;
    for (int i : a) {
      if (b.contains(i)) {
        res[idx++] = i;
      }
    }
    return Arrays.copyOf(res, idx);
  }

}
