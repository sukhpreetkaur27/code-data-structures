package com.code.ds.striver.stack;

import java.util.ArrayDeque;

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
public class _7_MinStack {
  
  /**
   * Time: O(1) <br>
   * Space: O(N)
   */
  
  /**
   * NOTE: <br>
   * use Long data type to avoid overflows due to multiplication by 2
   */

  private ArrayDeque<Long> stack;
  private Long min;

  public _7_MinStack() {
    stack = new ArrayDeque<>();
  }

  public void push(int value) {
    Long val = Long.valueOf(value);
    if (stack.isEmpty()) {
      stack.push(val);
      min = val;
      return;
    }
    if (val > min) {
      stack.push(val);
    } else {
      /**
       * push the modified value <br>
       * update min to the current value
       */
      long modifiedVal = 2l * val - min;
      stack.push(modifiedVal);
      min = val;
    }
  }

  public void pop() {
    if (stack.isEmpty()) {
      return;
    }
    long pop = stack.pop();
    if (pop < min) {
      /**
       * top == modified value <br>
       * min == actual value to be popped
       */
      /**
       * update min
       */
      min = 2l * min - pop;
    }
  }

  public int top() {
    if (stack.isEmpty()) {
      return -1;
    }
    Long top = stack.peek();
    if (top < min) {
      /**
       * top == modified value <br>
       * min == actual value to be pushed
       */
      return min.intValue();
    }
    return top.intValue();
  }

  public int getMin() {
    if (stack.isEmpty()) {
      return -1;
    }
    return min.intValue();
  }

}
