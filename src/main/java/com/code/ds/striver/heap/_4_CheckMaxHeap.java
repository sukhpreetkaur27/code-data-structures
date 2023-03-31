package com.code.ds.striver.heap;

/**
 * Given an array A of size N, the task is to check if the given array represents a Binary Max Heap.


Example 1:

Input:  arr[] = {90, 15, 10, 7, 12, 2}
Output: True
The given array represents below tree
       90
     /    \
   15      10
  /  \     /
7    12  2
The tree follows max-heap property as every
node is greater than all of its descendants.

Example 2:
Input:  arr[] = {9, 15, 10, 7, 12, 11}
Output: False
The given array represents below tree
       9
     /    \
   15      10
  /  \     /
7    12  11
The tree doesn't follows max-heap property 9 is
smaller than 15 and 10, and 10 is smaller than 11. 
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function isMaxHeap() which takes the array A[] 
and its size N as inputs and returns  "1", else print "0" (without quotes).


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 ≤ N ≤ 106
1 ≤ Ai ≤ 10
 * 
 * @author sukh
 *
 */
public class _4_CheckMaxHeap {

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * 
   * @param arr
   * @return
   */
  public boolean check(int arr[]) {
    int n = arr.length;
    int limit = (int) n >> 1;

    for (int index = 0, left = 0, right = 0; index < limit; index++) {
      /**
       * 0-based indexing
       */
      left = (index << 1) + 1;
      right = (index << 1) + 2;
      if ((left < n && arr[index] < arr[left])
          || (right < n && arr[index] < arr[right])) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    _4_CheckMaxHeap obj = new _4_CheckMaxHeap();
    int[] arr = { 20, 71, 69, 9 };
    System.out.println(obj.check(arr));
  }

}
