package com.code.ds.striver.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value target.

 

Example 1:

Input:  
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
target = 7
Output: (1, 6), (2,5)
Explanation: We can see that there are two pairs 
(1, 6) and (2,5) with sum 7.
 

Example 2:

Input: 
1 <-> 5 <-> 6
target = 6
Output: (1,5)
Explanation: We can see that there is one pairs  (1, 5) with sum 6.
 * 
 * @author sukh
 *
 */
public class _25_TwoSumDLL {

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * @param head
   * @param target
   * @return
   */
  public List<List<Integer>> twoSum(_2_ListNode head, int target) {
    List<List<Integer>> res = new ArrayList<>();
    /**
     * NOTE: <br>
     * If list is unsorted, put the numbers in an ArrayList and apply two sum
     * approach <br>
     * If list is sorted, use the prev pointer for TwoSum Approach
     */
    _2_ListNode p1 = head;
    _2_ListNode p2;
    while (p1.next != null) {
      p1 = p1.next;
    }
    p2 = p1;
    p1 = head;
    int sum;
    while (p1 != p2 && p2.next != p1) {
      sum = p1.data + p2.data;
      if (sum > target) {
        p2 = p2.prev;
      } else if (sum < target) {
        p1 = p1.next;
      } else {
        List<Integer> pair = Arrays.asList(p1.data, p2.data);
        res.add(pair);
        p1 = p1.next;
        p2 = p2.prev;
      }
    }
    return res;
  }

}
