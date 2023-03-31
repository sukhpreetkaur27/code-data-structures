package com.code.ds.striver.linkedlist;

/**
 * Add 1 to a number represented as linked list

Example 1:

Input:
LinkedList: 4->5->6
Output: 457 
Example 2:

Input:
LinkedList: 1->2->3
Output: 124 
 * 
 * @author sukh
 *
 */
public class _21_AddOne {

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * @param head
   * @return
   */
  public _ListNode addOne(_ListNode head) {
    /**
     * Algorithm: <br>
     * 1. Reverse list <br>
     * 2. Add one <br>
     * 3. Reverse list
     */
    head = reverse(head);
    _ListNode curr = head;
    while (curr != null) {
      curr.data = curr.data + 1;
      /**
       * If addition of one to a digit (0-9) > 10, we may need a new node <br>
       * else, the nodes are sufficient and re-reverse the list
       */

      if (curr.data < 10) {
        return reverse(head);
      } else {
        curr.data = 0;
      }

      if (curr.next == null) {
        break;
      } else {
        curr = curr.next;
      }
    }

    curr.next = new _ListNode(1);
    return reverse(head);
  }

  public _ListNode reverse(_ListNode head) {
    _ListNode curr = head, prev = null, next;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

}
