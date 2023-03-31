package com.code.ds.striver.linkedlist;

/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
Example 2:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]
Example 3:

Input: l1 = [0], l2 = [0]
Output: [0]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 

Follow up: Could you solve it without reversing the input lists?
 * 
 * @author sukh
 *
 */
public class _23_AddTwoNumbers_NoReversal {

  /**
   * Time: O(n1 + n2) <br>
   * Space: O(max(n1,n2))
   * @param l1
   * @param l2
   * @return
   */
  public _ListNode add(_ListNode l1, _ListNode l2) {
    /**
     * Algorithm: <br>
     * 1. find the length of the 2 lists <br>
     * 2. Add without carry taken forward <br>
     * * build this list in reverse order <br>
     * 3. Split the carry <br>
     * * build this list in reverse order <br>
     */
    int n1 = 0, n2 = 0;
    _ListNode p1 = l1, p2 = l2;
    while (p1 != null) {
      n1++;
      p1 = p1.next;
    }
    while (p2 != null) {
      n2++;
      p2 = p2.next;
    }

    _ListNode head = null;
    int sum;
    while (n1 > 0 && n2 > 0) {
      sum = 0;
      if (n1 >= n2) {
        sum += l1.data;
        l1 = l1.next;
        n1--;
      }
      if (n1 < n2) {
        sum += l2.data;
        l2 = l2.next;
        n2--;
      }
      _ListNode node = new _ListNode(sum);
      node.next = head;
      head = node;
    }

    _ListNode curr = head;
    head = null;
    int carry = 0, x;
    while (curr != null) {
      x = curr != null ? curr.data : 0;
      sum = x + carry;
      _ListNode node = new _ListNode(sum % 10);
      carry = sum / 10;
      node.next = head;
      head = node;
      if (curr != null) {
        curr = curr.next;
      }
    }

    return head;
  }

}
