package com.code.ds.striver.linkedlist;

/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

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
 * 
 * @author sukh
 *
 */
public class _22_AddTwoNumbers {

  /**
   * Time: O(max(n1,n2)) <br>
   * Space: O(max(n1,n2))
   * @param l1
   * @param l2
   * @return
   */
  public _ListNode add(_ListNode l1, _ListNode l2) {
    /**
     * Numbers are in reversed order <br>
     * Return the o/p in reverse order
     */
    _ListNode dummy = new _ListNode(0);
    _ListNode tail = dummy;
    _ListNode p1 = l1, p2 = l2;
    int carry = 0, sum = 0, x, y;
    while (p1 != null || p2 != null || carry != 0) {
      x = p1 != null ? p1.data : 0;
      y = p2 != null ? p2.data : 0;
      sum = x + y + carry;
      _ListNode node = new _ListNode(sum % 10);
      tail.next = node;
      tail = node;
      carry = sum / 10;
      if (p1 != null) {
        p1 = p1.next;
      }
      if (p2 != null) {
        p2 = p2.next;
      }
    }
    return dummy.next;
  }

}
