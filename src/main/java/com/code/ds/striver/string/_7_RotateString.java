package com.code.ds.striver.string;

/**
 * Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.
 

Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false
 

Constraints:

1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters.
 * 
 * @author sukh
 *
 */
public class _7_RotateString {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * @param s
   * @param goal
   * @return
   */
  public boolean rotate(String s, String goal) {
    if (s.length() != goal.length()) {
      return false;
    }
    if (s.equals(goal)) {
      return true;
    }
    /**
     * NOTE: <br>
     * goal is a rotation of s, iff, goal exists in s.concat(s)
     */
    String text = s.concat(s);

    int m = goal.length();

    /**
     * Use KMP Pattern Matching Algo
     */
    int[] lps = new int[m];
    createLPS(goal, lps);

    boolean match = match(text, goal, lps);

    return match;
  }

  private boolean match(String text, String pattern, int[] lps) {
    int i = 0;
    int j = 0;
    int n = text.length();
    int m = pattern.length();

    while ((n - i) >= (m - j)) {
      if (pattern.charAt(j) == text.charAt(i)) {
        i++;
        j++;
      } else if (j != 0) {
        j = lps[j - 1];
      } else {
        i++;
      }
      if (j == m) {
        return true;
      }
    }
    return false;
  }

  private void createLPS(String pattern, int[] lps) {
    int m = pattern.length();
    lps[0] = 0;
    int i = 1;
    int len = 0; // length of previous longest prefix suffix
    while (i < m) {
      if (pattern.charAt(i) == pattern.charAt(len)) {
        len++;
        lps[i] = len;
        i++;
      } else {
        if (len != 0) {
          len = lps[len - 1];
          /**
           * don't increment i
           */
        } else {
          lps[i] = len;
          i++;
        }
      }
    }
  }

}
