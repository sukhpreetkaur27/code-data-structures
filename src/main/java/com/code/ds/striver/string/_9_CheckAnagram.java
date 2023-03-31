package com.code.ds.striver.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
Ans: Use hashmap
 * 
 * @author sukh
 *
 */
public class _9_CheckAnagram {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * @param s
   * @param t
   * @return
   */
  public boolean check(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    if (s.equals(t)) {
      return true;
    }

    Map<Character, Integer> s_freq = new HashMap<>();
    char ch;
    for (int i = 0; i < s.length(); i++) {
      ch = s.charAt(i);
      s_freq.put(ch, s_freq.getOrDefault(ch, 0) + 1);
    }

    for (int i = 0; i < t.length(); i++) {
      ch = t.charAt(i);
      Integer freq = s_freq.get(ch);
      if (freq == null || freq == 0) {
        return false;
      } else {
        s_freq.put(ch, freq - 1);
      }
    }

    return true;
  }

}
