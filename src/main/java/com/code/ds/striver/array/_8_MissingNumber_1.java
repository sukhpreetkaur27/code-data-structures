package com.code.ds.striver.array;

/**
 * Example 1:

Input:                                                       
N = 4                                        
A[] = {1, 4, 3}
Output:
2     
Explanation:
Vaibhav placed 4 integers but he picked
up only 3 numbers. So missing number
will be 2 as it will become 1,2,3,4.
 

Example 2:

Input:                        
N = 5
A[] = {2, 5, 3, 1}
Output:
4
Explanation:
Vaibhav placed 5 integers on the board,
but picked up only 4 integers, so the
missing number will be 4 so that it
will become 1,2,3,4,5.
 * 
 * @author sukh
 *
 */
public class _8_MissingNumber_1 {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param arr
   * @param n
   * @return
   */
  public int missing(int[] arr, int n) {
    int miss = n;
    for (int i = 0; i < n - 1; i++) {
      miss ^= arr[i] ^ (i + 1);
    }
    return miss;
  }

}
