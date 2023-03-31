package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites 
 * where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. 
If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.
 * 
 * @author sukh
 *
 */
public class _25_CourseSchedule_II {

  /**
   * Time: O(V + E) <br>
   * Space: O(V)
   * 
   * @param numCourses
   * @param prerequisites
   * @return
   */
  public int[] findOrder(int numCourses, int[][] prerequisites) {
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
    int[] sort = new int[numCourses];
    int sortCount = 0;
    while (!queue.isEmpty()) {
      int pop = queue.poll();
      sort[sortCount++] = pop;
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
    /**
     * Return empty array
     */
    if (sortCount != numCourses) {
      return new int[0];
    }
    return sort;
  }

}
