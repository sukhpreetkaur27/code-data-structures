package com.code.ds.array;

import java.util.Map;
import java.util.TreeMap;

/**
 * There is a long and thin painting that can be represented by a number line. You are given a 0-indexed 2D integer array paint of length n, where paint[i] = [starti, endi]. 
 * This means that on the ith day you need to paint the area between starti and endi.

Painting the same area multiple times will create an uneven painting so you only want to paint each area of the painting at most once.

Return an integer array worklog of length n, where worklog[i] is the amount of new area that you painted on the ith day.

 

Example 1:


Input: paint = [[1,4],[4,7],[5,8]]
Output: [3,3,1]
Explanation:
On day 0, paint everything between 1 and 4.
The amount of new area painted on day 0 is 4 - 1 = 3.
On day 1, paint everything between 4 and 7.
The amount of new area painted on day 1 is 7 - 4 = 3.
On day 2, paint everything between 7 and 8.
Everything between 5 and 7 was already painted on day 1.
The amount of new area painted on day 2 is 8 - 7 = 1. 
Example 2:


Input: paint = [[1,4],[5,8],[4,7]]
Output: [3,3,1]
Explanation:
On day 0, paint everything between 1 and 4.
The amount of new area painted on day 0 is 4 - 1 = 3.
On day 1, paint everything between 5 and 8.
The amount of new area painted on day 1 is 8 - 5 = 3.
On day 2, paint everything between 4 and 5.
Everything between 5 and 7 was already painted on day 1.
The amount of new area painted on day 2 is 5 - 4 = 1. 
Example 3:


Input: paint = [[1,5],[2,4]]
Output: [4,0]
Explanation:
On day 0, paint everything between 1 and 5.
The amount of new area painted on day 0 is 5 - 1 = 4.
On day 1, paint nothing because everything between 2 and 4 was already painted on day 0.
The amount of new area painted on day 1 is 0.
 

Constraints:

1 <= paint.length <= 105
paint[i].length == 2
0 <= starti < endi <= 5 * 104
 * 
 * @author sukh
 *
 */
public class _1_AmountPainted {

  /**
   * Time: O(n log n)
   * 
   * Although there are 2 loops, the time complexity is still amortized O(n log n)
   * since we put and remove each interval at most once.
   * 
   * @param paint
   * @return
   */
  public int[] amountPainted1(int[][] paint) {
    int n = paint.length;
    int[] result = new int[n];
    TreeMap<Integer, Integer> intervals = new TreeMap<>();

    for (int i = 0; i < n; i++) {
      int[] current = paint[i];
      // start and end to record the merged interval
      int start = current[0];
      int end = current[1];
      int toPaint = end - start;

      Map.Entry<Integer, Integer> floor = intervals.floorEntry(current[0]);
      if (floor != null) {
        if (floor.getValue() >= end) {
          // the entire current interval has been covered by floor, so the result[i] = 0
          // and simply just continue.
          continue;
        }
        if (floor.getValue() >= start) {
          // the current interval has been partially covered by floor, so deduct the
          // overlapping length.
          toPaint -= floor.getValue() - start;
          intervals.remove(floor.getKey());
          start = floor.getKey();
        }
      }

      Map.Entry<Integer, Integer> ceiling = intervals.ceilingEntry(current[0]);
      // there could be multiple ceilings overlap with the current interval.
      // e.g. current [5, 20], ceilings: [6, 8], [10, 15], [18, 22]
      // We need to deduct the overlapping length properly
      while (ceiling != null && ceiling.getKey() <= end) {
        toPaint -= Math.min(end, ceiling.getValue()) - ceiling.getKey();
        intervals.remove(ceiling.getKey());
        end = Math.max(end, ceiling.getValue());
        ceiling = intervals.ceilingEntry(current[0]);
      }

      result[i] = toPaint;
      // add the merged interval to treemap
      intervals.put(start, end);
    }

    return result;
  }

}
