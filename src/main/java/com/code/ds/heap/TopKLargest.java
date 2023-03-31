package com.code.ds.heap;

import java.util.PriorityQueue;

public class TopKLargest {

  /**
   * Time: O(n log k)<br>
   * Space: O(k)
   * @param arr
   * @param k
   * @return
   */
  public PriorityQueue<Integer> topKLargest(int[] arr, int k) {
    PriorityQueue<Integer> topK = new PriorityQueue<>(k);

    int length = arr.length;
    for (int i = 0; i < length; i++) {
      if (topK.contains(arr[i])) {
        continue;
      }
      if (topK.size() < k) {
        topK.offer(arr[i]);
      } else if (arr[i] > topK.peek()) {
        topK.poll();
        topK.offer(arr[i]);
      }
    }

    System.out.println("Top " + k + " largest: " + topK.toString());

    return topK;
  }

  public static void main(String[] args) {
    TopKLargest obj = new TopKLargest();
    int arr[] = { 2, 2, 3, 1 };
    obj.topKLargest(arr, 3);
  }

}
