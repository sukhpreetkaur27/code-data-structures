package com.code.ds.striver.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
 * 
 * @author sukh
 *
 */
public class _22_LargestRectangleInHistogram {

  /**
   * Time: O(n^2)
   * 
   * @param heights
   * @return
   */
  public int largestRectangleArea_brute(int[] heights) {
    /**
     * find the next smaller on the right and left of the current height --> this
     * denotes the boundary of the rectangle with height = current height
     */
    int max = 0;
    int n = heights.length;
    for (int i = 0, nextSmaller = -1, prevSmaller = -1; i < n; i++) {
      nextSmaller = heights[i];
      prevSmaller = heights[i];
//      for(int j=i+1;j<n;j++) {
//        if(heights[j]<heights[i]) {
//          nextSmaller=Math.min(nextSmaller,heights[j]);
//        }
//        nextSmaller=?j:-1;
//      }
//      for(int j=0;j<i;j++) {
//        prevSmaller=heights[j]<heights[i]?j:
//      }
    }
    return max;
  }

  /**
   * Time: O(4n) <br>
   * Space: O(3n)
   * 
   * @param heights
   * @return
   */
  public int largestRectangleArea_better(int[] heights) {
    /**
     * NOTE: <br>
     * the boundaries: if no smaller on the right --> n-1, if no smaller on the left
     * --> 0 <br>
     * Find the previous smaller (+1) and next smaller (-1) for the current index
     * <br>
     * this implies the range in which the current index is smallest
     */

    /**
     * NOTE: this approach uses the concept of monotonic stack with Time: O(n)
     */
    int n = heights.length;
    /**
     * Holds the left boundary index (add 1)
     */
    int[] leftSmall = new int[n];

    Deque<Integer> stack = new ArrayDeque<>();
    int max = 0;
    /**
     * Time: O(2n)
     */
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
        stack.pop();
      }
      leftSmall[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
      stack.push(i);
    }

    stack.clear();

    for (int i = n - 1, rightSmall = 0, area = 0; i >= 0; i--) {
      while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
        stack.pop();
      }
      /**
       * Find the right boundary index (minus 1)
       */
      rightSmall = stack.isEmpty() ? (n - 1) : stack.peek() - 1;
      /**
       * find area = (rightSmall - leftSmall[i] + 1) * heights[i];
       * 
       * why +1?
       * 
       * due to 0-based indexing
       */
      area = (rightSmall - leftSmall[i] + 1) * heights[i];
      max = Math.max(max, area);
      stack.push(i);
    }
    return max;
  }

  public int largestRectangleArea_optimal(int[] heights) {
    /**
     * NOTE: <br>
     * Find the previous smaller (+1) and next smaller (-1) for the current index
     * <br>
     * this implies the range in which the current index is smallest
     */

    int n = heights.length;

    Deque<Integer> stack = new ArrayDeque<>();
    int max = 0;
    /**
     * Time: O(n)
     */
    for (int right = 0, min = 0, left = 0, area = 0; right <= n; right++) {
      /**
       * the element which replaces the top element is the right smaller and the
       * element before the top element is the left smaller (stack.isEmpty() ? 0 :
       * stack.peek() + 1)
       * 
       * hence, area = right - 1 - left + 1
       * 
       * therefore, run the loop till n as the stack might not be empty, so we need to
       * find the area for those indexes also <br>
       * NOTE: for those indexes, right smaller = n - 1, left smaller =
       * stack.isEmpty() ? 0 : stack.peek() + 1
       */
      while (!stack.isEmpty()
          && (right == n || heights[right] <= heights[stack.peek()])) {
        min = stack.pop();
        left = stack.isEmpty() ? 0 : stack.peek() + 1;
        /**
         * right = next smaller <br>
         * left = previous smaller <br>
         * min = current small <br>
         * # of elements with min as smallest = ( right - left - 1 ) == length <br>
         * height[min] == breadth
         */
        area = (right - 1 - left + 1) * heights[min];
        max = Math.max(max, area);
      }
      stack.push(right);
    }

    return max;
  }

}
