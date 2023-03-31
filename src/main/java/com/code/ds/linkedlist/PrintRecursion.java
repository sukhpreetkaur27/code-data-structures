package com.code.ds.linkedlist;

public class PrintRecursion {

  public <T> void print(SinglyNode<T> node) {
    if (node == null) {
      return;
    }
    System.out.println(node.getData());
    node = node.getNext();
    print(node);
  }

  public <T> void reversePrint(SinglyNode<T> node) {
    if (node == null) {
      return;
    }
    node = node.getNext();
    reversePrint(node);
    System.out.println(node.getData());
  }

}
