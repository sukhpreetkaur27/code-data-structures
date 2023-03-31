package com.code.ds.striver.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Given an array, print the Next Smaller Element (NSE) for every element. 
 * The NSE for an element x is the first smaller element on the right side of x in the array. 
 * Elements for which no smaller element exist (on the right side), consider NSE as -1. 

Examples: 

a) For any array, the rightmost element always has NSE as -1. 
b) For an array that is sorted in increasing order, all elements have NSE as -1. 
c) For the input array [4, 8, 5, 2, 25}, the NSE for each element is as follows.

Element         NSE
   4      -->    2
   8      -->    5
   5      -->    2
   2      -->   -1
   25     -->   -1
d) For the input array [13, 7, 6, 12}, the next smaller elements for each element are as follows.  


  Element        NSE
   13      -->    7
   7       -->    6
   6       -->   -1
   12      -->   -1
 * 
 * @author sukh
 *
 */
public class _18_NextSmallerElement {

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

    for (int i = n - 1; i >= 0; i--) {
      /**
       * Time: O(n) at max, as it doesn't run for every i <br>
       * i.e. Each of the stack's n elements are pushed and popped exactly once.
       */
      while (!stack.isEmpty() && stack.peek() >= nums[i]) {
        stack.pop();
      }
      res[i] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(nums[i]);
    }

    return res;
  }

  public static void main(String[] args) {
    _18_NextSmallerElement obj = new _18_NextSmallerElement();
    int[] nums = { 4, 8, 5, 2, 25 };
    int[] res = obj.smallerElement(nums);
    System.out.println(Arrays.toString(res));
  }

}
