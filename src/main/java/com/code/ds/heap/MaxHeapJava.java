package com.code.ds.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeapJava {

  public MaxHeapJava() {

  }

  public static void main(String[] args) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    maxHeap.add(1);
    maxHeap.add(2);
    maxHeap.add(3);

    System.out.println("maxHeap: " + maxHeap.toString());

    int top = maxHeap.peek();
    System.out.println("Top: " + top);

    int poll = maxHeap.poll();
    System.out.println("Poll: " + poll);

    top = maxHeap.peek();
    System.out.println("Top: " + top);

    System.out.println("maxHeap: " + maxHeap.toString());

    int size = maxHeap.size();
    System.out.println("Size: " + size);

    boolean isEmpty = maxHeap.isEmpty();
    System.out.println("isEmpty: " + isEmpty);
  }

}
