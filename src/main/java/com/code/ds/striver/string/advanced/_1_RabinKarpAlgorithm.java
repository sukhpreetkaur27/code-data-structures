package com.code.ds.striver.string.advanced;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, return the length of the longest repeating substrings. If no repeating substring exists, return 0.

 

Example 1:

Input: s = "abcd"
Output: 0
Explanation: There is no repeating substring.
Example 2:

Input: s = "abbaba"
Output: 2
Explanation: The longest repeating substrings are "ab" and "ba", each of which occurs twice.
Example 3:

Input: s = "aabcaabdaab"
Output: 3
Explanation: The longest repeating substring is "aab", which occurs 3 times.
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase English letters.
 * 
 * @author sukh
 *
 */
public class _1_RabinKarpAlgorithm {

  /**
   * Find the length of the longest repeating substring
   * 
   * Algo used: Rabin Karp
   */

  /**
   * Time: O(N) <br>
   * Space: O(N)
   * 
   * @param s_chars
   * @param length
   * @return
   */
  public boolean rabinKarp(final char[] s_chars, final int length) {
    /**
     * hash[0] = 0
     */
    long hash = 0l;
    long pow = 1l;

    Set<Long> set = new HashSet<>();

    /**
     * NOTE:
     * 
     * hash(s) = summation (s[i] * p^i mod m)
     * 
     * i belongs to [0, N)
     * 
     * hash of substring [i, j] * p^i = hash (s[0, j]) - hash (s[0...i-1]) mod m
     * 
     * 
     */

    /**
     * NOTE: we save time and space by using the concept of rolling hash
     * 
     * here, instead of pre-calculating hash prefixes and powers in an array of
     * length N (size of the input string)
     * 
     * we calculate the hash on the fly
     */
    for (int i = 0; i < n; i++) {
      /**
       * NOTE: p is constant = 26 (lowercase alphabets)
       * 
       * for hash(s [0, i])
       */
      hash = (hash * p + (s_chars[i] - 'a' + 1)) % m;
      if (i >= length) {
        /**
         * calculating the hash of substring [i-length, i]
         */
        hash = (hash - ((s_chars[i - length] - 'a' + 1) * pow % m) + m) % m;
      } else {
        /**
         * increment the powers of p for i = [0, length)
         * 
         * required for calculating the hash of substring [i-length, i]
         */
        pow = pow * p % m;
      }
      if (i >= length - 1) {
        /**
         * NOTE: is value doesn't gets added to the hash set --> it's a duplicate
         */
        if (!set.add(hash)) {
          return true;
        }
      }
    }

    return false;
  }

  private static final int p = 26;
  private static final long m = (long) 1e9 + 9;
  private int n;

  /**
   * Time: O(n log n) <br>
   * Space: O(n)
   * 
   * @param s
   * @return
   */
  public int longestRepeatingSubstring(String s) {
    final char[] s_chars = s.toCharArray();
    n = s_chars.length;

    int left = 1;
    int right = n - 1;
    int length;
    /**
     * NOTE: instead of searching for the entire search space (length [1,N])
     * 
     * Apply binary search
     * 
     * Why?
     * 
     * 1. search space is sorted <br>
     * 2. we are interested in finding the longest length. then, why to waste time
     * starting from length 1
     * 
     * Time: O(log n)
     */
    while (left <= right) {
      length = left + (right - left) / 2;
      if (rabinKarp(s_chars, length)) {
        left = length + 1;
      } else {
        right = length - 1;
      }
    }

    return left - 1;
  }

}
