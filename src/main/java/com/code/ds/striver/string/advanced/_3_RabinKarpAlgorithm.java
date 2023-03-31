package com.code.ds.striver.string.advanced;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s, consider all duplicated substrings: (contiguous) substrings of s that occur 2 or more times. The occurrences may overlap.

Return any duplicated substring that has the longest possible length. If s does not have a duplicated substring, the answer is "".

 

Example 1:

Input: s = "banana"
Output: "ana"
Example 2:

Input: s = "abcd"
Output: ""
 

Constraints:

2 <= s.length <= 3 * 104
s consists of lowercase English letters.

 * @author sukh
 *
 */
public class _3_RabinKarpAlgorithm {

  public String rabinKarp(final String s, final int length) {
    long hash = 0l;
    long pow = 1l;

    Map<Long, List<Integer>> set = new HashMap<>();

    for (int i = 0; i < n; i++) {
      hash = (hash * p + (s.charAt(i) - 'a' + 1)) % m;
      if (i >= length) {
        hash = (hash - ((s.charAt(i - length) - 'a' + 1) * pow % m) + m) % m;
      } else {
        pow = pow * p % m;
      }
      if (i >= length - 1) {
        if (set.containsKey(hash)) {
          String curr = s.substring(i - length + 1, i + 1);
          for (int end : set.get(hash)) {
            String sub = s.substring(end - length + 1, end + 1);
            /**
             * check for collisions
             */
            if (curr.equals(sub)) {
              return curr;
            }
          }
        }
        set.putIfAbsent(hash, new ArrayList<>());
        set.get(hash).add(i);
      }
    }
    return null;
  }

  private static final int p = 31;
  private static final long m = (long) 1e9 + 9;
  private int n;

  /**
   * Time: O(n log n) <br>
   * Space: O(n)
   * 
   * @param s
   * @return
   */
  public String longestDupSubstring(String s) {
    n = s.length();
    String ans = "";
    int left = 1;
    int right = n - 1;
    int length;
    while (left <= right) {
      length = left + (right - left) / 2;
      String dup = rabinKarp(s, length);
      if (dup != null) {
        ans = dup;
        left = length + 1;
      } else {
        right = length - 1;
      }
    }

    return ans;
  }

}
