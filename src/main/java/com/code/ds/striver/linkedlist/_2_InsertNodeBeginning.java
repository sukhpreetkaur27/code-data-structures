package com.code.ds.striver.linkedlist;

public class _2_InsertNodeBeginning {

  /**
   * Time: O(1) <br>
   * Space: O(1)
   * @param head
   * @param data
   * @return
   */
  public static _ListNode insertBeginning(_ListNode head, int data) {
    _ListNode node = new _ListNode(data);
    node.next = head;
    return node;
  }

  public static void main(String[] args) {
    _ListNode head = null;
    head = insertBeginning(head, 40);
    head = insertBeginning(head, 30);
    head = insertBeginning(head, 20);
    head = insertBeginning(head, 10);
    System.out.println("Linked List before inserting at beginning: ");
    print(head);
    head = insertBeginning(head, 0);
    System.out.println("Linked List after inserting at beginning: ");
    print(head);
  }

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * @param head
   */
  public static void print(_ListNode head) {
    _ListNode curr = head;
    while (curr != null) {
      System.out.print(curr.data + "-->");
      curr = curr.next;
    }
    System.out.print("null");
    System.out.println();
  }

}
