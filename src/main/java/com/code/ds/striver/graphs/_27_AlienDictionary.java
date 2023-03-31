package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.

You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted lexicographically by the rules of this new language.

Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. 
If there is no solution, return "". If there are multiple solutions, return any of them.

 

Example 1:

Input: words = ["wrt","wrf","er","ett","rftt"]
Output: "wertf"
Example 2:

Input: words = ["z","x"]
Output: "zx"
Example 3:

Input: words = ["z","x","z"]
Output: ""
Explanation: The order is invalid, so return "".
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of only lowercase English letters.
 * 
 * @author sukh
 *
 */
public class _27_AlienDictionary {

  /**
   * Time: O(V + E + W) <br>
   * Space: O(V + E)
   * 
   * @param words
   * @return
   */
  public String alienOrder(String[] words) {
    /**
     * Adjacency List for all lowercase alphabets
     */
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < 26; i++) {
      adj.add(new ArrayList<>());
    }

    int[] inDegrees = new int[26];
    Arrays.fill(inDegrees, -1);

    /**
     * Set in-degree to 0 for characters present in the words[]
     * 
     * Rest are set to -1
     */
    for (String w : words) {
      for (char c : w.toCharArray()) {
        inDegrees[c - 'a'] = 0;
      }
    }

    for (int i = 1; i < words.length; i++) {
      boolean flag = true;
      String a = words[i - 1];
      String b = words[i];
      int len = Math.min(a.length(), b.length());
      for (int j = 0; j < len; j++) {
        if (a.charAt(j) != b.charAt(j)) {
          /**
           * mismatch character = mapping from a to b
           */
          adj.get(a.charAt(j) - 'a').add(b.charAt(j) - 'a');
          flag = false;
          break;
        }
      }
      /**
       * Check for invalid dictionary
       * 
       * words = {"abcd", "abc"}
       * 
       * here, "abc" should have been before "abcd"
       */
      if (flag && a.length() > b.length()) {
        return "";
      }
    }

    List<Integer> sort = topoSort(adj, inDegrees);
    StringBuilder sb = new StringBuilder();
    for (int i : sort) {
      sb.append((char) (i + 97));
    }
    return sb.toString();
  }

  /**
   * Kahn's Topo Sort Algo
   */
  private List<Integer> topoSort(List<List<Integer>> adj, int[] inDegrees) {
    int uniqueCharCount = 0;
    Deque<Integer> queue = new ArrayDeque<>();
    /**
     * Calculate in-degrees
     */
    for (int i = 0; i < 26; i++) {
      for (int j : adj.get(i)) {
        inDegrees[j]++;
      }
    }
    for (int i = 0; i < 26; i++) {
      if (inDegrees[i] == 0) {
        queue.offer(i);
        uniqueCharCount++;
      } else if (inDegrees[i] > -1) {
        uniqueCharCount++;
      }
    }
    List<Integer> sort = new ArrayList<>();
    while (!queue.isEmpty()) {
      int pop = queue.poll();
      sort.add(pop);
      for (int i : adj.get(pop)) {
        inDegrees[i]--;
        if (inDegrees[i] == 0) {
          queue.offer(i);
        }
      }
    }
    /**
     * Check for invalid dictionary
     * 
     * Cyclic Graph
     */
    if (uniqueCharCount != sort.size()) {
      return new ArrayList<>();
    }
    return sort;
  }

}
