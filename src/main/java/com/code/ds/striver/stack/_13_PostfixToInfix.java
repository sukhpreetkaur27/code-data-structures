package com.code.ds.striver.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Input : abc++
Output : (a + (b + c))

Input  : ab*c+
Output : ((a*b)+c)
 * 
 * @author sukh
 *
 */
public class _13_PostfixToInfix {

  /**
   * NOTE: <br>
   * Algorithm for Postfix to Infix:
   * 
   * 1. Read the Postfix expression in from left to right
   * 
   * 2. If the symbol is an operand, then push it onto the Stack
   * 
   * 3. If the symbol is an operator, then pop two operands from the Stack
   * 
   * 3. a. Create a string by concatenating the two operands and the operator
   * after them.
   * 
   * string = ( operand2 + operator + operand1
   * 
   * 3. b. And push the resultant string back to Stack
   * 
   * 4. Repeat the above steps until the end of Postfix expression.
   * 
   * 5. At the end stack will have only 1 string i.e resultant string
   */

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * @param expression
   * @return
   */
  public String convert(String expression) {
    StringBuilder sb = new StringBuilder();
    Deque<String> stack = new ArrayDeque<>();

    for (char ch : expression.toCharArray()) {
      sb.setLength(0);
      if (Character.isLetterOrDigit(ch)) {
        stack.push(ch + "");
      } else {
        String a = stack.pop();
        String b = stack.pop();
        sb.append("(").append(b).append(ch).append(a).append(")");
        stack.push(sb.toString());
      }
    }

    return stack.pop();
  }

}
