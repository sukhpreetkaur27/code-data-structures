package com.code.ds.binarytree;

class Node {

  private int val;
  private Node prev;
  private Node child; // Left Sub-Tree
  private Node next; // Right Sub-Tree

  public Node() {

  }

  public Node(int val) {
    this.val = val;
  }

  public int getVal() {
    return val;
  }

  public void setVal(int val) {
    this.val = val;
  }

  public Node getPrev() {
    return prev;
  }

  public void setPrev(Node prev) {
    this.prev = prev;
  }

  public Node getChild() {
    return child;
  }

  public void setChild(Node child) {
    this.child = child;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return "Node [val=" + val + ", prev=" + prev + ", child=" + child + ", next=" + next + "]";
  }

}
