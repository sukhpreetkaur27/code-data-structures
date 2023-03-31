package com.code.ds.striver.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Given two integer array A and B of size N each.
A sum combination is made by adding one element from array A and another element of array B.
Return the maximum K valid distinct sum combinations from all the possible sum combinations.

Note : Output array must be sorted in non-increasing order.

Example 1:

Input:
N = 2
C = 2
A [ ] = {3, 2}
B [ ] = {1, 4}
Output: {7, 6}
Explanation: 
7 -> (A : 3) + (B : 4)
6 -> (A : 2) + (B : 4)
Example 2:

Input:
N = 4
C = 3
A [ ] = {1, 4, 2, 3}
B [ ] = {2, 5, 1, 6}
Output: {10, 9, 9}
Explanation: 
10 -> (A : 4) + (B : 6)
9 -> (A : 4) + (B : 5)
9 -> (A : 3) + (B : 6)
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxCombinations() which takes the integer N,
integer K and two integer arrays A [ ] and B [ ] as parameters and returns the maximum K valid distinct sum combinations .

Expected Time Complexity: O(Klog(N))
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤  105
1 ≤ K ≤  N
1 ≤ A [ i ] , B [ i ] ≤ 1000
 * 
 * @author sukh
 *
 */
public class _16_MaxSumCombination {

  private static class Pair {
    /**
     * a[] index
     */
    int a;
    /**
     * b[] index
     */
    int b;

    Pair(int a, int b) {
      this.a = a;
      this.b = b;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + Objects.hash(a, b);
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Pair other = (Pair) obj;
      return a == other.a && b == other.b;
    }

  }

  private static class PairSum {
    /**
     * sum = a[a] + b[b]
     */
    int sum;
    int a;
    int b;

    PairSum(int sum, int a, int b) {
      this.sum = sum;
      this.a = a;
      this.b = b;
    }
  }

  /**
   * Time: O(n log n) <br>
   * Space: O(n)
   * @param a
   * @param b
   * @param k
   * @return
   */
  public List<Integer> maxCombinations(int[] a, int[] b, int k) {
    /**
     * n == a.length == b.length
     */
    int n = a.length;

    /**
     * Sort both the arrays
     */
    Arrays.sort(a);
    Arrays.sort(b);

    List<Integer> list = new ArrayList<>();

    /**
     * Stores the max sum combination
     */
    PriorityQueue<PairSum> maxHeap = new PriorityQueue<>(k + 1, (x, y) -> y.sum - x.sum);

    /**
     * Store unique pairs of sum
     */
    Set<Pair> pairs = new HashSet<>();

    Pair pair = new Pair(n - 1, n - 1);
    pairs.add(pair);

    int sum = a[n - 1] + b[n - 1];
    PairSum pairSum = new PairSum(sum, n - 1, n - 1);

    maxHeap.offer(pairSum);

    for (int i = 0; i < k; i++) {
      pairSum = maxHeap.poll();

      list.add(pairSum.sum);

      addPair(pairs, maxHeap, pairSum.a - 1, pairSum.b, a, b);

      addPair(pairs, maxHeap, pairSum.a, pairSum.b - 1, a, b);
    }

    return list;
  }

  private void addPair(Set<Pair> pairs, PriorityQueue<PairSum> maxHeap, int indx1,
      int indx2, int[] a, int[] b) {
    Pair pair = new Pair(indx1, indx2);

    if (indx1 >= 0 && indx2 >= 0 && !pairs.contains(pair)) {
      pairs.add(pair);

      int sum = a[indx1] + b[indx2];

      PairSum pairSum = new PairSum(sum, indx1, indx2);

      maxHeap.offer(pairSum);
    }
  }

}
