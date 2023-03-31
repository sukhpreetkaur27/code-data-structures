package com.code.ds.striver.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array arr of N integers and an integer K, find the number of subsets of arr having XOR of elements as K.
 

Example 1:

Input:
N = 4
k = 6
arr: 6 9 4 2
Output:
2
Explanation:
The subsets are 
{4,2} and {6}
Example 2:

Input:
N = 5
K = 4
arr: 1 2 3 4 5
Output:
4
Explanation:
The subsets are {1, 5},
{4}, {1, 2, 3, 4},
and {2, 3, 5}

 * 
 * @author sukh
 *
 */
public class _39_SubsetsWithXOR {

  /**
   * Time: O(n)<br>
   * Space: O(n)
   * @param arr
   * @param k
   * @return
   */
  public static int subset(int[] arr, int k) {
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0, xor = 0; i < arr.length; i++) {
      xor ^= arr[i];

      if (map.containsKey(xor ^ k)) {
        count += map.get(xor ^ k);
      }
      if (xor == k) {
        count++;
      }

      map.put(xor, map.getOrDefault(xor, 0) + 1);
    }
    return count;
  }

  public static void main(String[] args) {
    int[] arr = { 6, 9, 4, 2 };
    int k = 6;
    System.out.println(subset(arr, k));
  }

}
