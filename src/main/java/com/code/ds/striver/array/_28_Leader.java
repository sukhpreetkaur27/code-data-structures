package com.code.ds.striver.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an array A of positive integers. Your task is to find the leaders in the array. An element of array is leader if it is greater than or equal to all the elements to its right side. The rightmost element is always a leader. 

 

Example 1:

Input:
n = 6
A[] = {16,17,4,3,5,2}
Output: 17 5 2
Explanation: The first leader is 17 
as it is greater than all the elements
to its right.  Similarly, the next 
leader is 5. The right most element 
is always a leader so it is also 
included.
 

Example 2:

Input:
n = 5
A[] = {1,2,3,4,0}
Output: 4 0
 

Your Task:
You don't need to read input or print anything. The task is to complete the function leader() which takes array A and n as input parameters and returns an array of leaders in order of their appearance.

 

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

 

Constraints:
1 <= n <= 107
0 <= Ai <= 107
 * 
 * @author sukh
 *
 */
public class _28_Leader {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param arr
   * @return
   */
  public List<Integer> leader(int[] arr) {
    List<Integer> res = new ArrayList<>();
    int n = arr.length;
    res.add(arr[n - 1]);
    int max = arr[n - 1];
    for (int a : arr) {
      if (a >= max) {
        res.add(a);
        max = a;
      }
    }
    Collections.reverse(res);
    return res;
  }

}
