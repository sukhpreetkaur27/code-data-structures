package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Given start, end and an array arr of n numbers. At each step, start is multiplied with any number in the array and then mod operation with 100000 i
 * s done to get the new start.

Your task is to find the minimum steps in which end can be achieved starting from start. If it is not possible to reach end, then return -1.

Example 1:

Input:
arr[] = {2, 5, 7}
start = 3, end = 30
Output:
2
Explanation:
Step 1: 3*2 = 6 % 100000 = 6 
Step 2: 6*5 = 30 % 100000 = 30
Example 2:

Input:
arr[] = {3, 4, 65}
start = 7, end = 66175
Output:
4
Explanation:
Step 1: 7*3 = 21 % 100000 = 21 
Step 2: 21*3 = 6 % 100000 = 63 
Step 3: 63*65 = 4095 % 100000 = 4095 
Step 4: 4095*65 = 266175 % 100000 = 66175
Your Task:

You don't need to print or input anything. Complete the function minimumMultiplications() which takes an integer array arr, an integer start 
and an integer end as the input parameters and returns an integer, denoting the minumum steps to reach in which end can be achieved starting from start.

Expected Time Complexity: O(105)

Expected Space Complexity: O(105)

Constraints:

1 <= n and n <= 104
1 <= arr[i] and arr[i] <= 104
1 <= start, end <= 105
 * 
 * @author sukh
 *
 */
public class _39_MinMultiplications {

  class Pair {
    int step;
    int num;

    Pair(int step, int num) {
      this.step = step;
      this.num = num;
    }
  }

  /**
   * Time: O(n * 100000) <br>
   * Space: O(n * 100000) (hypothetical)
   * 
   * @param arr
   * @param start
   * @param end
   * @return
   */
  int minimumMultiplications(int[] arr, int start, int end) {
    /**
     * Since we have to MOD 100000, so the range of possible numbers = [1...9999]
     * 
     * now, we apply Dijkstra's Algorithm using the steps as priority
     * 
     * as the steps increment by 1, so no need of a PQ, a simple Queue will suffice
     */
    int[] steps = new int[100000];
    Arrays.fill(steps, Integer.MAX_VALUE);
    steps[start] = 0;
    Deque<Pair> queue = new ArrayDeque<>();
    queue.offer(new Pair(0, start));
    int MOD = (int) 1e5;
    while (!queue.isEmpty()) {
      Pair pop = queue.poll();
      int step = pop.step + 1;
      for (int i = 0; i < arr.length; i++) {
        int num = (pop.num * arr[i]) % MOD;
        if (steps[num] > step) {
          steps[num] = step;
          queue.offer(new Pair(step, num));
        }
        /**
         * At any step, if we reach the end --> break
         */
        if (num == end) {
          return step;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    _39_MinMultiplications obj = new _39_MinMultiplications();
    int[] arr = { 2, 5, 7 };
    int start = 3;
    int end = 30;
    System.out.println(obj.minimumMultiplications(arr, start, end));
  }

}
