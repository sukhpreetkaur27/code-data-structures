package com.code.ds.binarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays.

 

Example 1:

Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
Output: [1,5]
Explanation: Only 1 and 5 appeared in the three arrays.
Example 2:

Input: arr1 = [197,418,523,876,1356], arr2 = [501,880,1593,1710,1870], arr3 = [521,682,1337,1395,1764]
Output: []
 

Constraints:

1 <= arr1.length, arr2.length, arr3.length <= 1000
1 <= arr1[i], arr2[i], arr3[i] <= 2000
 * @author sukh
 *
 */
public class IntersectionOf3SortedArrays_1_1213 {

  /**
   * Time: O(n)<br>
   * Space: O(n)
   * @param arr1
   * @param arr2
   * @param arr3
   * @return
   */
  public List<Integer> intersection(int[] arr1, int[] arr2, int[] arr3) {
    List<Integer> res = new ArrayList<>();

    /**
     * NOTE: that HashMap won't work here as it does not guarantee the key orders
     */
    Map<Integer, Integer> map = new TreeMap<>();

    for (int i : arr1) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    for (int i : arr2) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    for (int i : arr3) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    for (Integer key : map.keySet()) {
      if (map.get(key) == 3) {
        res.add(key);
      }
    }

    return res;
  }

}
