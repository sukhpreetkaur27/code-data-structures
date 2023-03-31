package com.code.ds.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Time: O(n log n + m log k)<br>
 * Space: O(k)
 * 
 * 
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
 

Example 1:

Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8
 

Constraints:

1 <= k <= 104
0 <= nums.length <= 104
-104 <= nums[i] <= 104
-104 <= val <= 104
At most 104 calls will be made to add.
It is guaranteed that there will be at least k elements in the array when you search for the kth element.
 * @author sukh
 *
 */
public class KLargestStream {

  private int k;
  private Queue<Integer> minHeap;

  /**
   * Time: O(n log n)<br>
   * Space: O(k)
   * @param nums
   * @param k
   */
  public KLargestStream(int[] nums, int k) {
    this.k = k;
    this.minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);

    for (int num : nums) {
      minHeap.offer(num);
      poll();
    }
  }

  /**
   * Time: O(m log k)<br>
   * Space: O(1)
   * @param val
   * @return
   */
  public int add(int val) {
    minHeap.offer(val);
    poll();
    return minHeap.peek();
  }

  private void poll() {
    if (minHeap.size() > k) {
      minHeap.poll();
    }
  }

  public static void main(String[] args) {
    int[] nums = { 4, 5, 8, 2 };
    int k = 3;
    System.out.println(Arrays.toString(nums));
    KLargestStream obj = new KLargestStream(nums, k);
    System.out.println(obj.add(3));
    System.out.println(obj.add(5));
    System.out.println(obj.add(10));
    System.out.println(obj.add(9));
    System.out.println(obj.add(4));
  }

}
