package com.code.ds.striver.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 * 
 * @author sukh
 *
 */
public class _12_RomanToInt {

  /**
   * Time: O(1) <br>
   * As there is a finite set of roman numerals, the maximum number possible
   * number can be 3999, which in roman numerals is MMMCMXCIX. As such the time
   * complexity is O(1)O(1). <br>
   * 
   * Space: O(1) <br>
   * Because only a constant number of single-value variables are used, the space
   * complexity is O(1)O(1).
   * @param s
   * @return
   */
  public int romanToInt(String s) {
    int n = s.length();

    /**
     * NOTE: <br>
     * Roman numerals are usually written largest to smallest from left to right.
     * However, the numeral for four is not IIII. Instead, the number four is
     * written as IV. Because the one is before the five we subtract it making four.
     * The same principle applies to the number nine, which is written as IX. There
     * are six instances where subtraction is used:
     * 
     * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed
     * before L (50) and C (100) to make 40 and 90. C can be placed before D (500)
     * and M (1000) to make 400 and 900.
     */
    Map<Character, Integer> romans = new HashMap<>();
    romans.put('I', 1);
    romans.put('V', 5);
    romans.put('X', 10);
    romans.put('L', 50);
    romans.put('C', 100);
    romans.put('D', 500);
    romans.put('M', 1000);

    int res = 0;

    for (int i = 0, curr = 0, next = 0; i < n;) {
      curr = romans.get(s.charAt(i));
      next = 0;

      if ((i + 1) < n) {
        next = romans.get(s.charAt(i + 1));
      }

      if (curr < next) {
        res += (next - curr);
        i += 2;
      } else {
        res += curr;
        i++;
      }
    }

    return res;
  }

}
