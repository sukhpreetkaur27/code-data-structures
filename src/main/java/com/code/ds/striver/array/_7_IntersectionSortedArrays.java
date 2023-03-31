package com.code.ds.striver.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Example 1:
Input: 
A: [1 2 3 3 4 5 6]
, B: [3 3 5]
Output: 3,3,5
Explanation: We are given two arrays A and B. 
The elements present in both the arrays  
are 3,3 and 5.

Example 2:
Input: 
A: [1 2 3 3 4 5 6]
, B: [3 5]
Output: 3,5
Explanation: We are given two arrays A and B. 
The elements present in both the arrays are 3 and 5.
 * 
 * @author sukh
 *
 */
public class _7_IntersectionSortedArrays {

  /**
   * Time: O(min(n,m))<br>
   * Space: O(1)
   * @param a
   * @param b
   * @return
   */
  public List<Integer> intersect(int[] a, int[] b) {
    List<Integer> intersect = new ArrayList<>();
    int al = a.length;
    int bl = b.length;
    for (int p1 = 0, p2 = 0; p1 < al && p2 < bl;) {
      if (a[p1] < b[p2]) {
        p1++;
      } else if (b[p2] < a[p1]) {
        p2++;
      } else {
        intersect.add(a[p1]);
        p1++;
        p2++;
      }
    }
    return intersect;
  }

}
