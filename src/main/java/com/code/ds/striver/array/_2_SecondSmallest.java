package com.code.ds.striver.array;

/**
 * Example 1:
Input: [1,2,4,7,7,5]
Output: Second Smallest : 2
  Second Largest : 5
Explanation: The elements are as follows 1,2,3,5,7,7 and hence second largest of these is 5 and second smallest is 2
 * 
 * @author sukh
 *
 */
public class _2_SecondSmallest {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param arr
   * @return
   */
  public int secondSmallest(int[] arr) {
    int min = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < min) {
        min2 = min;
        min = arr[i];
      } else if (arr[i] < min2 && arr[i] != min) {
        min2 = arr[i];
      }
    }
    return min2;
  }

}
