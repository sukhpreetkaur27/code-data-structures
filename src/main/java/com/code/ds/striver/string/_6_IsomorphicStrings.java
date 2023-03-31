package com.code.ds.striver.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters.
 No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
 * 
 * @author sukh
 *
 */
public class _6_IsomorphicStrings {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * @param s
   * @param t
   * @return
   */
  public boolean check(String s, String t) {
    /**
     * Constraint: s.length() == t.length()
     */

    Map<Character, Character> s_t = new HashMap<>();
    Map<Character, Character> t_s = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char s_char = s.charAt(i);
      char t_char = t.charAt(i);

      if (s_t.get(s_char) == null && t_s.get(t_char) == null) {
        s_t.put(s_char, t_char);
        t_s.put(t_char, s_char);
      } else if (s_t.get(s_char) != null && t_s.get(t_char) != null) {
        if (s_t.get(s_char) != t_char || t_s.get(t_char) != s_char) {
          return false;
        }
      } else {
        return false;
      }
    }
    return true;
  }

}
