package com.code.ds.striver.linkedlist;

/**
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, 
where each new node has its value set to the value of its corresponding original node. 
Both the next and random pointer of the new nodes should point to new nodes in the copied list 
such that the pointers in the original list and copied list represent the same list state. 
None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, 
then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.

 

Example 1:


Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Example 2:


Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Example 3:



Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
 

Constraints:

0 <= n <= 1000
-104 <= Node.val <= 104
Node.random is null or is pointing to some node in the linked list.
 * 
 * @author sukh
 *
 */
public class _30_CopyListRandomPointer_2 {

  /**
   * NOTE: <br>
   * Optimal solution due to Space: O(1)
   */
  
  /**
   * Time: O(n) <br>
   * Space: O(1)
   * @param head
   * @return
   */
  public _4_ListNode copyRandomList(_4_ListNode head) {
    if (head == null) {
      return null;
    }
    _4_ListNode curr = head;
    while (curr != null) {
      _4_ListNode node = new _4_ListNode(curr.data);
      node.next = curr.next;
      curr.next = node;
      curr = node.next;
    }

    _4_ListNode newHead = head.next;
    curr = head;
    while (curr != null) {
      curr.next.random = curr.random != null ? curr.random.next : null;
      curr = curr.next.next;
    }

    _4_ListNode next;
    curr = head;
    while (curr != null) {
      next = curr.next.next;
      curr.next.next = next != null ? next.next : null;
      curr.next = next;
      curr = next;
    }

    return newHead;
  }

}
