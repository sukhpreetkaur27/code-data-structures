package com.code.ds.striver.linkedlist;

public class _3_DeleteLastNode {

  public static void deleteLast(_ListNode head) {
    if (head == null) {
      return;
    }
    if (head.next == null) {
      head = null;
      return;
    }

    _ListNode curr = head, prev = null;
    while (curr.next != null) {
      prev = curr;
      curr = curr.next;
    }
    prev.next = null;
  }

}
