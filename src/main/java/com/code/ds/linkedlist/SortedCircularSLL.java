package com.code.ds.linkedlist;

public class SortedCircularSLL {

  public SinglyNode<Integer> insert(SinglyNode<Integer> head, int insertVal) {
    if (head == null) {
      SinglyNode<Integer> node = new SinglyNode<>(insertVal);
      node.setNext(node);
      return node;
    }

    SinglyNode<Integer> prev = head, curr = head.getNext();
    boolean insert = false;

    do {
      if (prev.getData() <= insertVal && insertVal <= curr.getData()) {
        // in-between
        insert = true;
      } else if (prev.getData() > curr.getData()) {
        // between tail and head
        if (prev.getData() <= insertVal || insertVal <= curr.getData()) {
          insert = true;
        }
      }
      if (insert) {
        prev.setNext(new SinglyNode<Integer>(insertVal, curr));
        return head;
      }
      prev = curr;
      curr = curr.getNext();
    } while (prev != head);
    // all elements are same
    prev.setNext(new SinglyNode<Integer>(insertVal, curr));
    return head;
  }

}
