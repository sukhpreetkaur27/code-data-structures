package com.code.ds.striver.linkedlist;

public class _11_CycleLL {

  public boolean cycle(_ListNode head) {
    _ListNode slow = head;
    _ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

}
