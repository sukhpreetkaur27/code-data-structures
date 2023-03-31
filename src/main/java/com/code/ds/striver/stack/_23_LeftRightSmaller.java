package com.code.ds.striver.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 *  Given an array, print the Previous Smaller Element (PSE) for every element. 
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
public class _23_LeftRightSmaller {

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
  public void smallerElement(int[] nums) {
    int n = nums.length;
    int[] leftSmall = new int[n];
    int[] rightSmall = new int[n];

    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i <= n - 1; i++) {
      /**
       * Time: O(n) at max, as it doesn't run for every i <br>
       * i.e. Each of the stack's n elements are pushed and popped exactly once.
       */
      while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
        /**
         * the next small of the top element = the one replacing the top element
         */
        rightSmall[stack.peek()] = nums[i];
        stack.pop();
      }
      leftSmall[i] = stack.isEmpty() ? -1 : nums[stack.peek()];
      stack.push(i);
    }
    /**
     * all elements of the array are traversed <br>
     * the elements remaining on the stack have no smaller elements to the right
     * which can replace them <br>
     * therefore, right_small[stack_elements] = -1
     */
    while (!stack.isEmpty()) {
      rightSmall[stack.peek()] = -1;
      stack.pop();
    }
    System.out.println(Arrays.toString(leftSmall));
    System.out.println(Arrays.toString(rightSmall));
  }

  public static void main(String[] args) {
    _23_LeftRightSmaller obj = new _23_LeftRightSmaller();
//    int[] nums = { 4, 8, 5, 2, 25 };
    int[] nums = { 13, 7, 6, 12 };
    obj.smallerElement(nums);
  }

}
