package com.code.ds.striver.linkedlist;

public class _12_StartOfCycleLL {

  public _ListNode start(_ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }

    _ListNode slow = head;
    _ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        break;
      }
    }
    if (slow != fast) {
      return null;
    }
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }

}
