package com.code.ds.linkedlist;

/**
 * Rotate List
 * 
 * 
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
 * @author sukh
 *
 */
public class RotateList_61 {

  /**
   * Time:O(n)<br>
   * Space:O(1)
   * @param <T>
   * @param head
   * @param k
   * @return
   */
  public <T> SinglyNode<T> rotateRight(SinglyNode<T> head, int k) {
    if (head == null || head.getNext() == null) {
      return head;
    }
    int n;
    SinglyNode<T> tail = head;
    // Calculate the length of the LL
    for (n = 1; tail.getNext() != null; n++) {
      tail = tail.getNext();
    }
    // Make it circular
    tail.setNext(head);
    // calculate the shifts so that k<n
    k %= n;

    // Shift n-k times the head pointer
    SinglyNode<T> newTail = head;
    for (int i = 1; i < n - k; i++) {
      newTail = newTail.getNext();
    }
    SinglyNode<T> newHead = newTail.getNext();
    // Release the circular LL
    newTail.setNext(null);
    return newHead;
  }

}
