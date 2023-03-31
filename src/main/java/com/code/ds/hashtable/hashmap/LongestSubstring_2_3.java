package com.code.ds.hashtable.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 * @author sukh
 *
 */
public class LongestSubstring_2_3 {

  /**
   * Time: O(n)<br>
   * Space: O(min(n,m))<br>
   * We need O(k) space for checking a substring has no duplicate characters,
   * where k is the size of the Set.<br>
   * The size of the Set is upper bounded by the size of the string n and the size
   * of the charset/alphabet m.
   * @param s
   * @return
   */
  public int getLongestSubstring(String s) {
    int res = 0;

    /**
     * NOTE:<br>
     * If we know that the charset is rather small, we can mimic what a
     * HashSet/HashMap does with a boolean/integer array as direct access table.
     * Though the time complexity of query or insertion is still O(1)O(1), the
     * constant factor is smaller in an array than in a HashMap/HashSet. Thus, we
     * can achieve a shorter runtime by the replacement here.
     * 
     * Commonly used tables are:
     * 
     * int[26] for Letters 'a' - 'z' or 'A' - 'Z' <br>
     * int[128] for ASCII <br>
     * int[256] for Extended ASCII
     * 
     */
    Map<Character, Integer> char_index = new HashMap<>();

    int left = 0;
    int right = 0;
    int len = s.length();
    Integer index = null;

    while (right < len) {
      char ch_r = s.charAt(right);

      index = char_index.get(ch_r);
      if (index != null && index >= left) {
        left = index + 1;
      }

      char_index.put(ch_r, right);

      res = Math.max(res, right - left + 1);
      right++;
    }

    return res;
  }

}
