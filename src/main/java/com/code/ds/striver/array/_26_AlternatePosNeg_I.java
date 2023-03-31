package com.code.ds.striver.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an unsorted array Arr of N positive and negative numbers. 
 * Your task is to create an array of alternate positive and negative numbers without changing the relative order of positive and negative numbers.
Note: Array should start with a positive number.
 

Example 1:

Input: 
N = 9
Arr[] = {9, 4, -2, -1, 5, 0, -5, -3, 2}
Output:
9 -2 4 -1 5 -5 0 -3 2
Explanation : Positive elements : 9,4,5,0,2
Negative elements : -2,-1,-5,-3
As we need to maintain the relative order of
postive elements and negative elements we will pick
each element from the positive and negative and will
store them. If any of the positive and negative numbers
are completed. we will continue with the remaining signed
elements.The output is 9,-2,4,-1,5,-5,0,-3,2.

Example 2:

Input:
N = 10
Arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
Output:
5 -5 2 -2 4 -8 7 1 8 0
Explanation : Positive elements : 5,2,4,7,1,8,0
Negative elements : -5,-2,-8
As we need to maintain the relative order of
postive elements and negative elements we will pick
each element from the positive and negative and will
store them. If any of the positive and negative numbers
are completed. we will continue with the remaining signed
elements.The output is 5,-5,2,-2,4,-8,7,1,8,0.
Your Task:  

You don't need to read input or print anything. 
Your task is to complete the function rearrange() which takes the array of integers arr[] and n as parameters. You need to modify the array itself.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1 ≤ N ≤ 107
-106 ≤ Arr[i] ≤ 107
 * 
 * @author sukh
 *
 */
public class _26_AlternatePosNeg_I {

  /**
   * Time: O(n)<br>
   * Space: O(n)
   * @param arr
   */
  public static void modify(int[] arr) {
//    List<Integer> res = Arrays.stream(arr).boxed().collect(Collectors.toList());
    List<Integer> pos = new ArrayList<>();
    List<Integer> neg = new ArrayList<>();

    for (int num : arr) {
      if (num >= 0) {
//        res[p] = num;
        pos.add(num);
//        p += 2;
      } else {
//        res[n] = num;
        neg.add(num);
//        n += 2;
      }
    }
//    arr = res.stream().mapToInt(Integer::intValue).toArray();
    int k = 0;
    int p = 0;
    int n = 0;
    while (p < pos.size() && n < neg.size()) {
      arr[k++] = pos.get(p++);
      arr[k++] = neg.get(n++);
    }
    while (p < pos.size()) {
      arr[k++] = pos.get(p++);
    }
    while (n < neg.size()) {
      arr[k++] = neg.get(n++);
    }
  }

  public static void main(String[] args) {
    int arr[] = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
    modify(arr);
    System.out.println(Arrays.toString(arr));
  }

}
