package com.code.ds.striver.linkedlist;

public class _10_ReverseLL {

  public _ListNode reverse(_ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    _ListNode prev = null;
    _ListNode curr = head;
    _ListNode next;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  public _ListNode reverseRecursive(_ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    _ListNode prev = reverseRecursive(head.next);
    head.next.next = head;
    head.next = null;
    
    return prev;

  }

}
