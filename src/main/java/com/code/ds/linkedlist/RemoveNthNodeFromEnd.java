package com.code.ds.linkedlist;

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

 * @author sukh
 *
 */
public class RemoveNthNodeFromEnd {

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * @param <T>
   * @param head
   * @param n
   * @return
   */
  public <T> SinglyNode<T> removeNthNodeFromEnd(SinglyNode<T> head, int n) {
    // find the length
    int len = 0;
    SinglyNode<T> curr = head;
    while (curr != null) {
      curr = curr.getNext();
      len++;
    }

    if (len == 0) {
      return null;
    } else if (len == n) {
      return head;
    }

    // move to one before the node to be removed
    int pos = len - n;
    int i = 1;
    curr = head;
    while (i++ != pos) {
      curr = curr.getNext();
    }
    // remove the nth node
    curr.setNext(curr.getNext().getNext());
    return head;
  }

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * @param <T>
   * @param head
   * @param n
   * @return
   */
  public <T> SinglyNode<T> removeNthNodeFromEndLeetCodeSol(SinglyNode<T> head, int n) {
    SinglyNode<T> dummy = new SinglyNode<T>();
    dummy.setNext(head);

    SinglyNode<T> first = dummy;
    SinglyNode<T> second = dummy;

    for (int i = 1; i <= n + 1; i++) {
      first = first.getNext();
    }

    while (first != null) {
      first = first.getNext();
      second = second.getNext();
    }
    second.setNext(second.getNext().getNext());
    return dummy.getNext();
  }

}
