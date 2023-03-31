package com.code.ds.striver.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array and a sum k, generate the subarray whose elements sum to max.

 * 
 * @author sukh
 *
 */
public class _22_MaximumSubArraySum_II {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param arr
   * @return
   */
  public static int[] maxSum(int[] arr) {
    int sum = 0;
    int max = 0;
    int start = 0;
    int newStart = 0;
    int end = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];

      if (sum > max) {
        max = Math.max(max, sum);
        start = newStart;
        end = i;
      }
      if (sum < 0) {
        sum = 0;
        newStart = i + 1;
      }
    }

    List<Integer> subArray = new ArrayList<>();
    for (int i = start; i <= end; i++) {
      subArray.add(arr[i]);
    }

    return subArray.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {
    int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    int[] res = maxSum(arr);
    System.out.println(Arrays.toString(res));
  }

}
