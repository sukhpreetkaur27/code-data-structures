package com.code.ds.array;

public class DuplicateZeros {

  /**
   * Time:O(n)<br>
   * Space:O(1)
   * @param arr
   */
  public void duplicateZeros(int[] arr) {
    int length = arr.length - 1;
    int dupZeros = 0;

    for (int left = 0; left <= length - dupZeros; left++) {
      if (arr[left] == 0) {
        /*
         * edge case (in-place): if the last element is 0, we don't duplicate it; it
         * marks the end of the window to be copied
         */
        if (left == length - dupZeros) {
          arr[length] = 0;
          // new length to be worked upon
          length--;
          break;
        }
        dupZeros++;
      }
    }

    int last = length - dupZeros;
    for (int i = last; i >= 0; i--) {
      if (arr[i] == 0) {
        arr[i + dupZeros] = 0;
        dupZeros--;
        arr[i + dupZeros] = 0;
      } else {
        arr[i + dupZeros] = arr[i];
      }
    }
  }

}
