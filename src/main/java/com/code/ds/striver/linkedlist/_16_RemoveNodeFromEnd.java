package com.code.ds.striver.linkedlist;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 * 
 * @author sukh
 *
 */
public class _16_RemoveNodeFromEnd {

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * @param head
   * @param n
   * @return
   */
  public _ListNode remove(_ListNode head, int n) {
    _ListNode curr = head;
    int size = 0;
    while (curr != null) {
      size++;
      curr = curr.next;
    }

    /**
     * if single node
     */
    if (size == 1) {
      return null;
    }
    /**
     * if first node to be deleted
     */
    if (size == n) {
      return head.next;
    }

    int pos = size - n;
    curr = head;
    int i = 1;
    while (i++ != pos) {
      curr = curr.next;
    }
    curr.next = curr.next.next;
    return head;
  }

}
