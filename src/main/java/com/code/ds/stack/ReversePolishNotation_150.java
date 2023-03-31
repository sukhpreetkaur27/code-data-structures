package com.code.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

Note that division between two integers should truncate toward zero.

It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.

 

Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 

Constraints:

1 <= tokens.length <= 104
tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 * 
 * @author sukh
 *
 */
public class ReversePolishNotation_150 {

  private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = new HashMap<>();

  static {
    OPERATIONS.put("+", (a, b) -> a + b);
    OPERATIONS.put("-", (a, b) -> a - b);
    OPERATIONS.put("*", (a, b) -> a * b);
    OPERATIONS.put("/", (a, b) -> a / b);
  }

  /**
   * Time: O(n)<br>
   * Space: O(n)<br>
   * In the worst case, the stack will have all the numbers on it at the same
   * time. This is never more than half the length of the input array.
   * @param tokens
   * @return
   */
  public int postfix(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < tokens.length; i++) {
      if (!OPERATIONS.containsKey(tokens[i])) {
        stack.push(Integer.valueOf(tokens[i]));
        continue;
      }

      int num2 = stack.pop();
      int num1 = stack.pop();
      int res = OPERATIONS.get(tokens[i]).apply(num1, num2);
      stack.push(res);
    }
    return stack.pop();
  }

}
