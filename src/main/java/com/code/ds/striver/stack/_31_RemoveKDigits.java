package com.code.ds.striver.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 

Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.
 * 
 * @author sukh
 *
 */
public class _31_RemoveKDigits {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * @param num
   * @param k
   * @return
   */
  public String removeKdigits(String num, int k) {
    Deque<Character> stack = new ArrayDeque<Character>();

    /**
     * left digits has more weightage than right digit <br>
     * push digits into the monotonic increasing stack to build the smallest number
     */
    for (char digit : num.toCharArray()) {
      while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
        stack.removeLast();
        k -= 1;
      }
      stack.addLast(digit);
    }

    /* remove the remaining digits from the tail. */
    for (int i = 0; i < k; ++i) {
      stack.removeLast();
    }

    // build the final string, while removing the leading zeros.
    StringBuilder ret = new StringBuilder();
    boolean leadingZero = true;
    for (char digit : stack) {
      if (leadingZero && digit == '0')
        continue;
      leadingZero = false;
      ret.append(digit);
    }

    /* return the final string */
    if (ret.length() == 0)
      return "0";
    return ret.toString();
  }
  
  public static void main(String[] args) {
    _31_RemoveKDigits obj = new _31_RemoveKDigits();
    String res = obj.removeKdigits("10200", 1);
    System.out.println(res);
  }

}
