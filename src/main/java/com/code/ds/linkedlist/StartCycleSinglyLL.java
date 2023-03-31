package com.code.ds.linkedlist;

/**
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle.
  Note that pos is not passed as a parameter.

Do not modify the linked list.

 

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
Example 2:


Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
Example 3:


Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
 

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
 * @author sukh
 *
 */
public class StartCycleSinglyLL {

  public <T> SinglyNode<T> getIntersect(SinglyNode<T> head) {
    SinglyNode<T> slow = head;
    SinglyNode<T> fast = head;

    if (head == null) {
      return null;
    }

    while (fast != null && fast.getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();

      if (slow == fast) {
        return fast;
      }
    }
    return null;
  }

  public <T> SinglyNode<T> detectCycle(SinglyNode<T> head) {
    if (head == null) {
      return null;
    }
    SinglyNode<T> intersect = getIntersect(head);
    if (intersect == null) {
      return null;
    }
    SinglyNode<T> ptr1 = head;
    SinglyNode<T> ptr2 = intersect;
    while (ptr1 != ptr2) {
      ptr1 = ptr1.getNext();
      ptr2 = ptr2.getNext();
    }
    return ptr1;
  }

}
