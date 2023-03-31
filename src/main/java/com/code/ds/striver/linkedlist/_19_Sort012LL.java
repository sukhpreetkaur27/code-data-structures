package com.code.ds.striver.linkedlist;

/**
 * Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. 
 * The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.

Example 1:

Input:
N = 8
value[] = {1,2,2,1,2,0,2,2}
Output: 0 1 1 2 2 2 2 2
Explanation: All the 0s are segregated
to the left end of the linked list,
2s to the right end of the list, and
1s in between.
Example 2:

Input:
N = 4
value[] = {2,2,0,1}
Output: 0 1 2 2
Explanation: After arranging all the
0s,1s and 2s in the given format,
the output will be 0 1 2 2.
 * 
 * @author sukh
 *
 */
public class _19_Sort012LL {

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * @param head
   * @return
   */
  public _ListNode sort(_ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    _ListNode zero = new _ListNode(0);
    _ListNode one = new _ListNode(0);
    _ListNode two = new _ListNode(0);

    _ListNode tail0 = zero;
    _ListNode tail1 = one;
    _ListNode tail2 = two;

    _ListNode curr = head;
    /**
     * Add each node to the tail of its respective tail pointer
     */
    while (curr != null) {
      if (curr.data == 0) {
        tail0.next = curr;
        tail0 = tail0.next;
      } else if (curr.data == 1) {
        tail1.next = curr;
        tail1 = tail1.next;
      } else if (curr.data == 2) {
        tail2.next = curr;
        tail2 = tail2.next;
      }
      curr = curr.next;
    }

    /**
     * Link all the tail pointers in a proper sequence
     */
    tail0.next = (one.next != null) ? one.next : two.next;
    tail1.next = two.next;
    tail2.next = null;
    return zero.next;
  }

}
