package com.code.ds.striver.linkedlist;

/**
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

 

Example 1:


Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
Example 2:

Input: head = [], val = 1
Output: []
Example 3:

Input: head = [7,7,7,7], val = 7
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 104].
1 <= Node.val <= 50
0 <= val <= 50
 * 
 * @author sukh
 *
 */
public class _6_DeleteElements {

  public _ListNode delete(_ListNode head, int val) {
    if (head == null) {
      return null;
    }
    /**
     * dummy node
     */
    _ListNode dummy = new _ListNode(0);
    dummy.next = head;

    _ListNode curr = head, prev = dummy;
    while (curr != null) {
      if (curr.data == val) {
        prev.next = curr.next;
      } else {
        prev = curr;
      }
      curr = curr.next;
    }
    return dummy.next;
  }

}
