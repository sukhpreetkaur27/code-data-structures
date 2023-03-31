package com.code.ds.striver.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _6_UnionSortedArrays_2 {

  public static List<Integer> union(int[] a, int[] b) {
    Set<Integer> set = new HashSet<>();

    for (int i = 0; i < a.length; i++) {
      set.add(a[i]);
    }

    for (int i = 0; i < b.length; i++) {
      set.add(b[i]);
    }

    List<Integer> union = new ArrayList<>(set);
    return union;
  }

  public static void main(String[] args) {
    int arr1[] = { 5, 4, 3, 2, 1 };
    int arr2[] = { 1, 2, 3 };
    List<Integer> union = union(arr1, arr2);
    System.out.println(union.toString());
  }

}
