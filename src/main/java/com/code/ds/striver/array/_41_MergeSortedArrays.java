package com.code.ds.striver.array;

import java.util.Arrays;

/**
 * Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order without using any extra space. Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.
 

Example 1:

Input: 
n = 4, arr1[] = [1 3 5 7] 
m = 5, arr2[] = [0 2 6 8 9]
Output: 
arr1[] = [0 1 2 3]
arr2[] = [5 6 7 8 9]
Explanation:
After merging the two 
non-decreasing arrays, we get, 
0 1 2 3 5 6 7 8 9.
Example 2:

Input: 
n = 2, arr1[] = [10, 12] 
m = 3, arr2[] = [5 18 20]
Output: 
arr1[] = [5 10]
arr2[] = [12 18 20]
Explanation:
After merging two sorted arrays 
we get 5 10 12 18 20.

Your Task:
You don't need to read input or print anything. You only need to complete the function merge() that takes arr1, arr2, n and m as input parameters and modifies them in-place so that they look like the sorted merged array when concatenated.
 

Expected Time Complexity:  O((n+m) log(n+m))
Expected Auxilliary Space: O(1)
 

Constraints:
1 <= n, m <= 105
0 <= arr1i, arr2i <= 107
 * 
 * @author sukh
 *
 */
public class _41_MergeSortedArrays {

  /**
   * NOTE:<br>
   * GAP Algorithm
   */

  /**
   * Time: O(n + m)<br>
   * Space: O(1)
   * @param a
   * @param b
   */
  public static void merge(int[] a, int[] b) {
    int l1 = a.length;
    int l2 = b.length;
    int gap = (int) Math.ceil((double) (l1 + l2) / 2.0);

    int i, j, temp;
    while (gap > 0) {
      i = 0;
      j = gap;
      while (j < l1 + l2) {
        if (i < l1 && j < l1 && a[i] > a[j]) {
          temp = a[i];
          a[i] = a[j];
          a[j] = temp;
        } else if (i < l1 && j >= l1 && a[i] > b[j - l1]) {
          temp = a[i];
          a[i] = b[j - l1];
          b[j - l1] = temp;
        } else if (i >= l1 && j >= l1 && b[i - l1] > b[j - l1]) {
          temp = b[i - l1];
          b[i - l1] = b[j - l1];
          b[j - l1] = temp;
        }

        i++;
        j++;
      }

      if (gap == 1) {
        gap = 0;
      } else {
        gap = (int) Math.ceil((double) (gap) / 2.0);
      }
    }
  }

  public static void main(String[] args) {
    int[] a = { 1, 3, 5, 7 };
    int[] b = { 0, 2, 6, 8, 9 };
    merge(a, b);
    System.out.println(Arrays.toString(a));
    System.out.println(Arrays.toString(b));
  }

}
