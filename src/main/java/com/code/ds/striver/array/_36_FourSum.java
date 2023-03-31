package com.code.ds.striver.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _36_FourSum {

  /**
   * Time: O(n^3)<br>
   * Space: O(1)
   * @param arr
   * @param target
   * @return
   */
  public static List<List<Integer>> fourSum(int[] arr, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(arr);
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      if (i == 0 || arr[i] != arr[i - 1]) {
        for (int j = i + 1; j < n; j++) {
          if (j == i + 1 || arr[j] != arr[j - 1]) {
            long sum = arr[i] + arr[j];
            long rem = target - sum;

            int lo = j + 1;
            int hi = n - 1;
            while (lo < hi) {
              int s = arr[lo] + arr[hi];
              if (s < rem || (lo > j + 1 && arr[lo] == arr[lo - 1])) {
                lo++;
              } else if (s > rem || (hi < n - 1 && arr[hi] == arr[hi + 1])) {
                hi--;
              } else {
                res.add(Arrays.asList(arr[i], arr[j], arr[lo], arr[hi]));

                lo++;
                hi--;
              }
            }

          }
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
//    int[] arr = { 1, 0, -1, 0, -2, 2 };
//    int target = 0;

    int[] arr = { 1000000000, 1000000000, 1000000000, 1000000000 };
    int target = -294967296;
    for (List<Integer> list : fourSum(arr, target)) {
      System.out.println(list.toString());
    }
  }

}
