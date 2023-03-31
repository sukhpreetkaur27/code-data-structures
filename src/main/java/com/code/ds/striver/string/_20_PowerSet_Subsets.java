package com.code.ds.striver.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a string S, Find all the possible subsequences of the String in lexicographically-sorted order.

Example 1:

Input : str = "abc"
Output: a ab abc ac b bc c
Explanation : There are 7 subsequences that 
can be formed from abc.
Example 2:

Input: str = "aa"
Output: a a aa
Explanation : There are 3 subsequences that 
can be formed from aa.
 * 
 * @author sukh
 *
 */
public class _20_PowerSet_Subsets {

  /**
   * Time: O((2^n) * n) <br>
   * Space: O(1)
   * @param s
   * @return
   */
  public List<String> subset(String s) {
    List<String> list = new ArrayList<>();
    int n = s.length();
    /**
     * # of subsets = 2^n
     */
    int end = (1 << n) - 1;
    StringBuilder sb = new StringBuilder();
    /**
     * NOTE: <br>
     * In this problem, we are removing the empty set.
     */
    for (int i = 1; i <= end; i++) {
      for (int j = 0, bit = 0; j < n; j++) {
        /**
         * if the i-th bit is set, use nums[i] as part of the subset
         */
        bit = i & (1 << j);
        if (bit != 0) {
          sb.append(s.charAt(j));
        }
      }
      list.add(sb.toString());
      sb.delete(0, sb.length());
    }
    /**
     * To sort lexicographically
     */
    Collections.sort(list);
    return list;
  }

}
