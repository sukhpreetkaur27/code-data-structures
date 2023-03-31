package com.code.ds.striver.linkedlist;

/**
 * Given a doubly linked list of n elements. The task is to reverse the doubly linked list.

Example 1:

Input:
LinkedList: 3 <--> 4 <--> 5
Output: 5 4 3
Example 2:

Input:
LinkedList: 75 <--> 122 <--> 59 <--> 196
Output: 196 59 122 75
 * 
 * @author sukh
 *
 */
public class _8_ReverseDLL {

  public _2_ListNode reverse(_2_ListNode head) {
    _2_ListNode temp = null;
    _2_ListNode curr = head;
    _2_ListNode next;
    while (curr != null) {
      next = curr.next;
      curr.prev = curr.next;
      curr.next = temp;
      temp = curr;
      curr = next;
    }
    return temp;
  }

}
