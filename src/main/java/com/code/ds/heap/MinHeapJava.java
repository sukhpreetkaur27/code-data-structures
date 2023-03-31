package com.code.ds.heap;

import java.util.PriorityQueue;

public class MinHeapJava {

  public MinHeapJava() {
  }

  public static void main(String[] args) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    minHeap.add(3);
    minHeap.add(1);
    minHeap.add(2);

    System.out.println("minHeap: " + minHeap.toString());

    int top = minHeap.peek();
    System.out.println("Top: " + top);

    int poll = minHeap.poll();
    System.out.println("Poll: " + poll);

    top = minHeap.peek();
    System.out.println("Top: " + top);

    System.out.println("minHeap: " + minHeap.toString());

    int heapSize = minHeap.size();
    System.out.println("Size: " + heapSize);

    boolean isEmpty = minHeap.isEmpty();
    System.out.println("isEmpty: " + isEmpty);
  }

}
