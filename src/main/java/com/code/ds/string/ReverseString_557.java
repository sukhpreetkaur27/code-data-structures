package com.code.ds.string;

/**
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "God Ding"
Output: "doG gniD"
 

Constraints:

1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.
 * @author sukh
 *
 */
public class ReverseString_557 {

  /**
   * Time: O(n)<br>
   * Space: O(n)
   * @param s
   * @return
   */
  public String reverse(String s) {
    char[] ch = s.toCharArray();
    int len = s.length();

    int start = 0;
    int end = 0;
    while (start < len) {
      while (end < len && ch[end] != ' ') {
        end++;
      }
      reverse(ch, start, end - 1);
      end++;
      start = end;
    }
    return new String(ch);
  }

  private void reverse(char[] ch, int start, int end) {
    char temp;
    while (start < end) {
      temp = ch[start];
      ch[start++] = ch[end];
      ch[end--] = temp;
    }
  }

}
