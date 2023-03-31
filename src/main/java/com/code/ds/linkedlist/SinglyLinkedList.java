package com.code.ds.linkedlist;

/**
 * Space: O(1)
 * @author sukh
 *
 */
public class SinglyLinkedList {

  private int size; // size of the LL
  private SinglyNode<Integer> head; // sentinel head node

  public SinglyLinkedList() {
    // initialize the LL
    // so that it isn't empty ever
    // it always hold the sentinel node (head)
    size = 0;
    head = new SinglyNode<>(0);
  }

  /**
   * Time: O(k); k = index
   * @param index
   * @param data
   */
  public void addAtIndex(int index, int data) {
    // edge case
    if (index < 0 || index > size) {
      return;
    }

    ++size;

    SinglyNode<Integer> pred = head;
    for (int i = 0; i < index; i++) {
      pred = pred.getNext();
    }
    size++;
    SinglyNode<Integer> toAdd = new SinglyNode<>(data);
    toAdd.setNext(pred.getNext());
    pred.setNext(toAdd);
  }

  /**
   * Time: O(1)
   * @param data
   */
  public void addAtHead(int data) {
    addAtIndex(0, data);
  }

  /**
   * Time: O(n)
   * @param data
   */
  public void addAtTail(int data) {
    addAtIndex(size, data);
  }

  /**
   * Time: O(k); k = index
   * @param index
   * @return
   */
  public int get(int index) {
    // edge case
    if (index < 0 || index >= size) {
      return -1;
    }

    SinglyNode<Integer> curr = head;
    for (int i = 0; i < index + 1 && curr != null; i++) {
      curr = curr.getNext();
    }

    return curr.getData();
  }
  
  public int getTail() {
    SinglyNode<Integer> curr = head;
    while (curr != null && curr.getNext() != null) {
      curr = curr.getNext();
    }
    return curr.getData();
  }

  /**
   * Time: O(k); k = index
   * @param index
   */
  public void deleteAtIndex(int index) {
    // edge case
    if (index < 0 || index >= size) {
      return;
    }

    --size;

    SinglyNode<Integer> pred = head;
    for (int i = 0; i < index; i++) {
      pred = pred.getNext();
    }

    pred.setNext(pred.getNext().getNext());
  }

}
