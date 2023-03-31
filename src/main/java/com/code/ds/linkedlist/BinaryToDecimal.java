package com.code.ds.linkedlist;

public class BinaryToDecimal {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param head
   * @return
   */
  public int getDecimal(SinglyNode<Integer> head) {
    if (head == null) {
      return 0;
    }
    int num = 0;
    SinglyNode<Integer> curr = head;
    while (curr != null) {
      num = (num << 1) | curr.getData(); // num = num * 2 + curr.getData();
      curr = curr.getNext();
    }
    return num;
  }

}
