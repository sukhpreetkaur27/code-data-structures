package com.code.ds.heap;

import java.util.PriorityQueue;

public class KSmallest {

  /**
   * Time: O(n log k)<br>
   * Space: O(k)
   * @param args
   */
  public static void main(String[] args) {
    TopKSmallest obj = new TopKSmallest();
    int arr[] = { 2, 1, 3, 4, 0 };
    int k = 2;
    PriorityQueue<Integer> topK = obj.topKSmallest(arr, k);
    int kSmallest = topK.peek();
    System.out.println(k + "-th Smallest = " + kSmallest);
  }

}
