package com.code.ds.striver.linkedlist;

/**
 * Given a sorted doubly linked list containing n nodes. The problem is removing duplicate nodes from the given list.
 * 
 * @author sukh
 *
 */
public class _26_RemoveDuplicatesDLL {

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * @param head
   * @return
   */
  public _2_ListNode remove(_2_ListNode head) {
    _2_ListNode curr = head;
    _2_ListNode next;
    while (curr != null) {
      next = curr.next;
      if (next != null && next.data == curr.data) {
        delete(next);
        next = curr.next;
      }
      curr = next;
    }
    return head;
  }

  private void delete(_2_ListNode node) {
    _2_ListNode prev = node.prev;
    _2_ListNode next = node.next;
    prev.next = next;
    if (next != null) {
      next.prev = prev;
    }
    node.prev = null;
    node.next = null;
  }

}
