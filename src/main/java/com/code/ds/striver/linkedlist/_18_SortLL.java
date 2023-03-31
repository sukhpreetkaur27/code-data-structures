package com.code.ds.striver.linkedlist;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.

 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
 

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 * 
 * @author sukh
 *
 */
public class _18_SortLL {

  /**
   * Merge Sort Algo
   * 
   * Time: O(n log n) <br>
   * Space: O(n log n) <br>
   * as the problem is recursive
   * @param head
   * @return
   */
  public _ListNode sort(_ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    _ListNode mid = getMid(head);
    _ListNode left = sort(head);
    _ListNode right = sort(mid);
    return merge(left, right);
  }

  private _ListNode merge(_ListNode left, _ListNode right) {
    _ListNode dummy = new _ListNode(0);
    _ListNode tail = dummy;
    while (left != null && right != null) {
      if (left.data < right.data) {
        tail.next = left;
        left = left.next;
      } else {
        tail.next = right;
        right = right.next;
      }
      tail = tail.next;
    }
    tail.next = (left != null) ? left : right;
    return dummy.next;
  }

  private _ListNode getMid(_ListNode head) {
    _ListNode slow = head;
    _ListNode fast = head;
    _ListNode prev = null;

    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    prev.next = null;
    return slow;
  }

}
