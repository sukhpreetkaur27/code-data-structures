package com.code.ds.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {

  public int lastStoneWeight(int[] stones) {
    Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    /**
     * Time: O(n log n)<br>
     * Space: O(n)
     */
    for (int wt : stones) {
      maxHeap.offer(wt);
    }

    int x, y;
    while (maxHeap.size() > 1) {
      x = maxHeap.poll();
      y = maxHeap.poll();

      if (x != y) {
        maxHeap.offer(x - y);
      }
    }

    return maxHeap.isEmpty() ? 0 : maxHeap.poll();
  }

}
