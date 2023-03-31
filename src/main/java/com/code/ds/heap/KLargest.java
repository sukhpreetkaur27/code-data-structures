package com.code.ds.heap;

import java.util.PriorityQueue;

public class KLargest {

  /**
   * Time: O(n log k)<br>
   * Space: O(k)
   * @param args
   */
  public static void main(String[] args) {
    TopKLargest obj = new TopKLargest();
    int arr[] = { 2, 1, 3, 4, 0 };
    int k = 2;
    PriorityQueue<Integer> topK = obj.topKLargest(arr, k);
    int kLargest = topK.peek();
    System.out.println(k + "-th Largest = " + kLargest);
  }

}
