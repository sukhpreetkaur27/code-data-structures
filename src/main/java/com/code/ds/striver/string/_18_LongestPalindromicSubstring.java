package com.code.ds.striver.string;

/**
 * Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
 * 
 * @author sukh
 *
 */
public class _18_LongestPalindromicSubstring {

  /**
   * Time: O(n^2) <br>
   * Space: O(1)
   * @param s
   * @return
   */
  public String substring(String s) {
    if (s == null || s.length() < 1) {
      return "";
    }
    /**
     * for a palindrome, if we expand from the centre we get similar characters on
     * both sides
     * 
     * therefore, assume each index as a centre of a palindrome
     * 
     * odd length = centre is unique
     * 
     * even length = same characters on both sides
     */
    int maxLen = -1;
    int start = 0;
    for (int i = 0, odd_len = 0, even_len = 0, len = 0; i < s.length(); i++) {
      /**
       * odd length palindrome
       */
      odd_len = expand(s, i, i);
      /**
       * even length palindrome
       */
      even_len = expand(s, i, i + 1);

      len = Math.max(odd_len, even_len);

      if (len > maxLen) {
        maxLen = len;
        /**
         * NOTE: i is the centre
         * 
         * for odd length, we have to move equal no. of characters from centre on both
         * sides
         * 
         * for even length, we have to move len/2 characters towards the right and
         * (len-1)/2 characters towards the left
         */
        start = i - (len - 1) / 2;
      }
    }

    return s.substring(start, start + maxLen);
  }

  private int expand(String s, int start, int end) {
    while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
      start--;
      end++;
    }
    return end - start - 1;
  }

}
