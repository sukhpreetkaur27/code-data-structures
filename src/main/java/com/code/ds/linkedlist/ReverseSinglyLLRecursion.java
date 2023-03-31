package com.code.ds.linkedlist;

public class ReverseSinglyLLRecursion {

//  public void reverse(SinglyNode<T> curr) {
//    if (curr.getNext() == null) {
//      head = curr;
//      return;
//    }
//    SinglyNode<T> next = curr.getNext();
//    next.setNext(curr);
//    // move null from the last node to the first
//    curr.setNext(null);
//  }

  public <T> SinglyNode<T> reverse(SinglyNode<T> head) {
    if (head == null || head.getNext() == null) {
      return head;
    }
    SinglyNode<T> node = reverse(head);
    head.getNext().setNext(head);
    head.setNext(null);
    return node;
  }

}
