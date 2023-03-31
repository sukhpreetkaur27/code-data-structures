package com.code.ds.linkedlist;

public class ReverseSinglyLL {

  /**
   * Time: O(n)
   * Space: O(1)
   * @param head
   * @return
   */
  public SinglyNode<Integer> reverseList(SinglyNode<Integer> head) {
    SinglyNode<Integer> prev = null;
    SinglyNode<Integer> curr = head, next;
    while (curr != null) {
      next = curr.getNext();
      curr.setNext(prev);
      prev = curr;
      curr = next;
    }
    return prev;
  }

}
