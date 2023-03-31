package com.code.ds.striver.string;

/**
 * Knuth-Morris-Pratt Pattern Matching Algo.
 * 
 * @author sukh
 *
 */
public class _8_KMP_PatternMatchingAlgo {

  /**
   * Time: O(n+m) <br>
   * Space: O(m)
   * @param text
   * @param pattern
   */
  public void match(String text, String pattern) {
    int m = pattern.length();
    /**
     * longest prefix suffix array
     */
    int[] lps = new int[m];
    createLPS(pattern, lps);
    match(text, pattern, lps);
  }

  private void match(String text, String pattern, int[] lps) {
    int n = text.length();
    int m = pattern.length();
    int i = 0;
    int j = 0;

    while ((n - i) >= (m - j)) {
      if (pattern.charAt(j) == text.charAt(i)) {
        i++;
        j++;
      }
      if (j == m) {
        System.out.println("Pattern found in Text at index : " + (i - j));
        j = lps[j - 1];
      }
      /**
       * mismatch after j matches
       */
      else if (i < n && pattern.charAt(j) != text.charAt(i)) {
        /**
         * Do not match lps[0..lps[j-1]] characters, <br>
         * they will match anyway
         */
        if (j != 0) {
          j = lps[j - 1];
        } else {
          /**
           * increment i if j == 0
           */
          i++;
        }
      }
    }
  }

  private void createLPS(String pattern, int[] lps) {
    int m = pattern.length();
    int i = 1;
    int len = 0; // length of previous longest prefix suffix

    lps[0] = 0; // no prefix exists for the first character

    while (i < m) {
      if (pattern.charAt(i) == pattern.charAt(len)) {
        len++;
        lps[i] = len;
        i++;
      } else {
        /**
         * This is tricky. Consider the example. <br>
         * AAACAAAA and i = 7.
         */
        if (len != 0) {
          len = lps[len - 1];
          /**
           * Don't increment i
           */
        } else {
          lps[i] = len;
          i++;
          /**
           * if len == 0, increment i
           */
        }
      }
    }
  }

}
