package com.code.ds.striver.heap;

/**
 * Given an array A of size N, the task is to check if the given array represents a Binary Min Heap.
 * 
 * @author sukh
 *
 */
public class _6_CheckMinHeap {

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * 
   * @param arr
   * @return
   */
  public boolean check(int arr[]) {
    int n = arr.length;
    int limit = n >> 1;

    for (int index = 0, left = 0, right = 0; index < limit; index++) {
      /**
       * 0-based indexing
       */
      left = (index << 1) + 1;
      right = (index << 1) + 2;
      if ((left < n && arr[index] > arr[left])
          || (right < n && arr[index] > arr[right])) {
        return false;
      }
    }

    return true;
  }

}
