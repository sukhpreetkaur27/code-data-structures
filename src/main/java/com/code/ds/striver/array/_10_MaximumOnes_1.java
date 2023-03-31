package com.code.ds.striver.array;

/**
 * Example 1:

Input:
N = 3
arr[] = {1, 0, 1}
M = 1
Output:
3
Explanation:
Maximum subarray is of size 3
which can be made subarray of all 1 after
flipping two zeros to 1.
Example 2:

Input:
N = 11
arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
M = 2
Output:
8
Explanation:
Maximum subarray is of size 8
which can be made subarray of all 1 after
flipping two zeros to 1.
 * 
 * @author sukh
 *
 */
public class _10_MaximumOnes_1 {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param arr
   * @param n
   * @param m
   * @return
   */

  public static int findMaxOnes(int[] arr, int m) {
    int size = arr.length;
    int max = 0;
    int left = 0, right = 0, zero = 0;
    while (right < size) {
      if (arr[right] == 0) {
        zero++;
      }
      while (zero > m) {
        if (arr[left] == 0) {
          zero--;
        }
        left++;
      }
      max = Math.max(max, right - left + 1);
      right++;
    }
    return max;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1 };
    int m = 2;
    System.out.println(findMaxOnes(arr, m));
  }

}
