package com.code.ds.striver.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * A boolean expression is an expression that evaluates to either true or false. It can be in one of the following shapes:

't' that evaluates to true.
'f' that evaluates to false.
'!(subExpr)' that evaluates to the logical NOT of the inner expression subExpr.
'&(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical AND of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
'|(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical OR of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
Given a string expression that represents a boolean expression, return the evaluation of that expression.

It is guaranteed that the given expression is valid and follows the given rules.

 

Example 1:

Input: expression = "&(|(f))"
Output: false
Explanation: 
First, evaluate |(f) --> f. The expression is now "&(f)".
Then, evaluate &(f) --> f. The expression is now "f".
Finally, return false.
Example 2:

Input: expression = "|(f,f,f,t)"
Output: true
Explanation: The evaluation of (false OR false OR false OR true) is true.
Example 3:

Input: expression = "!(&(f,t))"
Output: true
Explanation: 
First, evaluate &(f,t) --> (false AND true) --> false --> f. The expression is now "!(f)".
Then, evaluate !(f) --> NOT false --> true. We return true.
 

Constraints:

1 <= expression.length <= 2 * 104
expression[i] is one following characters: '(', ')', '&', '|', '!', 't', 'f', and ','.
 * 
 * @author sukh
 *
 */
public class _34_ParseBooleanExpression {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param expression
   * @return
   */
  public boolean parseBoolExpr(String expression) {
    Deque<Character> stk = new ArrayDeque<>();
    for (int i = 0; i < expression.length(); ++i) {
      char c = expression.charAt(i);
      if (c == ')') {
        Set<Character> seen = new HashSet<>();
        while (stk.peek() != '(')
          seen.add(stk.pop());
        stk.pop();// pop out '('.
        char operator = stk.pop(); // get operator for current expression.
        if (operator == '&') {
          stk.push(seen.contains('f') ? 'f' : 't'); // if there is any 'f', & expression
                                                    // results to 'f'
        } else if (operator == '|') {
          stk.push(seen.contains('t') ? 't' : 'f'); // if there is any 't', | expression
                                                    // results to 't'
        } else { // ! expression.
          stk.push(seen.contains('t') ? 'f' : 't'); // Logical NOT flips the expression.
        }
      } else if (c != ',') {
        stk.push(c);
      }
    }
    return stk.pop() == 't';
  }

}
