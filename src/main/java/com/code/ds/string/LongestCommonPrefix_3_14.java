package com.code.ds.string;

public class LongestCommonPrefix_3_14 {

  /**
   * Divide and Conquer<br>
   * Time: O(S); S = sum of all characters in all the strings<br>
   * Space: O(m * log n); There are log n recursive calls, each store need m space
   * to store the result.
   */
  public String longestCommonPrefix(String[] strs) {
    return longestCommonPrefix(strs, 0, strs.length);
  }

  /**
   * Divide<br>
   * @param strs
   * @param left
   * @param right
   * @return
   */
  private String longestCommonPrefix(String[] strs, int left, int right) {
    if (left == right) {
      return strs[left];
    }
    int mid = (left + right) / 2;
    String lcpLeft = longestCommonPrefix(strs, left, mid);
    String lcpRight = longestCommonPrefix(strs, mid + 1, right);

    return commonPrefix(lcpLeft, lcpRight);
  }

  /**
   * Conquer<br>
   * @param left
   * @param right
   * @return
   */
  private String commonPrefix(String left, String right) {
    int min = Math.min(left.length(), right.length());

    for (int i = 0; i < min; i++) {
      if (left.charAt(i) != right.charAt(i)) {
        return left.substring(0, i);
      }
    }
    return left.substring(0, min);
  }

}
