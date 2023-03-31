package com.code.ds.striver.string;

/**
 * A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.

For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.

Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.

 

Example 1:

Input: s = "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
Example 2:

Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation: 
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
Example 3:

Input: s = "()()"
Output: ""
Explanation: 
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".
 

Constraints:

1 <= s.length <= 105
s[i] is either '(' or ')'.
s is a valid parentheses string.
 * 
 * @author sukh
 *
 */
public class _2_RemoveOutermostParentheses {

  /**
   * NOTE: <br>
   * s = valid parenthesis string
   */

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * @param s
   * @return
   */
  public String modify(String s) {
    char open = '(';
    char end = ')';
    char ch;
    StringBuilder res = new StringBuilder();
    for (int i = 0, openCount = 0; i < s.length(); i++) {
      ch = s.charAt(i);

      /**
       * count the open parentheses except the first one
       */
      if (ch == open && openCount++ > 0) {
        res.append(ch);
      } else if (ch == end && openCount-- > 1) {
        res.append(ch);
      }
    }
    return res.toString();
  }

}
