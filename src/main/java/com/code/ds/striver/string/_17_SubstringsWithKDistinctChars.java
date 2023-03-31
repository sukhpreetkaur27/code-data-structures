package com.code.ds.striver.string;

/**
 * Given a string of lowercase alphabets, count all possible substrings (not necessarily distinct) that have exactly k distinct characters. 


Example 1:

Input:
S = "aba", K = 2
Output:
3
Explanation:
The substrings are:
"ab", "ba" and "aba".
Example 2:

Input: 
S = "abaaca", K = 1
Output:
7
Explanation:
The substrings are:
"a", "b", "a", "aa", "a", "c", "a". 
 * 
 * @author sukh
 *
 */
public class _17_SubstringsWithKDistinctChars {

  /**
   * difference of count of at most k and count of at most (k-1) <br>
   * 
   * Time: O(n) <br>
   * Space: O(1)
   * @param s
   * @param k
   * @return
   */
  public int countK(String s, int k) {
    return countAtMostK(s, k) - countAtMostK(s, k - 1);
  }

  /**
   * NOTE: <br>
   * 
   * This gives the count of substrings with at most K distinct characters
   * 
   * Time: O(n) <br>
   * Space: O(1)
   * @param s
   * @param k
   * @return
   */
  private int countAtMostK(String s, int k) {
    int res = 0;

    int n = s.length();

    /**
     * Sliding Window
     */
    int start = 0;
    int end = 0;

    /**
     * Character count
     */
    int[] char_count = new int[26];

    /**
     * distinct char count
     */
    int distinct_count = 0;

    int char_index;

    while (end < n) {
      char_index = s.charAt(end) - 'a';
      /**
       * count the characters
       */
      char_count[char_index]++;
      /**
       * if adding for the first time, it means it is a distinct character
       */
      if (char_count[char_index] == 1) {
        distinct_count++;
      }
      /**
       * we need at most k distinct characters, hence, shrink the window
       */
      while (distinct_count > k) {
        char_index = s.charAt(start) - 'a';
        char_count[char_index]--;
        /**
         * if the character count for the current start = 0, it means we have completely
         * eliminated this distinct character
         */
        if (char_count[char_index] == 0) {
          distinct_count--;
        }
        start++;
      }

      /**
       * NOTE, the result is a cumulative sum consisting of the # of substrings till
       * the current end <br>
       * 
       * after shrinking the window, we have a new set of substrings calculated by:
       * <br>
       * 
       * (end - start + 1)
       */
      res += (end - start + 1);

      end++;
    }

    return res;
  }

}
