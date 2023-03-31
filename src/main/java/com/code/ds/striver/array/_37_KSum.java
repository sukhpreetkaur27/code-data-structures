package com.code.ds.striver.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Similar to 4-Sum.
 * @author sukh
 *
 */
public class _37_KSum {

  /**
   * Time: O(n^(k-1))<br>
   * Space: O(n)
   * @param arr
   * @param target
   * @param k
   * @return
   */
  public List<List<Integer>> kSum(int[] arr, int target, int k) {
    Arrays.sort(arr);
    return kSum(arr, target, k, 0);
  }

  public List<List<Integer>> kSum(int[] arr, int target, int k, int start) {
    List<List<Integer>> res = new ArrayList<>();

    int n = arr.length;
    if (start == n) {
      return res;
    }

    long avg = target / k;
    if (arr[start] > avg || arr[n - 1] < avg) {
      return res;
    }

    if (k == 2) {
      return twoSum(arr, target, start);
    }

    for (int i = start; i < n; i++) {
      if (i == start || arr[i] != arr[i - 1]) {
        for (List<Integer> subset : kSum(arr, target - arr[i], k - 1, i + 1)) {
          res.add(new ArrayList<>(Arrays.asList(arr[i])));
          res.get(res.size() - 1).addAll(subset);
        }
      }
    }

    return res;
  }

  private List<List<Integer>> twoSum(int[] arr, int target, int start) {
    List<List<Integer>> res = new ArrayList<>();
    int n = arr.length;
    int lo = start;
    int hi = n - 1;
    while (lo < hi) {
      int s = arr[lo] + arr[hi];
      if (s < target || (lo > start && arr[lo] == arr[lo - 1])) {
        lo++;
      } else if (s > target || (hi < n - 1 && arr[hi] == arr[hi + 1])) {
        hi--;
      } else {
        res.add(Arrays.asList(arr[lo], arr[hi]));
        lo++;
        hi--;
      }
    }
    return res;
  }

}
