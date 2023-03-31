package com.code.ds.hashtable.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

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
 * @author sukh
 *
 */
public class IsomorphicStrings_205 {

  /**
   * Time: O(s)<br>
   * Space: O(s + t)
   * @param s
   * @param t
   * @return
   */
  public boolean isIsomorphic(String s, String t) {
    /**
     * This is part of the constraint.
     */
//    if (s.length() != t.length()) {
//      return false;
//    }

    Map<Character, Character> s_t_map = new HashMap<>();
    Map<Character, Character> t_s_map = new HashMap<>();

    char c1, c2;
    for (int i = 0; i < s.length(); i++) {
      c1 = s.charAt(i);
      c2 = t.charAt(i);

      if (s_t_map.get(c1) == null && t_s_map.get(c2) == null) {
        s_t_map.put(c1, c2);
        t_s_map.put(c2, c1);
      } else if (s_t_map.get(c1) != null && t_s_map.get(c2) != null) {
        if (s_t_map.get(c1) != c2 || t_s_map.get(c2) != c1) {
          return false;
        }
      } else {
        return false;
      }
    }
    return true;
  }

}
