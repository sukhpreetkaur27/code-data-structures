package com.code.ds.striver.linkedlist;

public class _1_SwapPairs {

  class Node {
    int data;
    Node next;

    Node() {

    }

    Node(int key) {
      data = key;
      next = null;
    }

    Node(int key, Node node) {
      data = key;
      next = node;
    }
  }

  /**
   * Time: O(n)<br>
   * Space: O(n)
   * @param head
   * @return
   */
  public Node pairwiseSwap(Node head) {
    if (head == null || head.next == null) {
      return head;
    }
    Node first = head;
    Node second = head.next;
    first.next = pairwiseSwap(second.next);
    second.next = first;
    return second;
  }

}
