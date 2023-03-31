package com.code.ds.linkedlist;

/**
 * Space: O(1)
 * @author sukh
 *
 */
public class DoublyLinkedList {

  private int size;
  private DoublyNode<Integer> head; // sentinel head
  private DoublyNode<Integer> tail; // sentinel tail

  public DoublyLinkedList() {
    size = 0;
    head = new DoublyNode<Integer>(0);
    tail = new DoublyNode<Integer>(0);
    /*
     * initialize references for doubly LL
     */
    head.setNext(tail);
    tail.setPrev(head);
  }

  /**
   * Time: O(min(k,N-k)
   * @param index
   * @return
   */
  public int get(int index) {
    if (index < 0 || index >= size) {
      return -1;
    }

    DoublyNode<Integer> curr = head;
    if (index + 1 < size - index) {
      // traverse from head
      for (int i = 0; i < index + 1; i++) {
        curr = curr.getNext();
      }
    } else {
      // traverse from tail
      curr = tail;
      for (int i = 0; i < size - index; i++) {
        curr = curr.getPrev();
      }
    }
    return curr.getData();
  }

  /**
   * Time: O(1)
   * @param data
   */
  public void addAtHead(int data) {
    DoublyNode<Integer> pred = head;
    DoublyNode<Integer> succ = head.getNext();
    size++;
    DoublyNode<Integer> toAdd = new DoublyNode<Integer>(data);
    toAdd.setNext(succ);
    toAdd.setPrev(pred);
    pred.setNext(toAdd);
    succ.setPrev(toAdd);
  }

  /**
   * Time: O(1)
   * @param data
   */
  public void addAtTail(int data) {
    DoublyNode<Integer> succ = tail;
    DoublyNode<Integer> pred = tail.getPrev();
    size++;
    DoublyNode<Integer> toAdd = new DoublyNode<Integer>(data);
    toAdd.setNext(succ);
    toAdd.setPrev(pred);
    pred.setNext(toAdd);
    succ.setPrev(toAdd);
  }

  /**
   * Time: O(min(k,N-k))
   * @param index
   * @param data
   */
  public void addAtIndex(int index, int data) {
    // edge case
    if (index < 0 || index > size) {
      return;
    }

    DoublyNode<Integer> pred, succ;
    if (index < size - index) {
      // traverse from head
      pred = head;
      for (int i = 0; i < index; i++) {
        pred = pred.getNext();
      }
      succ = pred.getNext();
    } else {
      // traverse from tail
      succ = tail;
      for (int i = 0; i < size - index; i++) {
        succ = succ.getPrev();
      }
      pred = succ.getPrev();
    }

    size++;
    DoublyNode<Integer> toAdd = new DoublyNode<Integer>(data);
    toAdd.setNext(succ);
    toAdd.setPrev(pred);
    pred.setNext(toAdd);
    succ.setPrev(toAdd);
  }

  /**
   * Time: O(min(k,N-k))
   * @param index
   */
  public void deleteAtIndex(int index) {
    // edge case
    if (index < 0 || index >= size) {
      return;
    }

    DoublyNode<Integer> pred, succ;
    if (index < size - index) {
      // traverse from head
      pred = head;
      for (int i = 0; i < index; i++) {
        pred = pred.getNext();
      }
      succ = pred.getNext().getNext();
    } else {
      // traverse from tail
      succ = tail;
      /**
       * very important as index is 0-based
       */
      for (int i = 0; i < size - index - 1; i++) {
        succ = succ.getPrev();
      }
      pred = succ.getPrev().getPrev();
    }
    size--;
    pred.setNext(succ);
    succ.setPrev(pred);
  }

}
