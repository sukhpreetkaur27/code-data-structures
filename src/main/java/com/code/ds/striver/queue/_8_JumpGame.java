package com.code.ds.striver.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], 
 * check if you can reach to any index with value 0.

Notice that you can not jump outside of the array at any time.

 

Example 1:

Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation: 
All possible ways to reach at index 3 with value 0 are: 
index 5 -> index 4 -> index 1 -> index 3 
index 5 -> index 6 -> index 4 -> index 1 -> index 3 
Example 2:

Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true 
Explanation: 
One possible way to reach at index 3 with value 0 is: 
index 0 -> index 4 -> index 1 -> index 3
Example 3:

Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.
 

Constraints:

1 <= arr.length <= 5 * 104
0 <= arr[i] < arr.length
0 <= start < arr.length
 * 
 * @author sukh
 *
 */
public class _8_JumpGame {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param arr
   * @param start
   * @return
   */
  public boolean bfs(int[] arr, int start) {
    /**
     * BFS
     */
    int n = arr.length;
    boolean[] visited = new boolean[n];
    Deque<Integer> queue = new ArrayDeque<>();
    queue.offer(start);
    visited[start] = true;
    while (!queue.isEmpty()) {
      int pop = queue.poll();
      if (arr[pop] == 0) {
        return true;
      }
      int index = pop + arr[pop];
      if (index < n && !visited[index]) {
        visited[index] = true;
        queue.offer(index);
      }
      index = pop - arr[pop];
      if (index >= 0 && !visited[index]) {
        visited[index] = true;
        queue.offer(index);
      }
    }
    return false;
  }

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param arr
   * @param start
   * @return
   */
  public boolean canReach(int[] arr, int start) {
    /**
     * DFS
     */
    int n = arr.length;
    boolean[] visited = new boolean[n];
    return dfs(arr, start, visited);
  }

  private boolean dfs(int[] arr, int index, boolean[] visited) {
    if (index >= 0 && index < arr.length && !visited[index]) {
      if (arr[index] == 0) {
        return true;
      }
      visited[index] = true;
      return dfs(arr, index + arr[index], visited)
          || dfs(arr, index - arr[index], visited);
    }
    return false;
  }

}
