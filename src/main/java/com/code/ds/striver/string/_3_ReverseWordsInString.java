package com.code.ds.striver.string;

/**
 * Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. 
The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
 * 
 * @author sukh
 *
 */
public class _3_ReverseWordsInString {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * @param s
   * @return
   */
  public String reverse(String s) {
    /**
     * Algo: <br>
     * 1. Trim Spaces --> Single Space delimited String <br>
     * 2. Reverse String <br>
     * 3. Reverse each word
     */

    StringBuilder sb = trim(s);

    reverse(sb, 0, sb.length() - 1);

    reverseEachWord(sb);

    return sb.toString();
  }

  private void reverseEachWord(StringBuilder sb) {
    int n = sb.length();
    int left = 0;
    int right = 0;

    while (left < n) {
      while (right < n && sb.charAt(right) != ' ') {
        right++;
      }

      reverse(sb, left, right - 1);

      right++;
      left = right;
    }
  }

  private void reverse(StringBuilder sb, int left, int right) {
    while (left < right) {
      char temp = sb.charAt(left);
      sb.setCharAt(left++, sb.charAt(right));
      sb.setCharAt(right--, temp);
    }
  }

  private StringBuilder trim(String s) {
    StringBuilder sb = new StringBuilder();

    int left = 0;
    int right = s.length() - 1;
    /**
     * Remove leading spaces
     */
    while (left <= right && s.charAt(left) == ' ') {
      left++;
    }

    /**
     * Remove trailing spaces
     */
    while (right >= left && s.charAt(right) == ' ') {
      right--;
    }

    /**
     * Single space delimited words
     */
    while (left <= right) {
      char ch = s.charAt(left);

      if (ch != ' ') {
        sb.append(ch);
      } else if (sb.charAt(sb.length() - 1) != ' ') {
        sb.append(ch);
      }

      left++;
    }

    return sb;
  }

}
