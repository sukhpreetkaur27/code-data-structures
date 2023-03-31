package com.code.ds.striver.string;

/**
 * Given a string s, return the number of homogenous substrings of s. Since the
 * answer may be too large, return it modulo 109 + 7.
 * 
 * A string is homogenous if all the characters of the string are the same.
 * 
 * A substring is a contiguous sequence of characters within a string.
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105 
 * 
 * s consists of lowercase letters.
 * 
 * @author sukh
 *
 */
public class _15_CountHomogenousSubstrings {

  /**
   * Homogenous Substrings: A string is homogenous if all the characters of the
   * string are the same. <br>
   * 
   * eg:
   * 
   * Input: s = "abbcccaa" Output: 13 Explanation: The homogenous substrings are
   * listed as below: "a" appears 3 times. "aa" appears 1 time. "b" appears 2
   * times. "bb" appears 1 time. "c" appears 3 times. "cc" appears 2 times. "ccc"
   * appears 1 time. 3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.
   * 
   * Input: s = "xy" Output: 2 Explanation: The homogenous substrings are "x" and
   * "y".
   * 
   * Input: s = "zzzzz" Output: 15
   */

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * @param s
   * @return
   */
  public int count(String s) {
    final int modulo = (int) 1e9 + 7;
    int res = 0;

    for (int i = 0, curr = 0, count = 0; i < s.length(); i++) {
      count = s.charAt(i) == curr ? count + 1 : 1;
      curr = s.charAt(i);
      res = (res + count) % modulo;
    }

    return res;
  }

}
