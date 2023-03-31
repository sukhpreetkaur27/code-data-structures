package com.code.ds.striver.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s, sort it in decreasing order based on the frequency of the characters. 
 * The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

 

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 

Constraints:

1 <= s.length <= 5 * 105
s consists of uppercase and lowercase English letters and digits.
 * 
 * @author sukh
 *
 */
public class _10_FrequencySort {

  /**
   * Time: O(n + k log k) <br>
   * Space: O(n)
   * @param s
   * @return
   */
  public String sort(String s) {
    /**
     * Build a frequency map <br>
     * Time: O(n) <br>
     * Space: O(k) <br>
     * k = unique characters
     */
    Map<Character, Integer> map = new HashMap<>();
    char ch;
    for (int i = 0; i < s.length(); i++) {
      ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    /**
     * Prepare a list of characters <br>
     * Time: O(k) <br>
     * Space: O(k)
     */
    List<Character> list = new ArrayList<>(map.keySet());
    /**
     * Sort by frequency in descending order <br>
     * Time: O(k log k) <br>
     * Space: O(1) (or) O(k)
     */
    Collections.sort(list, (a, b) -> {
      return map.get(b) - map.get(a);
    });

    /**
     * Prepare the o/p <br>
     * Time: O(n) <br>
     * Space: O(n)
     */
    StringBuilder sb = new StringBuilder();
    for (char c : list) {
      int freq = map.get(c);
      for (int i = 0; i < freq; i++) {
        sb.append(c);
      }
    }

    return sb.toString();
  }

}
