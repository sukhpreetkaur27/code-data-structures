package com.code.ds.striver.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true
 

Constraints:

1 <= s.length <= 100
s[i] is '(', ')' or '*'.
 * 
 * @author sukh
 *
 */
public class _33_VallidParenthesesString {

  /**
   * NOTE: <br>
   * WE can optimize the space to O(1) using greedy approach
   */

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param s
   * @return
   */
  public boolean checkValidString(String s) {
    /**
     * Stores open indices
     */
    Deque<Integer> open = new ArrayDeque<>();
    /**
     * Stores star indices
     */
    Deque<Integer> star = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        open.push(i);
      } else if (ch == '*') {
        star.push(i);
      } else {
        if (!open.isEmpty()) {
          /**
           * balance ( and )
           */
          open.pop();
        } else if (!star.isEmpty()) {
          /**
           * balance * and )
           */
          star.pop();
        } else {
          /**
           * nothing to balance )
           */
          return false;
        }
      }
    }

    /**
     * balance ( and *
     */
    while (!open.isEmpty()) {
      if (star.isEmpty()) {
        return false;
      } else {
        if (star.peek() < open.peek()) {
          /**
           * nothing to balance ( <br>
           * eg: **( <br>
           * as ( should be on the left of * or )
           */
          return false;
        } else {
          open.pop();
          star.pop();
        }
      }
    }

    return open.isEmpty();
  }

}
