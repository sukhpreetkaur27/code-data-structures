package com.code.ds.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).

 

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2
 * @author sukh
 *
 */
public class KSmallestSortedMatrix {

  class Node {
    int val;
    int row;
    int col;

    Node(int val, int row, int col) {
      this.val = val;
      this.row = row;
      this.col = col;
    }
  }

  class MinHeapComparator implements Comparator<Node> {
    public int compare(Node x, Node y) {
      return x.val - y.val;
    }
  }

  /**
   * X = min(n,k)
   * Time: O(X log X + k log X))<br>
   * Space: O(X)
   * @param matrix
   * @param k
   * @return
   */
  public int kSmallest(int[][] matrix, int k) {
    int n = matrix.length;

    /**
     * Time: O(min(n,k) log (min(n, k)))<br>
     * Space: O(min(n,k))
     */
    int row, col;
    Queue<Node> minHeap = new PriorityQueue<>(Math.min(n, k), new MinHeapComparator());
    for (row = 0, col = 0; row < Math.min(n, k); row++) {
      minHeap.offer(new Node(matrix[row][col], row, col));
    }

    /**
     * Time: O(k log (min(n,k)))<br>
     * Space: O(1)
     */
    Node smallest = minHeap.peek();
    while (k-- > 0) {
      smallest = minHeap.poll();

      row = smallest.row;
      col = smallest.col;

      if (col < n - 1) {
        minHeap.offer(new Node(matrix[row][col + 1], row, col + 1));
      }
    }
    return smallest.val;
  }

  public static void main(String[] args) {
    int n = 3;
    int k = 8;
    int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
    for (int row = 0; row < n; row++) {
      System.out.println(Arrays.toString(matrix[row]));
    }

    KSmallestSortedMatrix obj = new KSmallestSortedMatrix();
    int kSmallest = obj.kSmallest(matrix, k);
    System.out.println(k + "-th smallest = " + kSmallest);
  }

}
