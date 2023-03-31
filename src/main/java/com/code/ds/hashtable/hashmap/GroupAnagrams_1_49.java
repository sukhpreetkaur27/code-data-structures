package com.code.ds.hashtable.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 * @author sukh
 *
 */
public class GroupAnagrams_1_49 {

  /**
   * Space: O(n * k)
   * @param strs
   * @return
   */
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> group = new HashMap<>();

    /**
     * Time: O(n * k log k)<br>
     * n = # of Strings<br>
     * k = length of the longest String
     */
    for (String s : strs) {
      char[] c = s.toCharArray();
      Arrays.sort(c);

      String key = String.valueOf(c);
      group.putIfAbsent(key, new ArrayList<>());
      group.get(key).add(s);
    }

    return new ArrayList<>(group.values());
  }

}
