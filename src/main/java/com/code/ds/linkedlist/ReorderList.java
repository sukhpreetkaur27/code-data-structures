package com.code.ds.linkedlist;

/**
 * You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
 * @author sukh
 *
 */
public class ReorderList {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param head
   */
  public void reorder(SingleNode head) {
    if (head == null) {
      return;
    }

    SingleNode mid = getMid(head);
    SingleNode head2 = reverseList(mid);
    mergeLists(head, head2);
  }

  private void mergeLists(SingleNode head1, SingleNode head2) {
    SingleNode ptr1 = head1;
    SingleNode ptr2 = head2;
    SingleNode temp;
    while (ptr2.getNext() != null) // To avoid cycle
    {
      System.out.print("ptr1 = ");
      print(ptr1);
      System.out.print("ptr2 = ");
      print(ptr2);

      temp = ptr1.getNext();
      ptr1.setNext(ptr2);
      ptr1 = temp;

      temp = ptr2.getNext();
      ptr2.setNext(ptr1);
      ptr2 = temp;
    }
  }

  private SingleNode reverseList(SingleNode head) {
    SingleNode prev = null;
    SingleNode curr = head;
    SingleNode next;
    while (curr != null) {
      next = curr.getNext();
      curr.setNext(prev);
      prev = curr;
      curr = next;
    }
    System.out.println("List 2 Head = " + prev.getVal());
    return prev;
  }

  private SingleNode getMid(SingleNode head) {
    SingleNode slow = head;
    SingleNode fast = head;

    while (fast != null && fast.getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
    }

    System.out.println("Mid = " + slow.getVal());
    return slow;
  }

  public static void main(String[] args) {
    SingleNode head = new SingleNode();
    head.setVal(1);
    SingleNode prev = head;
    for (int i = 2; i <= 5; i++) {
      SingleNode node = new SingleNode();
      node.setVal(i);
      prev.setNext(node);
      prev = node;
    }

    ReorderList obj = new ReorderList();
    System.out.print("Original List : ");
    obj.print(head);

    obj.reorder(head);

    System.out.print("Reordered List : ");
    obj.print(head);
  }

  private void print(SingleNode head) {
    SingleNode curr = head;
    while (curr != null) {
      System.out.print(curr.getVal());
      curr = curr.getNext();
    }
    System.out.println();
  }

}
