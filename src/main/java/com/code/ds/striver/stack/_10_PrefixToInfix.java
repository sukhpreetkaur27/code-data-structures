package com.code.ds.striver.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Input :
 * 
 * Prefix : *+AB-CD
 * 
 * Output :
 * 
 * Infix : ((A+B)*(C-D))
 * 
 * Input :
 * 
 * Prefix : *-A/BC-/AKL
 * 
 * Output :
 * 
 * Infix : ((A-(B/C))*((A/K)-L))
 * 
 * @author sukh
 *
 */
public class _10_PrefixToInfix {

  /**
   * NOTE: <br>
   * Algorithm for Prefix to Infix:
   * 
   * 1. Read the Prefix expression in reverse order (from right to left)
   * 
   * 2. If the symbol is an operand, then push it onto the Stack
   * 
   * 3. If the symbol is an operator, then pop two operands from the Stack
   * 
   * 3. a. Create a string by concatenating the two operands and the operator
   * between them.
   * 
   * string = ( operand1 + operator + operand2 )
   * 
   * 3. b. And push the resultant string back to Stack
   * 
   * 4. Repeat the above steps until the end of Prefix expression.
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

    for (int i = expression.length() - 1; i >= 0; i--) {
      sb.setLength(0);
      char ch = expression.charAt(i);
      if (Character.isLetterOrDigit(ch)) {
        stack.push(ch + "");
      } else {
        String a = stack.pop();
        String b = stack.pop();
        sb.append("(").append(a).append(ch).append(b).append(")");
        stack.push(sb.toString());
      }
    }

    return stack.pop();
  }

}
