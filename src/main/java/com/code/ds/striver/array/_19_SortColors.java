package com.code.ds.striver.array;

/**
 * Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.


Example 1:

Input: 
N = 5
arr[]= {0 2 1 2 0}
Output:
0 0 1 2 2
Explanation:
0s 1s and 2s are segregated 
into ascending order.
Example 2:

Input: 
N = 3
arr[] = {0 1 0}
Output:
0 0 1
Explanation:
0s 1s and 2s are segregated 
into ascending order.
 * 
 * @author sukh
 *
 */
public class _19_SortColors {
  
  /**
   * NOTE: <br>
   * Dutch National Flag Problem
   */

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param a
   */
  public void sort012(int[] a) {
    int l = 0, r = a.length - 1, c = 0;

    while (c <= r) {
      switch (a[c]) {
        case 0:
          swap(a, l, c);
          l++;
          c++;
          break;
        case 1:
          c++;
          break;
        case 2:
          swap(a, r, c);
          r--;
          break;
      }
    }
  }

  private void swap(int[] a, int l, int r) {
    int temp = a[l];
    a[l] = a[r];
    a[r] = temp;
  }
}
