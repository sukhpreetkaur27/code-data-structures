package com.code.ds.striver.linkedlist;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in
 * ascending order.
 * 
 * Merge all the linked-lists into one sorted linked-list and return it.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: lists = [[1,4,5],[1,3,4],[2,6]] Output: [1,1,2,3,4,4,5,6] Explanation:
 * The linked-lists are: [ 1->4->5, 1->3->4, 2->6 ] merging them into one sorted
 * list: 1->1->2->3->4->4->5->6 Example 2:
 * 
 * Input: lists = [] Output: [] Example 3:
 * 
 * Input: lists = [[]] Output: []
 * 
 * 
 * Constraints:
 * 
 * k == lists.length 0 <= k <= 104 0 <= lists[i].length <= 500 -104 <=
 * lists[i][j] <= 104 lists[i] is sorted in ascending order. The sum of
 * lists[i].length will not exceed 104.
 * 
 * @author sukh
 *
 */
public class _32_MergeKSortedLists {

  /**
   * NOTE: <br>
   * this Optimized approach uses Divide and Conquer approach
   *
   * Pair up K lists and merge each pair in linear time using O(N) space. <br>
   * After the first cycle, K/2 lists are left each of size 2*N. <br>
   * After the second cycle, K/4 lists are left each of size 4*N and so on. <br>
   * Repeat the procedure until we have only one list left.
   */

  class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  /**
   * Time: O(N * log k) <br>
   * k = # of linked lists <br>
   * N = total # of nodes in the linked list <br>
   * Space: O(N) <br>
   * due to recursion
   * 
   * @param lists
   * @return
   */
  public ListNode mergeKLists(ListNode[] lists) {
    int n = lists.length;
    if (n == 0) {
      return null;
    }
    if (n == 1) {
      return lists[0];
    }
    int left = 0;
    int right = n - 1;

    while (right != 0) {
      while (left < right) {
        lists[left] = merge2Lists(lists[left], lists[right]);
        left++;
        right--;
      }
      left = 0;
    }
    return lists[0];
  }

  /**
   * Time: O(n + m) <br>
   * Space: O(n + m)
   */
  private ListNode merge2Lists(ListNode a, ListNode b) {
    if (a == null) {
      return b;
    }
    if (b == null) {
      return a;
    }
    if (a.val < b.val) {
      a.next = merge2Lists(a.next, b);
      return a;
    } else {
      b.next = merge2Lists(a, b.next);
      return b;
    }
  }

}
