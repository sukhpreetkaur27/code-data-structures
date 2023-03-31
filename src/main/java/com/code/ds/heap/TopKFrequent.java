package com.code.ds.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Time: O(n log k)<br>
 * Space: O(n)
 * @author sukh
 *
 */
public class TopKFrequent {

  public int[] topKFrequent(int[] arr, int k) {
    int size = arr.length;

    int[] topK = new int[k];

    /**
     * Map of number -> frequency<br>
     * Time: O(n)<br>
     * Space: O(n)
     */
    Map<Integer, Integer> numFreqMap = new HashMap<>();
    for (int num : arr) {
      numFreqMap.put(num, numFreqMap.getOrDefault(num, 0) + 1);
    }

    /**
     * Create a min-Heap of frequencies<br>
     * Time: O(n log k)<br>
     * Space: O(k)
     */
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(
        (n1, n2) -> numFreqMap.get(n1) - numFreqMap.get(n2));
    for (int num : numFreqMap.keySet()) {
      minHeap.add(num);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    /**
     * Put the numbers in the output array<br>
     * Time: O(k log k)<br>
     * Space: O(1); as it is the output so we don't count it as auxiliary space.
     */
    for (int i = k - 1; i >= 0; i--) {
      topK[i] = minHeap.poll();
    }

    return topK;
  }

}
