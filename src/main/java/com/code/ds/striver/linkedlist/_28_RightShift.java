package com.code.ds.striver.linkedlist;

/**
 * Given the head of a linked list, rotate the list to the right by k places.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]
 

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
 * 
 * @author sukh
 *
 */
public class _28_RightShift {

  public _ListNode rightShift(_ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }
    /**
     * 1. Create a cycle --> point last to head <br>
     * 2. point (n-k)-th node to null
     */
    _ListNode newHead;
    _ListNode tail = head;
    int n = 0;
    while (tail.next != null) {
      n++;
      tail = tail.next;
    }
    tail.next = head;

    k %= n;

    tail = head;
    for (int i = 1; i <= n - k; i++) {
      tail = tail.next;
    }
    newHead = tail.next;
    tail.next = null;

    return newHead;
  }

}
