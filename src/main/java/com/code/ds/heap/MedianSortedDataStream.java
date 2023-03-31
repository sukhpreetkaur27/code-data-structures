package com.code.ds.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
 

Constraints:

-105 <= num <= 105
There will be at least one element in the data structure before calling findMedian.
At most 5 * 104 calls will be made to addNum and findMedian.

 * @author sukh
 *
 */
public class MedianSortedDataStream {

  private Queue<Integer> lo;
  private Queue<Integer> hi;

  public MedianSortedDataStream() {
    lo = new PriorityQueue<>(Collections.reverseOrder());
    hi = new PriorityQueue<>();
  }

  /**
   * Time: O(log n)<br>
   * Space: O(n)
   * @param num
   */
  public void addNum(int num) {
    lo.offer(num);

    hi.offer(lo.poll());

    if (lo.size() < hi.size()) {
      lo.offer(hi.poll());
    }
  }

  /**
   * Time: O(1)<br>
   * Space: O(1)
   * @return
   */
  public double findMedian() {
    return lo.size() > hi.size() ? lo.peek() : (lo.peek() + hi.peek()) * 0.5;
  }

}
