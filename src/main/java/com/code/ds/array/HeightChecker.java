package com.code.ds.array;

public class HeightChecker {

  /**
   * Time: (n log n)<br>
   * Space: O(1)
   * @param arr
   * @return
   */
  public int check(int[] arr) {
    int count = 0;
    int size = arr.length;
    int[] heights = arr.clone();

    /**
     * Time: O(n log n)
     */
    quicksort(heights, 0, size - 1);

    /**
     * Time: O(n)
     */
    for (int i = 0; i < size; i++) {
      if (arr[i] != heights[i]) {
        count++;
      }
    }
    return count;
  }

  private void quicksort(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }

    int pivotIndex = (right + left) / 2;
    pivotIndex = partition(arr, left, right, pivotIndex);

    quicksort(arr, left, pivotIndex - 1);
    quicksort(arr, pivotIndex + 1, right);
  }

  private int partition(int[] arr, int left, int right, int pivotIndex) {
    int pivot = arr[pivotIndex];

    swap(arr, pivotIndex, right);

    int index = left;
    for (int i = index; i < right; i++) {
      if (arr[i] <= pivot) {
        swap(arr, index, i);
        index++;
      }
    }

    swap(arr, index, right);
    return index;
  }

  private void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }

}
