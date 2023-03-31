package com.code.ds.linkedlist;

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
 * @author sukh
 *
 */
public class PalindromeSinglyLL {

  /**
   * Time: O(n)
   * Space: O(1)
   * @param <T>
   * @param head
   * @return
   */
  public <T> boolean isPalindrome(SinglyNode<T> head) {
    if (head == null) {
      return false;
    }

    SinglyNode<T> firstHalfEnd = getEndofFirstHalf(head);
    SinglyNode<T> secondHalfStart = reverseList(firstHalfEnd.getNext());

    SinglyNode<T> ptr1 = head, ptr2 = secondHalfStart;
    while (ptr2 != null) {
      if (ptr1.getData() != ptr2.getData()) {
        return false;
      }
      ptr1 = ptr1.getNext();
      ptr2 = ptr2.getNext();
    }

    firstHalfEnd.setNext(reverseList(secondHalfStart));

    return true;
  }

  public <T> SinglyNode<T> getEndofFirstHalf(SinglyNode<T> head) {
    SinglyNode<T> slow = head, fast = head;
    while (fast.getNext() != null && fast.getNext().getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
    }
    return slow;
  }

  public <T> SinglyNode<T> reverseList(SinglyNode<T> head) {
    SinglyNode<T> curr = head, prev = null, next;
    while (curr != null) {
      next = curr.getNext();
      curr.setNext(prev);
      prev = curr;
      curr = next;
    }
    return prev;
  }

}
