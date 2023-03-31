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
 * 
 * Given an array, print the Next Greater Element (NGE) for every element. 
 * The NGE for an element x is the first Greater element on the right side of x in the array. 
 * Elements for which no Greater element exist (on the right side), consider NGE as -1. 

Examples: 

a) For any array, the rightmost element always has NGE as -1. 
b) For an array that is sorted in decreasing order, all elements have NGE as -1. 
c) For the input array [4, 8, 5, 2, 25}, the NGE for each element is as follows.

Element         NGE
   4      -->    8
   8      -->    25
   5      -->    25
   2      -->    25
   25     -->   -1
d) For the input array [13, 7, 6, 12}, the next Greater elements for each element are as follows.  


  Element        NGE
   13      -->    -1
   7       -->    12
   6       -->    12
   12      -->   -1
 * 
 * @author sukh
 *
 */
public class _24_LeftRightGreater {

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
  public void greaterElement(int[] nums) {
    int n = nums.length;
    int[] leftMax = new int[n];
    int[] rightMax = new int[n];

    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i <= n - 1; i++) {
      /**
       * Time: O(n) at max, as it doesn't run for every i <br>
       * i.e. Each of the stack's n elements are pushed and popped exactly once.
       */
      while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
        /**
         * the next max of the top element = the one replacing the top element
         */
        rightMax[stack.peek()] = nums[i];
        stack.pop();
      }
      leftMax[i] = stack.isEmpty() ? -1 : nums[stack.peek()];
      stack.push(i);
    }
    /**
     * all elements of the array are traversed <br>
     * the elements remaining on the stack have no greater elements to the right
     * which can replace them <br>
     * therefore, right_max[stack_elements] = -1
     */
    while (!stack.isEmpty()) {
      rightMax[stack.peek()] = -1;
      stack.pop();
    }
    System.out.println(Arrays.toString(leftMax));
    System.out.println(Arrays.toString(rightMax));
  }

  public static void main(String[] args) {
    _24_LeftRightGreater obj = new _24_LeftRightGreater();
    int[] nums = { 4, 8, 5, 2, 25 };
//    int[] nums = { 13, 7, 6, 12 };
    obj.greaterElement(nums);
  }

}
