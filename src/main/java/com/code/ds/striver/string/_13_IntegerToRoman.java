package com.code.ds.striver.string;

/**
 * Given an integer, convert it to a roman numeral.

 

Example 1:

Input: num = 3
Output: "III"
Explanation: 3 is represented as 3 ones.
Example 2:

Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 3:

Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= num <= 3999
 * 
 * @author sukh
 *
 */
public class _13_IntegerToRoman {

  private static final int[] values = {};
  private static final String[] symbols = {};

  /**
   * Time: O(1) <br>
   * As there is a finite set of roman numerals, there is a hard upper limit on
   * how many times the loop can iterate. This upper limit is 15 times, and it
   * occurs for the number 3888, which has a representation of MMMDCCCLXXXVIII.
   * Therefore, we say the time complexity is constant, i.e. O(1)O(1).
   * 
   * Space: O(1) <br>
   * The amount of memory used does not change with the size of the input integer,
   * and is therefore constant.
   * @param num
   * @return
   */
  public String toRoman(int num) {
    StringBuilder sb = new StringBuilder();

    /**
     * Traverse through the values till num != 0
     */
    for (int i = 0; i < values.length && num > 0; i++) {
      /**
       * Repeat while the current symbol still fits into num
       */
      while (num >= values[i]) {
        num -= values[i];
        sb.append(symbols[i]);
      }
    }

    return sb.toString();
  }

}
