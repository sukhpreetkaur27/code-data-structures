package com.code.ds.linkedlist;

/**
 * You are given two non-empty linked lists representing two non-negative integers. <br>
 * The digits are stored in reverse order, and each of their nodes contains a single digit. <br>
 * Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 * @author sukh
 *
 */
public class Add2NumsReverseOrder {

  /**
   * Time: O(max(m,n))<br>
   * Space: O(max(m,n)+1)
   * @param l1
   * @param l2
   * @return
   */
  public SinglyNode<Integer> addTwoNumbers(SinglyNode<Integer> l1, SinglyNode<Integer> l2) {
    SinglyNode<Integer> head = new SinglyNode<>(), tail = head;
    int x, y, sum = 0, carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      x = l1 != null ? l1.getData() : 0;
      y = l2 != null ? l2.getData() : 0;

      sum = x + y + carry;
      carry = sum / 10;

      SinglyNode<Integer> node = new SinglyNode<>(sum % 10);
      tail.setNext(node);
      tail = node;

      l1 = l1 != null ? l1.getNext() : null;
      l2 = l2 != null ? l2.getNext() : null;
    }
    return head.getNext();
  }

}
