package com.code.ds.striver.array;

public class _13_NumAppearOnce {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param arr
   * @return
   */
  public int search(int[] arr) {
    int once = 0;
    for (int i = 0; i < arr.length; i++) {
      once ^= arr[i];
    }
    return once;
  }

}
