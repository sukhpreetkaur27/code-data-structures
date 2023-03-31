package com.code.ds.striver.array;

/**
 * Given an array A of N elements. Find the majority element in the array. 
 * A majority element in an array A of size N is an element that appears more than N/2 times in the array.
 

Example 1:

Input:
N = 3 
A[] = {1,2,3} 
Output:
-1
Explanation:
Since, each element in 
{1,2,3} appears only once so there 
is no majority element.
Example 2:

Input:
N = 5 
A[] = {3,1,3,3,2} 
Output:
3
Explanation:
Since, 3 is present more
than N/2 times, so it is 
the majority element.
 * 
 * @author sukh
 *
 */
public class _20_MajorityElement_I {
  
  /**
   * NOTE: <br>
   * Boyer Moore's Voting Algorithm
   */

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param nums
   * @return
   */
  public int majority(int[] nums) {
    int n = nums.length;

    int candidate = 0;
    int count = 0;

    for (int num : nums) {
      if (count == 0) {
        candidate = num;
      }
      if (candidate == num) {
        count++;
      } else {
        count--;
      }
    }

    count = 0;
    for (int num : nums) {
      if (candidate == num) {
        count++;
      }
    }

    return count > (n / 2) ? candidate : -1;
  }

}
