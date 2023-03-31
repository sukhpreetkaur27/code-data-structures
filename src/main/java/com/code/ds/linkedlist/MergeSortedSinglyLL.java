package com.code.ds.linkedlist;

/**
 * You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
 * @author sukh
 *
 */
public class MergeSortedSinglyLL {

  /**
   * Time: O(m+n)<br>
   * Space: O(1)
   * @param list1
   * @param list2
   * @return
   */
  public SinglyNode<Integer> mergeTwoLists(SinglyNode<Integer> list1, SinglyNode<Integer> list2) {
    SinglyNode<Integer> head = new SinglyNode<>();
    SinglyNode<Integer> tail = head;

    while (list1 != null && list2 != null) {
      if (list1.getData() < list2.getData()) {
        tail.setNext(list1);
        list1 = list1.getNext();
      } else {
        tail.setNext(list2.getNext());
        list2 = list2.getNext();
      }
      tail = tail.getNext();
    }

    tail.setNext(list1 == null ? list2 : list1);
    return head.getNext();
  }

}
