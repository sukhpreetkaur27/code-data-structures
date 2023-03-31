package com.code.ds.striver.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Given an array, print the Previous Greater Element (PGE) for every element. 
 * The PGE for an element x is the first Greater element on the left side of x in the array. 
 * Elements for which no Greater element exist (on the left side), consider PGE as -1. 

Examples: 

a) For any array, the leftmost element always has PGE as -1. 
b) For an array that is sorted in increasing order, all elements have PGE as -1. 
c) For the input array [4, 8, 5, 2, 25}, the PGE for each element is as follows.

Element         PGE
   4      -->    -1
   8      -->    -1
   5      -->    8
   2      -->    5
   25     -->    -1
d) For the input array [13, 7, 6, 12}, the next Greater elements for each element are as follows.  


  Element        PGE
   13      -->    -1
   7       -->    13
   6       -->    7
   12      -->     13
 * 
 * @author sukh
 *
 */
public class _25_PreviousGreaterElement {

  /**
   * Decreasing Monotonic Stack <br>
   * Top of stack = next greater element = the smallest element in the stack
   */

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * @param nums
   * @return
   */
  public int[] greaterElement(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];

    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i <= n - 1; i++) {
      /**
       * Time: O(n) at max, as it doesn't run for every i <br>
       * i.e. Each of the stack's n elements are pushed and popped exactly once.
       */
      while (!stack.isEmpty() && stack.peek() <= nums[i]) {
        stack.pop();
      }
      res[i] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(nums[i]);
    }

    return res;
  }

  public static void main(String[] args) {
    _25_PreviousGreaterElement obj = new _25_PreviousGreaterElement();
//    int[] nums = { 4, 8, 5, 2, 25 };
    int[] nums = { 13, 7, 6, 12 };
    int[] res = obj.greaterElement(nums);
    System.out.println(Arrays.toString(res));
  }

}
