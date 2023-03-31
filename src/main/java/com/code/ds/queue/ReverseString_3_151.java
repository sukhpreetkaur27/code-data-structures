package com.code.ds.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

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
 

Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 * @author sukh
 *
 */
public class ReverseString_3_151 {

  /**
   * Time: O(n)<br>
   * Space: O(n)
   * @param s
   * @return
   */
  public String reverse(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left <= right && s.charAt(left) == ' ') {
      left++;
    }

    while (left <= right && s.charAt(right) == ' ') {
      right--;
    }

    Deque<String> words = new ArrayDeque<>();

    StringBuilder word = new StringBuilder();
    char ch;
    while (left <= right) {
      ch = s.charAt(left);
      if (ch != ' ') {
        word.append(ch);
      } else if (word.length() != 0 && ch == ' ') {
        words.offerFirst(word.toString());
        word.setLength(0);
      }

      left++;
    }

    words.offerFirst(word.toString());
    return String.join(" ", words);
  }

}
