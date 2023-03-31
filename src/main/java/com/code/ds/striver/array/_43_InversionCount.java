package com.code.ds.striver.array;

import java.util.Arrays;

/**
 * Given an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 

Example 1:

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 
has three inversions (2, 1), (4, 1), (4, 3).
Example 2:

Input: N = 5
arr[] = {2, 3, 4, 5, 6}
Output: 0
Explanation: As the sequence is already 
sorted so there is no inversion count.
Example 3:

Input: N = 3, arr[] = {10, 10, 10}
Output: 0
Explanation: As all the elements of array 
are same, so there is no inversion count.
Your Task:
You don't need to read input or print anything. Your task is to complete the function inversionCount() which takes the array arr[] and the size of the array as inputs and returns the inversion count of the given array.

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 5*105
1 ≤ arr[i] ≤ 1018
 * 
 * @author sukh
 *
 */
public class _43_InversionCount {

  /**
   * Time: O(n log n)<br>
   * Space: O(n)
   * @param arr
   * @return
   */
  public int mergeSort(int[] arr) {
    return mergeSort(arr, new int[arr.length], 0, arr.length - 1);
  }

  private int mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
    int invCount = 0;

    if (rightEnd > leftStart) {
      int middle = (leftStart + rightEnd) / 2;
      invCount += mergeSort(arr, temp, leftStart, middle);
      invCount += mergeSort(arr, temp, middle + 1, rightEnd);
      invCount += mergeHalves(arr, temp, leftStart, middle, rightEnd);
    }

    return invCount;
  }

  private int mergeHalves(int[] arr, int[] temp, int leftStart, int middle, int rightEnd) {
    int invCount = 0;
    int left = leftStart;
    int right = middle + 1;
    int index = leftStart;

    while (left <= middle && right <= rightEnd) {
      if (arr[left] <= arr[right]) {
        temp[index] = arr[left];
        left++;
      } else {
        invCount += middle - left + 1;
        temp[index] = arr[right];
        right++;
      }
      index++;
    }

    while (left <= middle) {
      temp[index] = arr[left];
      left++;
      index++;
    }

    while (right <= rightEnd) {
      temp[index] = arr[right];
      right++;
      index++;
    }

    // Copy from temp to the original array half
    while (leftStart <= rightEnd) {
      arr[leftStart] = temp[leftStart];
      leftStart++;
    }
    return invCount;
  }

  public static void main(String[] args) {
    _43_InversionCount obj = new _43_InversionCount();
    int arr[] = { 2, 4, 1, 3, 5 };
    System.out.println(obj.mergeSort(arr));
    System.out.println(Arrays.toString(arr));
  }

}
