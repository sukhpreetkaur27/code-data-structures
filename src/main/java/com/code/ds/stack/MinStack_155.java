package com.code.ds.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
 * 
 * @author sukh
 *
 */
public class MinStack_155 {

  /**
   * NOTE:<br>
   * All operations are of:<br>
   * Time: O(1)
   */

  /**
   * NOTE:<br>
   * Space: O(n)
   */

  /**
   * {value, minValue}
   */
  private List<int[]> stack;

  public MinStack_155() {
    stack = new ArrayList<>();
  }

  public void push(int val) {
    int min;
    if (stack.isEmpty()) {
      min = val;
    } else {
      int lastMin = stack.get(stack.size() - 1)[1];
      min = Math.min(val, lastMin);
    }
    stack.add(new int[] { val, min });
  }

  public void pop() {
    if (stack.isEmpty()) {
      return;
    }
    stack.remove(stack.size() - 1);
  }

  public int top() {
    if (stack.isEmpty()) {
      return -1;
    }
    return stack.get(stack.size() - 1)[0];
  }

  public int getMin() {
    if (stack.isEmpty()) {
      return -1;
    }
    return stack.get(stack.size() - 1)[1];
  }

}
