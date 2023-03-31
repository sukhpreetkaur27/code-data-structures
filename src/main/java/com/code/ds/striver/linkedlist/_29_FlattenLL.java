package com.code.ds.striver.linkedlist;

/**
 * Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 
Note: The flattened list will be printed using the bottom pointer instead of next pointer.
 For more clearity have a look at the printList() function in the driver code.

 

Example 1:

Input:
5 -> 10 -> 19 -> 28
|     |     |     | 
7     20    22   35
|           |     | 
8          50    40
|                 | 
30               45
Output:  5-> 7-> 8- > 10 -> 19-> 20->
22-> 28-> 30-> 35-> 40-> 45-> 50.
Explanation:
The resultant linked lists has every 
node in a single level.
(Note: | represents the bottom pointer.)
 

Example 2:

Input:
5 -> 10 -> 19 -> 28
|          |                
7          22   
|          |                 
8          50 
|                           
30              
Output: 5->7->8->10->19->22->28->30->50
Explanation:
The resultant linked lists has every
node in a single level.

(Note: | represents the bottom pointer.)
 

Your Task:
You do not need to read input or print anything. Complete the function flatten() that takes the head of the linked list as input parameter 
and returns the head of flattened link list.

 

Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(1)

 

Constraints:
0 <= N <= 50
1 <= Mi <= 20
1 <= Element of linked list <= 103
 * 
 * @author sukh
 *
 */
public class _29_FlattenLL {

  /**
   * Time: O(2M + 3M +..+ NM) <br>
   * N = # of linked lists <br>
   * M = average size of each linked list <br>
   * Space: O(N)
   * @param head
   * @return
   */
  public _3_ListNode flatten(_3_ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    _3_ListNode next = flatten(head.next);
    return merge(head, next);
  }

  private _3_ListNode merge(_3_ListNode left, _3_ListNode right) {
    _3_ListNode dummy = new _3_ListNode(0);
    _3_ListNode tail = dummy;
    while (left != null && right != null) {
      if (left.data < right.data) {
        tail.bottom = left;
        left = left.bottom;
      } else {
        tail.bottom = right;
        right = right.bottom;
      }
    }
    tail.bottom = left == null ? right : left;
    return dummy.bottom;
  }

}
