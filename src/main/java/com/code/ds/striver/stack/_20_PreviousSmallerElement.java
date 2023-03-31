package com.code.ds.striver.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Given a circular integer array nums (i.e., the next element of
 * nums[nums.length - 1] is nums[0]), return the previous smaller number for every
 * element in nums.
 * 
 * The PSE for an element x is the first smaller element on the left side of x
 * in the array, which means you could search circularly to find its previous
 * smaller number. . Elements for which no smaller element exist (on the left
 * side), consider PSE as -1.
 * 
 * Examples: 

b) For an array that is sorted in decreasing order, all elements have PSE as -1. 
c) For the input array [4, 8, 5, 2, 25}, the PSE for each element is as follows.

Element         PSE
   4      -->    2
   8      -->    4
   5      -->    4
   2      -->   -1
   25     -->    2
d) For the input array [13, 7, 6, 12}, the next smaller elements for each element are as follows.  


  Element        PSE
   13      -->    6
   7       -->    6
   6       -->   -1
   12      -->    6
 * 
 * @author sukh
 *
 */
public class _20_PreviousSmallerElement {

  /**
   * Increasing Monotonic Stack <br>
   * Top of stack = next smaller element = the largest element in the stack
   */

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * @param nums
   * @return
   */
  public int[] smallerElement(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];

    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i <= 2 * n - 1; i++) {
      /**
       * Time: O(n) at max, as it doesn't run for every i <br>
       * i.e. Each of the stack's n elements are pushed and popped exactly once.
       */
      while (!stack.isEmpty() && stack.peek() >= nums[i % n]) {
        stack.pop();
      }
      if (i >= n) {
        res[i % n] = stack.isEmpty() ? -1 : stack.peek();
      }
      stack.push(nums[i % n]);
    }

    return res;
  }
  
  public static void main(String[] args) {
    _20_PreviousSmallerElement obj = new _20_PreviousSmallerElement();
    int[] nums = { 4, 8, 5, 2, 25 };
    int[] res = obj.smallerElement(nums);
    System.out.println(Arrays.toString(res));
  }

}
