package com.code.ds.striver.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an array arr[] and an integer K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. 
 * It is given that all array elements are distinct.

Example 1:

Input:
N = 6
arr[] = 7 10 4 3 20 15
K = 3
Output : 7
Explanation :
3rd smallest element in the given 
array is 7.
Example 2:

Input:
N = 5
arr[] = 7 10 4 20 15
K = 4
Output : 15
Explanation :
4th smallest element in the given 
array is 15.
Your Task:
You don't have to read input or print anything. Your task is to complete the function kthSmallest() which takes the array arr[], 
integers l and r denoting the starting and ending index of the array and an integer K as input and returns the Kth smallest element.
 
 
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(log(n))
Constraints:
1 <= N <= 105
1 <= arr[i] <= 105
1 <= K <= N
 * 
 * @author sukh
 *
 */
public class _10_KthSmallest {
  
  /**
   * NOTE: check Quick select solution also
   */

  /**
   * Time: O(n log k) <br>
   * Space: O(k)
   * 
   * @param nums
   * @param k
   * @return
   */
  public int findKthSmallest(int[] nums, int k) {
    /**
     * maintain a max-heap of size k
     */
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
    int n = nums.length;
    for (int i = 0, top = 0; i < n; i++) {
      if (i < k) {
        maxHeap.offer(nums[i]);
      } else {
        top = maxHeap.peek();
        if (top > nums[i]) {
          maxHeap.poll();
          maxHeap.offer(nums[i]);
        }
      }
    }
    return maxHeap.peek();
  }

}
