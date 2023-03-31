package com.code.ds.hashtable.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".

 

Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0
 

Constraints:

1 <= jewels.length, stones.length <= 50
jewels and stones consist of only English letters.
All the characters of jewels are unique.
 * @author sukh
 *
 */
public class JewelsStones_771 {

  /**
   * Time: O(j + s)<br>
   * Space: O(j)
   * @param jewels
   * @param stones
   * @return
   */
  public int count(String jewels, String stones) {
    Set<Character> set = new HashSet<>();
    for (char c : jewels.toCharArray()) {
      set.add(c);
    }

    int j = 0;
    for (char c : stones.toCharArray()) {
      if (set.contains(c)) {
        j++;
      }
    }
    return j;
  }

}
