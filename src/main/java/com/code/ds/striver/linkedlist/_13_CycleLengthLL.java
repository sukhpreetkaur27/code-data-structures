package com.code.ds.striver.linkedlist;

/**
 * Find length of Loop
 * 
 * @author sukh
 *
 */
public class _13_CycleLengthLL {

  public int length(_ListNode head) {
    if (head == null || head.next == null) {
      return 0;
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
      return 0;
    }
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    int size = 0;
    do {
      slow = slow.next;
      size++;
    } while (slow != fast);
    return size;
  }

}
