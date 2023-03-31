package com.code.ds.striver.heap;

public class _3_MaxHeap {

  private int capacity;
  private int size;
  private int[] heap;

  public _3_MaxHeap(int capacity) {
    this.capacity = capacity;
    this.heap = new int[capacity + 1]; // as we don't use the 0-th index
  }

  public void add(int element) {
    size++;

    if (size > capacity) {
      System.out.println("Added too many elements");
      size--;
      return;
    }

    // Index of the newly added element
    int index = size;

    // Parent node of the newly added element
    // Note if we use an array to represent the complete binary tree
    // and store the root node at index 1
    // index of the parent node of any node is [index of the node / 2]
    // index of the left child node is [index of the node * 2]
    // index of the right child node is [index of the node * 2 + 1]
    int parent = index / 2;

    heap[index] = element;

    // If the newly added element is larger than its parent node,
    // its value will be swapped with that of the parent node
    while (index > 1 && heap[index] > heap[parent]) {
      int temp = heap[index];
      heap[index] = heap[parent];
      heap[parent] = temp;
      index = parent;
      parent = index / 2;
    }
  }

  // Delete the top element of the Heap
  public int pop() {
    if (size == 0) {
      System.out.println("Heap is empty");
      return Integer.MAX_VALUE;
    }

    int pop = heap[1];
    // Put the last element in the Heap to the top of Heap
    heap[1] = heap[size];
    size--;

    int index = 1;

    // When the deleted element is not a leaf node
    while (index <= size / 2) {
      // the left child of the deleted element
      int left = index * 2;
      // the right child of the deleted element
      int right = index * 2 + 1;

      // If the deleted element is smaller than the left or right child
      // its value needs to be swapped with the larger value
      // of the left and right child
      if (heap[index] < heap[left] || heap[index] < heap[right]) {
        if (heap[left] > heap[right]) {
          int temp = heap[index];
          heap[index] = heap[left];
          heap[left] = temp;
          index = left;
        } else {
          int temp = heap[index];
          heap[index] = heap[right];
          heap[right] = temp;
          index = right;
        }
      } else {
        break;
      }
    }

    return pop;
  }

  // Get the top element of the Heap
  public int peek() {
    return heap[1];
  }

  // return the number of elements in the Heap
  public int size() {
    return size;
  }

  public String toString() {
    if (size == 0) {
      return "No element";
    }
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 1; i <= size; i++) {
      sb.append(heap[i]);
      sb.append(",");
    }
    sb.deleteCharAt(sb.length() - 1);
    sb.append("]");
    return sb.toString();
  }

  public static void main(String[] args) {
    // Test case
    _3_MaxHeap maxheap = new _3_MaxHeap(5);
    maxheap.add(1);
    maxheap.add(2);
    maxheap.add(3);
    // [3,1,2]
    System.out.println(maxheap.toString());
    // 3
    System.out.println(maxheap.peek());
    // 3
    System.out.println(maxheap.pop());
    System.out.println(maxheap.pop());
    System.out.println(maxheap.pop());
    // No element
    System.out.println(maxheap.toString());
    maxheap.add(4);
    // Add too many elements
    maxheap.add(5);
    // [4,1,2]
    System.out.println(maxheap.toString());
  }

}