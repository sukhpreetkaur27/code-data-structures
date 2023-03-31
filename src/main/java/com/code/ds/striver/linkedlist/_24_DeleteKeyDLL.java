package com.code.ds.striver.linkedlist;

/**
 * Delete all occurrences of a key
 * 
 * @author sukh
 *
 */
public class _24_DeleteKeyDLL {

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * @param head
   * @param key
   * @return
   */
  public _2_ListNode deleteMySolution(_2_ListNode head, int key) {
    if (head == null) {
      return null;
    }

    _2_ListNode dummy = new _2_ListNode(0);
    _2_ListNode tail = dummy;
    _2_ListNode curr = head;
    _2_ListNode next;
    while (curr != null) {
      next = curr.next;
      if (curr.data == key) {
        if (next != null) {
          curr.next.prev = tail;
        }
        curr.next = null;
        curr.prev = null;
        tail.next = next;
      } else {
        tail.next = curr;
        tail = curr;
      }
      curr = next;
    }
    return dummy.next;
  }

  public _2_ListNode delete(_2_ListNode head, int key) {
    if (head == null) {
      return null;
    }

    _2_ListNode curr = head;
    _2_ListNode next;
    while (curr != null) {
      next = curr.next;

      if (curr.data == key) {
        head = delete(head, curr);
      }

      curr = next;
    }
    return head;
  }

  private _2_ListNode delete(_2_ListNode head, _2_ListNode node) {
    if (head == null || node == null) {
      return head;
    }

    if (head == node) {
      return head.next;
    }

    _2_ListNode next = node.next;
    _2_ListNode prev = node.prev;

    if (next != null) {
      next.prev = prev;
    }
    prev.next = next;

    node.prev = null;
    node.next = null;
    return head;
  }

}
