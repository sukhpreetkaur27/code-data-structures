package com.code.ds.striver.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 * 
 * @author sukh
 *
 */
public class _40_MergeIntervals {

  /**
   * Time: O(n log n)<br>
   * Space: O(log N) (or) O(n)
   * 
   * If we can sort intervals in place, we do not need more than constant
   * additional space, although the sorting itself takes O(log n) space.
   * Otherwise, we must allocate linear space to store a copy of intervals and
   * sort that.
   * @param arr
   * @return
   */
  public int[][] merge(int[][] arr) {
    Arrays.sort(arr, (a, b) -> {
      return a[0] - b[0];
    });

    List<int[]> list = new ArrayList<>();
    int[] prev = arr[0];

    for (int[] interval : arr) {
      if (interval[0] <= prev[1]) {
        prev[1] = Math.max(interval[1], prev[1]);
      } else {
        list.add(prev);
        prev = interval;
      }
    }

    list.add(prev);
    return list.toArray(new int[list.size()][]);
  }

}
