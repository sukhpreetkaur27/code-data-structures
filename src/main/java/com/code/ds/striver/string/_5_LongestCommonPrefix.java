package com.code.ds.striver.string;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
 * 
 * @author sukh
 *
 */
public class _5_LongestCommonPrefix {

  /**
   * Time: O(s) <br>
   * s = sum of all the characters in all the strings <br>
   * Space: O(1)
   * @param strs
   * @return
   */
  public String commonPrefix(String[] strs) {
    /**
     * NOTE: <br>
     * Vertical Scanning
     */
    for (int i = 0; i < strs[0].length(); i++) {
      char ch = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        /**
         * strs[j].length() == i <br>
         * as the entire string has been scanned in the previous iteration, and i will
         * result into StringIndexOutOfBoundsException
         */
        if (strs[j].length() == i || strs[j].charAt(i) != ch) {
          return strs[j].substring(0, i);
        }
      }
    }
    /**
     * all the strings are equal
     */
    return strs[0];
  }

}
