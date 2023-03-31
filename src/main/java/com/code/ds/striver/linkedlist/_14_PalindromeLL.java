package com.code.ds.striver.linkedlist;

/**
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 * 
 * @author sukh
 *
 */
public class _14_PalindromeLL {

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * @param head
   * @return
   */
  public boolean isPalindrome(_ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    _ListNode slow = head;
    _ListNode fast = head;
    /**
     * this check is specifically to deal with even length LL
     */
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    /**
     * 1. slow = mid node <br>
     * 2. reverse the second half
     */
    _ListNode head2 = reverse(slow.next);
    _ListNode ptr1 = head2;
    _ListNode ptr2 = head;
    while (ptr1 != null) {
      if (ptr2.data == ptr1.data) {
        ptr1 = ptr1.next;
        ptr2 = ptr2.next;
        continue;
      }
      slow.next = reverse(head2);
      return false;
    }
    slow.next = reverse(head2);
    return true;
  }

  private _ListNode reverse(_ListNode head) {
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
