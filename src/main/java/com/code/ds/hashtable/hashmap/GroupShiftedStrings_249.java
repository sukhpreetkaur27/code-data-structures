package com.code.ds.hashtable.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings_249 {

  /**
   * Time: O(n * k)<br>
   * Space: O(n * k)<br>
   * n = # of Strings<br>
   * k = length of the longest String
   * @param strs
   * @return
   */
  public List<List<String>> groupStrings(String[] strs) {
    Map<String, List<String>> grp = new HashMap<>();

    for (String s : strs) {
      char[] c = s.toCharArray();

      for (int i = 0, base = c[0]; i < c.length; i++) {
        c[i] = _hash(c[i], (char) base);
      }

      String key = String.valueOf(c);
      grp.putIfAbsent(key, new ArrayList<>());
      grp.get(key).add(s);
    }

    return new ArrayList<>(grp.values());
  }

  /**
   * Calculate the hash key<br>
   * Diff b/w start and other letters<br>
   * To avoid negatives (in case of circular) --> add 26 --> modulo 26<br>
   * Final hash key char = 'a' + the above difference
   * @param letter
   * @param base
   * @return
   */
  private char _hash(char letter, char base) {
    return (char) ((letter - base + 26) % 26 + 'a');
  }

}
