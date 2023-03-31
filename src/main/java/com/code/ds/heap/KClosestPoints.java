package com.code.ds.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

 

Example 1:


Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 

Constraints:

1 <= k <= points.length <= 10^4
-10^4 < xi, yi < 10^4
 * @author sukh
 *
 */
public class KClosestPoints {

  class Point {
    int[] point;
    int dist;

    Point(int[] point, int dist) {
      this.point = point;
      this.dist = dist;
    }
  }

  /**
   * Time: O(n log k)<br>
   * Space: O(k)
   * @param points
   * @param k
   * @return
   */
  public int[][] kClosest(int[][] points, int k) {
    Queue<Point> maxHeap = new PriorityQueue<>(new Comparator<Point>() {
      public int compare(Point point1, Point point2) {
        return point2.dist - point1.dist;
      }
    });
    int sq;
    int x, y;
    /**
     * Time: O(n log k)<br>
     * Space: O(k)
     */
    for (int point = 0; point < points.length; point++) {
      x = points[point][0];
      y = points[point][1];
      sq = (x * x + y * y);
      maxHeap.offer(new Point(points[point], sq));
      if (maxHeap.size() > k) {
        maxHeap.poll();
      }
    }

    /**
     * Time: O(k log k)
     */
    int[][] closest = new int[k][2];
    for (int i = k - 1; i >= 0; i--) {
      closest[i] = maxHeap.poll().point;
    }
    return closest;
  }

  public static void main(String[] args) {
    int[][] points = { { 1, 3 }, { -2, 2 } };
    int k = 1;
    KClosestPoints obj = new KClosestPoints();
    int[][] closest = obj.kClosest(points, k);
    System.out.println(k + " closest points to origin: ");
    obj.toString(closest);
  }

  private void toString(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(Arrays.toString(arr[i]));
    }
  }

}
