package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites 
 * where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
 * 
 * @author sukh
 *
 */
public class _24_CourseSchedule_I {

  /**
   * Time: O(V + E) <br>
   * Space: O(V)
   * 
   * @param numCourses
   * @param prerequisites
   * @return
   */
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    /**
     * [v, u] = in order to take course v, you must complete u
     * 
     * directed edge from u -> v
     * 
     * if DAG exists, course schedule possible
     * 
     * Apply Kahn's Algorithm
     */
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      adj.add(new ArrayList<>());
    }
    int[] inDegrees = new int[numCourses];
    int u, v;
    /**
     * Create adjacency list from the edges matrix
     * 
     * Find in degree of all the nodes
     */
    for (int[] i : prerequisites) {
      u = i[1];
      v = i[0];
      inDegrees[v]++;
      adj.get(u).add(v);
    }
    /**
     * Push nodes with in-degree 0 to the queue
     */
    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < numCourses; i++) {
      if (inDegrees[i] == 0) {
        queue.offer(i);
      }
    }
    int sortCount = 0;
    while (!queue.isEmpty()) {
      int pop = queue.poll();
      sortCount++;
      for (int j : adj.get(pop)) {
        /**
         * Decrement in-degree of adjacent nodes by 1
         * 
         * Push nodes with in-degree 0
         */
        inDegrees[j]--;
        if (inDegrees[j] == 0) {
          queue.offer(j);
        }
      }
    }
    return sortCount == numCourses;
  }

}
