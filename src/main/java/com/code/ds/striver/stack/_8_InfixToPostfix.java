package com.code.ds.striver.stack;

import java.util.ArrayDeque;

/**
 * Given an infix expression in the form of string str. Convert this infix expression to postfix expression.

Infix expression: The expression of the form a op b. When an operator is in-between every pair of operands.
Postfix expression: The expression of the form a b op. When an operator is followed for every pair of operands.
Note: The order of precedence is: ^ greater than * equals to / greater than + equals to -. 
Example 1:

Input: str = "a+b*(c^d-e)^(f+g*h)-i"
Output: abcd^e-fgh*+^*+i-
Explanation:
After converting the infix expression 
into postfix expression, the resultant 
expression will be abcd^e-fgh*+^*+i-
Example 2:

Input: str = "A*(B+C)/D"
Output: ABC+*D/
Explanation:
After converting the infix expression 
into postfix expression, the resultant 
expression will be ABC+*D/

Expected Time Complexity: O(|str|).
Expected Auxiliary Space: O(|str|).

Constraints:
1 ≤ |str| ≤ 105
 * 
 * @author sukh
 *
 */
public class _8_InfixToPostfix {

  /**
   * Approach: To convert Infix expression to Postfix
   * 
   * 1. Scan the infix expression from left to right.
   * 
   * 2. If the scanned character is an operand, Print it.
   * 
   * 3. Else,
   * 
   * 3. a. If the precedence of the scanned operator is greater than the
   * precedence of the operator in the stack or the stack is empty or the stack
   * contains a ‘(‘, push the character into the stack.
   * 
   * 3. b. Else, Pop all the operators from the stack which are greater than or
   * equal to in precedence than that of the scanned operator. After doing that
   * Push the scanned operator to the stack.
   * 
   * 4. If the scanned character is an ‘(‘, push it into the stack.
   * 
   * 5. If the scanned character is an ‘)’, pop the stack and output it until a
   * ‘(‘ is encountered, and discard both the parenthesis.
   * 
   * 6. Repeat steps 2-5 until the entire infix expression is scanned.
   * 
   * 7. Print the output.
   * 
   * 8. Pop and print the output from the stack until it is not empty.
   * 
   */

  /**
   * Time: O(n) <br>
   * n = string length <br>
   * Space: O(n)
   * @param exp
   * @return
   */
  public static String infixToPostfix(String exp) {
    StringBuilder sb = new StringBuilder();
    /**
     * stack holds the operators in precedence order, i.e., stack[top] == highest
     * precedence
     **/
    ArrayDeque<Character> stack = new ArrayDeque<>();

    for (char ch : exp.toCharArray()) {
      /**
       * If the scanned character is an operand, add it to output
       */
      if (Character.isLetterOrDigit(ch)) {
        sb.append(ch);
      } else if (stack.isEmpty() || ch == '(') {
        /**
         * If the scanned character is an '(' (or) <br>
         * if the stack is empty, <br>
         * push it to the stack.
         */
        stack.push(ch);
      } else if (ch == ')') {
        /**
         * If the scanned character is an ')', pop and output from the stack until an
         * '(' is encountered.
         */
        while (!stack.isEmpty() && stack.peek() != '(') {
          sb.append(stack.pop());
        }
        stack.pop();
      } else {
        /*
         * if an operator is scanned
         */
        while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
          /**
           * pop all operators with precedence >= scanned operator
           */
          sb.append(stack.pop());
        }
        /**
         * push the scanned operator
         */
        stack.push(ch);
      }
    }

    /**
     * pop all the operators from the stack
     */
    while (!stack.isEmpty()) {
      /**
       * if we have exhausted the string expression, and no closing brace is
       * encountered <br>
       * then, it's an invalid expression
       */
      if (stack.peek() == '(') {
        return "Invalid Expression";
      }
      sb.append(stack.pop());
    }

    return sb.toString();
  }

  /**
   * A utility function to return precedence of a given operator <br>
   * Higher returned value means higher precedence
   * @param ch
   * @return
   */
  private static int precedence(char ch) {
    switch (ch) {
      case '+':
      case '-':
        return 1;

      case '*':
      case '/':
        return 2;

      case '^':
        return 3;
    }
    return -1;
  }

}
