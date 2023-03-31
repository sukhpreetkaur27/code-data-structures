package com.code.ds.striver.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction 
(positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. 
If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 

Constraints:

2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
 * 
 * @author sukh
 *
 */
public class _29_AsteroidCollision {

  /**
   * Time: O(n) <br>
   * Our stack pushes and pops each asteroid at most once. <br>
   * Space: O(n) <br>
   * In the worst case, the states do not evolve at the end, i.e. we need O(N)O(N)
   * space where NN is the number of input asteroids.
   * 
   * @param asteroids
   * @return
   */
  public int[] asteroidCollision(int[] asteroids) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (int curr : asteroids) {
      collision: {
        while (!stack.isEmpty() && stack.peek() > 0 && curr < 0) {
          if (stack.peek() < -curr) {
            stack.pop();
            continue;
          } else if (stack.peek() == -curr) {
            stack.pop();
          }
          break collision;
        }
        stack.push(curr);
      }
    }

    int[] res = new int[stack.size()];
    for (int i = stack.size() - 1; i >= 0; i--) {
      res[i] = stack.pop();
    }
    return res;
  }

}
