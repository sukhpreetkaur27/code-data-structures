package com.code.ds.linkedlist;

public class DoublyNode<T> {

  private T data;
  private DoublyNode<T> prev;
  private DoublyNode<T> next;

  public DoublyNode() {
    // default ctr
  }

  public DoublyNode(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public DoublyNode<T> getPrev() {
    return prev;
  }

  public void setPrev(DoublyNode<T> prev) {
    this.prev = prev;
  }

  public DoublyNode<T> getNext() {
    return next;
  }

  public void setNext(DoublyNode<T> next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return "DoublyNode [data=" + data + ", prev=" + prev + ", next=" + next + "]";
  }

}
