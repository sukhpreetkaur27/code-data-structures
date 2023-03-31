package com.code.ds.striver.array;

/**
 * Given an array, find maximum sum of smallest and second smallest elements chosen from all possible sub-arrays. 
 * More formally, if we write all (nC2) sub-arrays of array of size >=2 and find the sum of smallest and second smallest, then our answer will be maximum sum among them.
 

Example 1:

Input : arr[] = [4, 3, 1, 5, 6]
Output : 11
Subarrays with smallest and 
second smallest are,
[4, 3]        
smallest = 3    second smallest = 4
[4, 3, 1]    
smallest = 1    second smallest = 3
[4, 3, 1, 5]    
smallest = 1    second smallest = 3
[4, 3, 1, 5, 6]    
smallest = 1    second smallest = 3
[3, 1]         
smallest = 1    second smallest = 3
[3, 1, 5]     
smallest = 1    second smallest = 3
[3, 1, 5, 6]    
smallest = 1    second smallest = 3
[1, 5]        
smallest = 1    second smallest = 5
[1, 5, 6]    
smallest = 1    second smallest = 5
[5, 6]         
smallest = 5    second smallest = 6
Maximum sum among all 
above choices is, 5 + 6 = 11
 
Example 2:
Input : arr[] = {5, 4, 3, 1, 6} 
Output : 9
 * 
 * @author sukh
 *
 */
public class _23_MaximumSubArraySum_II {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param arr
   * @return
   */
  public int maxSum(int[] arr) {
    int max = 0;
    for (int i = 1; i < arr.length; i++) {
      max = Math.max(arr[i] + arr[i - 1], max);
    }
    return max;
  }

}
