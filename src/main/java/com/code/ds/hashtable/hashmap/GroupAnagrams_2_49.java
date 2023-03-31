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
public class GroupAnagrams_2_49 {

  /**
   * Time: O(n * k)<br>
   * Space: O(n * k)<br>
   * n = # of Strings<br>
   * k = length of the longest String
   * @param strs
   * @return
   */
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> group = new HashMap<>();

    final String delimiter = "#";

    int[] count = new int[26];
    for (String s : strs) {
      Arrays.fill(count, 0);

      for (char c : s.toCharArray()) {
        count[c - 'a']++;
      }

      StringBuilder sb = new StringBuilder();
      for (int i : count) {
        sb.append(delimiter);
        sb.append(i);
      }

      String key = sb.toString();
      group.putIfAbsent(key, new ArrayList<>());
      group.get(key).add(s);
    }

    return new ArrayList<>(group.values());
  }

}
