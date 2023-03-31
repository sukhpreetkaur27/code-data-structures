package com.code.ds.binarySearchTree;

import java.util.TreeSet;

public class ContainsDuplicate_1_220 {

  /**
   * Time: O(n * log (min(n, k)))<br>
   * Space: O(min(n,k))
   * @param arr
   * @param indexDiff
   * @param valueDiff
   * @return
   */
  public boolean containsNearByDuplicate(int[] arr, int indexDiff, int valueDiff) {
    TreeSet<Integer> tree = new TreeSet<>();

    Integer smallest, largest;
    for (int i = 0; i < arr.length; i++) {
      /**
       * Find the successor
       */
      smallest = tree.ceiling(arr[i]);
      if (smallest != null && smallest <= (long) arr[i] + valueDiff) {
        return true;
      }

      /**
       * Find the predecessor
       */
      largest = tree.floor(arr[i]);
      if (largest != null && largest >= arr[i] - valueDiff) {
        return true;
      }

      tree.add(arr[i]);
      if (tree.size() > indexDiff) {
        /**
         * Remove the oldest element
         */
        tree.remove(arr[i - indexDiff]);
      }
    }

    return false;
  }

}
