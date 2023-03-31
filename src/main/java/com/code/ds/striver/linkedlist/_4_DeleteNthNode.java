package com.code.ds.striver.linkedlist;

public class _4_DeleteNthNode {

  public static _ListNode delete(_ListNode head, int x) {
    /**
     * Assume that list is not empty <br>
     * 2 <= n <= 100 <br>
     * 1 <= x <= n
     */
    _ListNode curr = head;
    if (x == 1) {
      head = curr.next;
      curr.next = null;
      return head;
    }

    int i = 2;
    while (i < x) {
      /**
       * go till the previous node
       */
      curr = curr.next;
      i++;
    }
    curr.next = curr.next.next;
    return head;
  }

}
