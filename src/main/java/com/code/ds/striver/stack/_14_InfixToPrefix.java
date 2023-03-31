package com.code.ds.striver.stack;

import java.util.ArrayDeque;

/**
 * Input : A * B + C / D
Output : + * A B/ C D 

Input : (A - B/C) * (A/K-L)
Output : *-A/BC-/AKL
 * 
 * @author sukh
 *
 */
public class _14_InfixToPrefix {

  /**
   * Approach: To convert Infix expression to Postfix
   * 
   * 1. First, reverse the given infix expression.
   * 
   * 1. a. Scan the infix expression from left to right.
   * 
   * 2. If the scanned character is an operand, Print it.
   * 
   * 3. Else,
   * 
   * 3. a. If the precedence of the scanned operator is greater than the
   * precedence of the operator in the stack or the stack is empty or the stack
   * top contains a ‘)‘, push the character into the stack.
   * 
   * 3. b. If the precedence of the scanned operator is less than the precedence
   * of the operator in the stack, Pop all the operators from the stack which are
   * greater than in precedence than that of the scanned operator. After doing
   * that Push the scanned operator to the stack.
   * 
   * 3. c. If the incoming operator has the same precedence with a TOP of the
   * stack, push the incoming operator into the stack.
   * 
   * 3. d. If the incoming operator has the same precedence with the top of the
   * stack and the incoming operator is ^, then pop the top of the stack till the
   * condition is true. If the condition is not true, push the ^ operator.
   * 
   * 4. If the scanned character is an ‘)‘, push it into the stack.
   * 
   * 5. If the scanned character is an ‘(’, pop the stack and output it until a
   * ‘)‘ is encountered, and discard both the parenthesis.
   * 
   * 6. Repeat steps 2-5 until the entire infix expression is scanned.
   * 
   * 7. Print the output.
   * 
   * 8. Pop and print the output from the stack until it is not empty.
   * 
   * 9. In the end, reverse the output. And print it.
   * 
   */

  /**
   * Time: O(n) <br>
   * n = string length <br>
   * Space: O(n)
   * @param exp
   * @return
   */
  public static String infixToPrefix(String exp) {
    StringBuilder sb = new StringBuilder();
    /**
     * stack holds the operators in precedence order, i.e., stack[top] == highest
     * precedence
     **/
    ArrayDeque<Character> stack = new ArrayDeque<>();

    for (int i = exp.length() - 1; i >= 0; i--) {
      char ch = exp.charAt(i);
      /**
       * If the scanned character is an operand, add it to output
       */
      if (Character.isLetterOrDigit(ch)) {
        sb.append(ch);
      } else if (stack.isEmpty() || ch == ')') {
        /**
         * If the scanned character is an ')' (or) <br>
         * if the stack is empty, <br>
         * push it to the stack.
         */
        stack.push(ch);
      } else if (ch == '(') {
        /**
         * If the scanned character is an '(', pop and output from the stack until an
         * ')' is encountered.
         */
        while (!stack.isEmpty() && stack.peek() != ')') {
          sb.append(stack.pop());
        }
        stack.pop();
      } else {
        /**
         * if an operator is scanned <br>
         * a. pop all operators with precedence > scanned operator <br>
         * b. pop all ^ operators if scanned operator = ^
         */
        while (!stack.isEmpty()
            && (precedence(stack.peek()) > precedence(ch) || (ch == '^' && stack.peek() == ch))) {
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
       * if we have exhausted the string expression, and no open brace is encountered
       * <br>
       * then, it's an invalid expression
       */
      if (stack.peek() == ')') {
        return "Invalid Expression";
      }
      sb.append(stack.pop());
    }

    return sb.reverse().toString();
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

  public static void main(String[] args) {
    String s = "(A-B/C)*(A/K-L)";
    System.out.println(infixToPrefix(s));
  }

}
