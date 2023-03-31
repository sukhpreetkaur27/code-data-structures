package com.code.ds.striver.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class _1_PriorityQueue {

  public void priorityQueue() {
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

  public static void main(String[] args) {
    _1_PriorityQueue obj = new _1_PriorityQueue();
    obj.priorityQueue();
  }

}
