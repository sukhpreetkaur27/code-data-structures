package com.code.ds.striver.queue;

public class _1_ArrayCircularQueue {

  /**
   * Time: O(1)
   */

  private int[] queue;
  private int size;
  private int length;
  private int head;

  public _1_ArrayCircularQueue(int k) {
    length = k;
    queue = new int[length];
  }

  public boolean enQueue(int val) {
    if (size == length) {
      return false;
    }
    int tail = (head + size) % length;
    queue[tail] = val;
    size++;
    return true;
  }

  public boolean deQueue() {
    if (size == 0) {
      return false;
    }
    head = (head + 1) % length;
    size--;
    return true;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == length;
  }

  public int Front() {
    if (size == 0) {
      return -1;
    }
    return queue[head];
  }

  public int Rear() {
    if (size == 0) {
      return -1;
    }
    int tail = (head + size - 1) % length;
    return queue[tail];
  }
}
