package com.code.ds.striver.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Given an array, print the Previous Smaller Element (PSE) for every element. 
 * The PSE for an element x is the first smaller element on the left side of x in the array. 
 * Elements for which no smaller element exist (on the left side), consider PSE as -1. 

Examples: 

a) For any array, the leftmost element always has PSE as -1. 
b) For an array that is sorted in decreasing order, all elements have PSE as -1. 
c) For the input array [4, 8, 5, 2, 25}, the PSE for each element is as follows.

Element         PSE
   4      -->   -1
   8      -->    4
   5      -->    4
   2      -->   -1
   25     -->    2
d) For the input array [13, 7, 6, 12}, the next smaller elements for each element are as follows.  


  Element        PSE
   13      -->    -1
   7       -->    -1
   6       -->    -1
   12      -->     6
 * 
 * @author sukh
 *
 */
public class _21_PreviousSmallerElement {

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

    for (int i = 0; i <= n - 1; i++) {
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
    _21_PreviousSmallerElement obj = new _21_PreviousSmallerElement();
    int[] nums = { 4, 8, 5, 2, 25 };
    int[] res = obj.smallerElement(nums);
    System.out.println(Arrays.toString(res));
  }

}
