package com.code.ds.striver.stack;

/**
 * Write a program to implement a Stack using Array. Your task is to use the class as shown in the comments in the code editor 
 * and complete the functions push() and pop() to implement a stack. 

Example 1:

Input: 
push(2)
push(3)
pop()
push(4) 
pop()
Output: 3, 4
Explanation: 
push(2)    the stack will be {2}
push(3)    the stack will be {2 3}
pop()      poped element will be 3,
           the stack will be {2}
push(4)    the stack will be {2 4}
pop()      poped element will be 4
Example 2:

Input: 
pop()
push(4)
push(5)
pop()
Output: -1, 5
Your Task:
You are required to complete two methods push() and pop(). The push() method takes one argument, an integer 'x' to be pushed into the stack 
and pop() which returns an integer present at the top and popped out from the stack. If the stack is empty then return -1 from the pop() method.

Expected Time Complexity : O(1) for both push() and pop().
Expected Auixilliary Space : O(1) for both push() and pop().

Constraints:
1 <= Q <= 100
1 <= x <= 100
 * 
 * @author sukh
 *
 */
public class _1_ArrayStack {

  private int top;
  private int arr[] = new int[1000];

  public _1_ArrayStack() {
    top = -1;
  }

  /*
   * Function to push an integer into the stack.
   */
  public void push(int a) {
    if (size() < arr.length) {
      arr[++top] = a;
    }
  }

  public boolean isEmpty() {
    return top == -1;
  }

  public int size() {
    return top + 1;
  }

  /*
   * Function to remove an item from top of the stack.
   */
  public int pop() {
    // Your code here
    if (isEmpty()) {
      return -1;
    }
    int pop = arr[top];
    arr[top] = 0;
    top--;
    return pop;
  }

}
