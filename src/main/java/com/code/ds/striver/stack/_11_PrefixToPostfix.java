package com.code.ds.striver.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Input : <br>
 * Prefix : *+AB-CD
 * 
 * Output : <br>
 * Postfix : AB+CD-*
 * 
 * Explanation :
 * 
 * Prefix to Infix : (A+B) * (C-D) <br>
 * Infix to Postfix : AB+CD-*
 * 
 * Input : <br>
 * Prefix : *-A/BC-/AKL
 * 
 * Output : <br>
 * Postfix : ABC/-AK/L-*
 * 
 * Explanation :
 * 
 * Prefix to Infix : (A-(B/C))*((A/K)-L) <br>
 * Infix to Postfix : ABC/-AK/L-*
 * 
 * @author sukh
 *
 */
public class _11_PrefixToPostfix {

  /**
   * NOTE: <br>
   * Algorithm for Prefix to Postfix:
   * 
   * 1. Read the Prefix expression in reverse order (from right to left)
   * 
   * 2. If the symbol is an operand, then push it onto the Stack
   * 
   * 3. If the symbol is an operator, then pop two operands from the Stack
   * 
   * 3. a. Create a string by concatenating the two operands and the operator
   * after them.
   * 
   * string = operand1 + operand2 + operator
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
        sb.append(a).append(b).append(ch);
        stack.push(sb.toString());
      }
    }

    return stack.pop();
  }

}
