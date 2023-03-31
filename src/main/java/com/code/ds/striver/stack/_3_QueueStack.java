package com.code.ds.striver.stack;

import java.util.ArrayDeque;

/**
 * Implement a last-in-first-out (LIFO) stack using only two queues. 
 * The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:

You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) 
as long as you use only a queue's standard operations.
 

Example 1:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False
 

Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, top, and empty.
All the calls to pop and top are valid.
 

Follow-up: Can you implement the stack using only one queue?
 * 
 * @author sukh
 *
 */
public class _3_QueueStack {

  private ArrayDeque<Integer> q;
  private int size;

  public _3_QueueStack() {
    q = new ArrayDeque<>();
  }

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * @param x
   */
  public void push(int x) {
    q.add(x);
    for (int i = 0; i <= size - 1; i++) {
      q.add(q.peek());
      q.poll();
    }
    size++;
  }

  /**
   * Time: O(1)
   * @return
   */
  public int pop() {
    if (size > 0) {
      size--;
      return q.poll();
    }
    return -1;
  }

  /**
   * Time: O(1)
   * @return
   */
  public int top() {
    if (size > 0) {
      return q.peek();
    }
    return -1;
  }

  /**
   * Time: O(1)
   * @return
   */
  public boolean empty() {
    return size == 0;
  }

}
