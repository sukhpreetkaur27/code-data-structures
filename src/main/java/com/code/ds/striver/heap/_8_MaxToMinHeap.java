package com.code.ds.striver.heap;

/**
 *  You are given an array arr of N integers representing a max Heap. The task is to convert it to min Heap.
 * 
 * @author sukh
 *
 */
public class _8_MaxToMinHeap {

  /**
   * Time: O(n * log n) <br>
   * Space: O(1)
   * 
   * @param n
   * @param arr
   */
  static void convertMaxToMinHeap(int n, int arr[]) {
    /**
     * above leaf nodes
     */
    int limit = (n >> 1) - 1;
    for (int i = limit; i >= 0; i--) {
      minHeapify(arr, n, i);
    }
  }

  static void minHeapify(int arr[], int size, int index) {
    int left = (index << 1) + 1;
    int right = (index << 1) + 2;
    int min = index;

    if (left < size && arr[index] > arr[left]) {
      min = left;
    }
    if (right < size && arr[min] > arr[right]) {
      min = right;
    }
    if (min != index) {
      int temp = arr[index];
      arr[index] = arr[min];
      arr[min] = temp;
      minHeapify(arr, size, min);
    }
  }

}
