package com.code.ds.striver.string;

/**
 * Given a string s consisting only of characters a, b and c.
 * 
 * Return the number of substrings containing at least one occurrence of all
 * these characters a, b and c.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcabc" Output: 10 Explanation: The substrings containing at
 * least one occurrence of the characters a, b and c are "abc", "abca", "abcab",
 * "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
 * 
 * 
 * Example 2:
 * 
 * Input: s = "aaacb" Output: 3 Explanation: The substrings containing at least
 * one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
 * Example 3:
 * 
 * Input: s = "abc" Output: 1
 * 
 * 
 * Constraints:
 * 
 * 3 <= s.length <= 5 x 10^4 
 * 
 * s only consists of a, b or c characters.
 * 
 * @author sukh
 *
 */
public class _16_SubstringsWithAll3Chars {

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * @param s
   * @return
   */
  public int substrings(String s) {
    int count = 0;

    /**
     * Stores the last index for a, b, c
     */
    int[] lastIndex = { -1, -1, -1 };

    for (int i = 0; i < s.length(); i++) {
      lastIndex[s.charAt(i) - 'a'] = i;

      /**
       * Math.min(lastIndex[0], Math.min(lastIndex[1], lastIndex[2])) == start index
       * of the current substring, which is the smallest substring<br>
       * 
       * 
       * 1 for the current substring <br>
       * 
       * 
       * for the current combo of substring, using characters before the start index
       * there are "start index" # of substrings, which are the larger in size
       * substrings than the current substring <br>
       * hence, we add them up
       * 
       * 
       * 
       * Now from this min-index (min(l1, l2, l3) to the curr index i this is the
       * smallest possible sub-string ending at curr-index i which follows the
       * constraint.
       * 
       * <br> NOTE: <br>
       * If the smallest sub-string is from min-index to curr-index, then for every
       * sub-string starting from index 0, 1, 2, 3, ......min-index and ending at
       * curr-index is valid,
       * 
       * (So how many are these...... So there are min-index + 1 sub-strings) Add this
       * min-index + 1 to the count.
       */
      count += 1 + Math.min(lastIndex[0], Math.min(lastIndex[1], lastIndex[2]));
    }

    return count;
  }

}
