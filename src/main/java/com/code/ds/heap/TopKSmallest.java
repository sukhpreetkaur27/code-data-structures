package com.code.ds.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class TopKSmallest {

  /**
   * Time: O(n log k)<br>
   * Space: O(k)
   * @param arr
   * @param k
   * @return
   */
  public PriorityQueue<Integer> topKSmallest(int[] arr, int k) {
    PriorityQueue<Integer> topK = new PriorityQueue<>(k, Collections.reverseOrder());

    int length = arr.length;
    for (int i = 0; i < length; i++) {
      if (topK.contains(arr[i])) {
        continue;
      }
      if (topK.size() < k) {
        topK.offer(arr[i]);
      } else if (arr[i] < topK.peek()) {
        topK.poll();
        topK.offer(arr[i]);
      }
    }

    System.out.println("Top " + k + " Smallest: " + topK.toString());

    return topK;
  }

  public static void main(String[] args) {
    TopKSmallest obj = new TopKSmallest();
    int arr[] = { 2, 1, 3, 4, 2 };
    obj.topKSmallest(arr, 2);
  }

}
