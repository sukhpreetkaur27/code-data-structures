package com.code.ds.striver.string;

import java.util.Arrays;

/**
 * The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

For example, the beauty of "abaacc" is 3 - 1 = 2.
Given a string s, return the sum of beauty of all of its substrings.

 

Example 1:

Input: s = "aabcb"
Output: 5
Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
Example 2:

Input: s = "aabcbaa"
Output: 17
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters.
 * 
 * @author sukh
 *
 */
public class _19_BeautyOfSubstrings {

  /**
   * Time: O(n^2) <br>
   * Space: O(1)
   * @param s
   * @return
   */
  public int beauty(String s) {
    int res = 0;
    int n = s.length();
    int[] char_count = new int[26];
    for (int i = 0; i < n; i++) {
      Arrays.fill(char_count, 0);
      for (int j = i, char_index = 0, max_freq = 0, min_freq = 0; j < n; j++) {
        char_index = s.charAt(j) - 'a';
        char_count[char_index]++;
        max_freq = maxFreq(char_count);
        min_freq = minFreq(char_count);
        res += (max_freq - min_freq);
      }
    }

    return res;
  }

  private int maxFreq(int[] char_count) {
    int max_freq = 0;
    for (int freq : char_count) {
      if (freq != 0) {
        max_freq = Math.max(max_freq, freq);
      }
    }
    return max_freq;
  }

  private int minFreq(int[] char_count) {
    int min_freq = Integer.MAX_VALUE;
    for (int freq : char_count) {
      if (freq != 0) {
        min_freq = Math.min(min_freq, freq);
      }
    }
    return min_freq;
  }

}
