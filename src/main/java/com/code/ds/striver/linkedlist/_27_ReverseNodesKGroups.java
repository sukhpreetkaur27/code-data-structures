package com.code.ds.striver.linkedlist;

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
 

Follow-up: Can you solve the problem in O(1) extra memory space?
 * 
 * @author sukh
 *
 */
public class _27_ReverseNodesKGroups {

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * @param head
   * @param k
   * @return
   */
  public _ListNode reverse(_ListNode head, int k) {
    int n = 0;
    _ListNode curr = head;
    while (curr != null) {
      curr = curr.next;
      n++;
    }

    int end = n / k;

    _ListNode dummy = new _ListNode(0);
    _ListNode tail = dummy;
    _ListNode newHead;
    curr = head;
    int i = 1;
    while (i <= end) {
      newHead = curr.next;
      curr = reverse(curr, k, tail);
      tail = newHead;
      i++;
    }
    tail.next = curr;
    return dummy.next;
  }

  private _ListNode reverse(_ListNode head, int k, _ListNode tail) {
    _ListNode curr = head, prev = null, next;
    int i = 1;
    while (i <= k && curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
      i++;
    }
    tail.next = prev;
    return curr;
  }

}
