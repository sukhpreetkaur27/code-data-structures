package com.code.ds.string;

public class ReverseString_2_151 {

  public String reverse(String s) {
    /**
     * Trim String
     */
    StringBuilder sb = trim(s);
    /**
     * Reverse String
     */
    reverse(sb, 0, sb.length() - 1);
    /**
     * Reverse Each Word
     */
    reverseEachWord(sb);
    return sb.toString();
  }

  private void reverseEachWord(StringBuilder sb) {
    int left = 0;
    int right = 0;
    int n = sb.length() - 1;

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
    char temp;
    while (left < right) {
      temp = sb.charAt(left);
      sb.setCharAt(left++, sb.charAt(right));
      sb.setCharAt(right--, temp);
    }
  }

  private StringBuilder trim(String s) {
    int left = 0;
    int right = s.length() - 1;

    /**
     * removing leading white spaces
     */
    while (left <= right && s.charAt(left) == ' ') {
      left++;
    }

    /**
     * removing trailing white spaces
     */
    while (left <= right && s.charAt(right) == ' ') {
      right--;
    }

    StringBuilder sb = new StringBuilder();
    char ch;
    while (left <= right) {
      ch = s.charAt(left);

      if (ch != ' ') {
        /**
         * appending characters
         */
        sb.append(ch);
      } else if (sb.charAt(sb.length() - 1) != ' ') {
        /**
         * removing double spaces b/w words
         */
        sb.append(ch);
      }
      left++;
    }
    return sb;
  }

}
