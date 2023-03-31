package com.code.ds.striver.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Union of two arrays can be defined as the common and distinct elements in the two arrays.
Given two sorted arrays of size n and m respectively, find their union.


Example 1:

Input: 
n = 5, arr1[] = {1, 2, 3, 4, 5}  
m = 3, arr2 [] = {1, 2, 3}
Output: 1 2 3 4 5
Explanation: Distinct elements including 
both the arrays are: 1 2 3 4 5.
 

Example 2:

Input: 
n = 5, arr1[] = {2, 2, 3, 4, 5}  
m = 5, arr2[] = {1, 1, 2, 3, 4}
Output: 1 2 3 4 5
Explanation: Distinct elements including 
both the arrays are: 1 2 3 4 5.
 

Example 3:

Input:
n = 5, arr1[] = {1, 1, 1, 1, 1}
m = 5, arr2[] = {2, 2, 2, 2, 2}
Output: 1 2
Explanation: Distinct elements including 
both the arrays are: 1 2.
 * 
 * @author sukh
 *
 */
public class _6_UnionSortedArrays_1 {

  /**
   * NOTE: Two Pointer<br>
   * Time: O(n+m)<br>
   * Space: O(1)
   * @param a
   * @param b
   * @return
   */
  public List<Integer> union(int[] a, int[] b) {
    List<Integer> union = new ArrayList<>();

    int p1 = 0, p2 = 0, al = a.length, bl = b.length;

    while (p1 < al && p2 < bl) {
      if (a[p1] <= b[p2]) {
        if (union.isEmpty() || union.get(union.size() - 1) != a[p1]) {
          union.add(a[p1]);
        }
        p1++;
      } else {
        if (union.isEmpty() || union.get(union.size() - 1) != b[p2]) {
          union.add(b[p2]);
        }
        p2++;
      }
    }

    while (p1 < al) {
      if (union.get(union.size() - 1) != a[p1]) {
        union.add(a[p1]);
      }
      p1++;
    }

    while (p2 < bl) {
      if (union.get(union.size() - 1) != b[p2]) {
        union.add(b[p2]);
      }
      p2++;
    }

    return union;
  }

}
