package com.code.ds.striver.linkedlist;

public class _9_MiddleOfLL {

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * @param head
   * @return
   */
  public _ListNode middle(_ListNode head) {
    _ListNode slow = head;
    _ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

}
