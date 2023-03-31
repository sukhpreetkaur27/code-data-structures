package com.code.ds.linkedlist;

/**
 * Given head, the head of a linked list, determine if the linked list has a
 * cycle in it.
 * 
 * There is a cycle in a linked list if there is some node in the list that can
 * be reached again by continuously following the next pointer. Internally, pos
 * is used to denote the index of the node that tail's next pointer is connected
 * to. Note that pos is not passed as a parameter.
 * 
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * 
 * 
 * 
 * Example 1: <br>
 * Input: head = [3,2,0,-4], pos = 1<br>
 * Output: true<br>
 * Explanation: There is a cycle in the linked list, where the tail connects to
 * the 1st node (0-indexed).<br>
 * 
 * 
 * Example 2: <br>
 * Input: head = [1,2], pos = 0<br>
 * Output: true<br>
 * Explanation: There is a cycle in the linked list, where the tail connects to
 * the 0th node.<br>
 * 
 * 
 * Example 3: <br>
 * Input: head = [1], pos = -1<br>
 * Output: false<br>
 * Explanation: There is no cycle in the linked list.<br>
 * 
 * 
 * Constraints: <br>
 * The number of the nodes in the list is in the range [0, 104].<br>
 * -105 <= Node.val <= 105<br>
 * pos is -1 or a valid index in the linked-list.<br>
 * @author sukh
 *
 */
public class CycleSinglyLL {

  /**
   * Time: O(n)
   * Space: O(1)
   * @param <T>
   * @param head
   * @return
   */
  public <T> boolean hasCycle(SinglyNode<T> head) {
    SinglyNode<T> slow = head;
    SinglyNode<T> fast = head;

    while (fast != null && fast.getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
      if (slow == fast) {
        return true;
      }
    }

    return false;
  }

}
