package com.code.ds.striver.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _12_SubArraySumEqualsK_II {

  public static int[][] subArray(int[] arr, int k) {
    List<List<Integer>> list = new ArrayList<>();
    Map<Integer, Integer> sumIndexMap = new HashMap<>();
    sumIndexMap.put(0, -1);

    int prefixSum = 0;
    for (int i = 0, start = 0, end = 0; i < arr.length; i++) {
      prefixSum += arr[i];

      if (sumIndexMap.containsKey(prefixSum - k)) {
        List<Integer> subList = new ArrayList<>();
        start = sumIndexMap.get(prefixSum - k) + 1;
        end = i;
        subList.add(start);
        subList.add(end);
        list.add(subList);
      }
      sumIndexMap.put(prefixSum, sumIndexMap.getOrDefault(prefixSum, 0) + 1);
    }

    int[][] res = new int[list.size()][];
    int l = 0;
    for (List<Integer> sub : list) {
      int start = sub.get(0);
      int end = sub.get(1);
      int[] res1 = new int[end - start + 1];
      for (int i = start, j = 0; i <= end; i++, j++) {
        res1[j] = arr[i];
      }
      res[l] = res1;
      l++;
    }

    return res;
  }

  public static void main(String[] args) {
    int arr[] = { 1, 9, 3, 7 };
    int k = 10;
    for (int[] res : subArray(arr, k)) {
      System.out.println(Arrays.toString(res));
    }
  }

}
