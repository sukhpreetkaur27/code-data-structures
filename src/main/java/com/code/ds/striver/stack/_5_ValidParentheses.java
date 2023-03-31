package com.code.ds.striver.stack;

import java.util.ArrayDeque;
import java.util.Map;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 * 
 * @author sukh
 *
 */
public class _5_ValidParentheses {

  private static final Map<Character, Character> openClosemap = Map.of('(', ')', '{', '}', '[',
      ']');

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * @param s
   * @return
   */
  public boolean isValid(String s) {
    ArrayDeque<Character> stack = new ArrayDeque<>();
    for (char ch : s.toCharArray()) {
      if (openClosemap.containsKey(ch)) {
        stack.push(ch);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        char open = stack.pop();
        if (openClosemap.get(open) != ch) {
          return false;
        }
      }
    }
    return stack.isEmpty();

  }

}
