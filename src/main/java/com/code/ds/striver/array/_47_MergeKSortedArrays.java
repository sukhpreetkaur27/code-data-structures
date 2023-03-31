package com.code.ds.striver.array;

/**
 * Given K sorted arrays arranged in the form of a matrix of size K*K. The task is to merge them into one sorted array.
Example 1:

Input:
K = 3
arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
Output: 1 2 3 4 5 6 7 8 9
Explanation:Above test case has 3 sorted
arrays of size 3, 3, 3
arr[][] = [[1, 2, 3],[4, 5, 6], 
[7, 8, 9]]
The merged list will be 
[1, 2, 3, 4, 5, 6, 7, 8, 9].
Example 2:

Input:
K = 4
arr[][]={{1,2,3,4}{2,2,3,4},
         {5,5,6,6},{7,8,9,9}}
Output:
1 2 2 2 3 3 4 4 5 5 6 6 7 8 9 9 
Explanation: Above test case has 4 sorted
arrays of size 4, 4, 4, 4
arr[][] = [[1, 2, 2, 2], [3, 3, 4, 4],
[5, 5, 6, 6]  [7, 8, 9, 9 ]]
The merged list will be 
[1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 
6, 6, 7, 8, 9, 9 ].
Your Task:
You do not need to read input or print anything. Your task is to complete mergeKArrays() function which takes 2 arguments, 
an arr[K][K] 2D Matrix containing K sorted arrays and an integer K denoting the number of sorted arrays, as input 
and returns the merged sorted array ( as a pointer to the merged sorted arrays in cpp, as an ArrayList in java, and list in python)

Expected Time Complexity: O(K2*Log(K))
Expected Auxiliary Space: O(K2)

Constraints:
1 <= K <= 100
 * 
 * @author sukh
 *
 */
public class _47_MergeKSortedArrays {

  /**
   * Time: O(N * k log k) <br>
   * N = count of all the elements <br>
   * k = # of arrays <br>
   * Space: O(N * k log k)
   * @param arr
   * @return
   */
  public int[] mergeKArrays(int[][] arr) {
    int n = arr.length;
    int m = arr[0].length;

    int[] output = new int[n * m];

    mergeKArrays(arr, 0, n - 1, output, m);

    return output;
  }

  private void mergeKArrays(int[][] arr, int left, int right, int[] output, int N) {
    // if one array is in range
    if (left == right) {
      for (int i = 0; i < N; i++) {
        output[i] = arr[left][i];
      }
      return;
    }
    // if only two arrays are left them merge them
    if (right - left == 1) {
      merge(arr[left], arr[right], output, N, N);
      return;
    }

    // mid
    int mid = left + (right - left) / 2;

    // output arrays
    int[] output_a = new int[N * (mid - left + 1)];
    int[] output_b = new int[N * (right - mid)];

    mergeKArrays(arr, left, mid, output_a, N);
    mergeKArrays(arr, mid + 1, right, output_b, N);

    merge(output_a, output_b, output, N, N);
  }

  /**
   * merge 2 sorted arrays <br>
   * Time: O(n + m) <bt>
   * Space: O(n + m)
   */
  private void merge(int[] a, int[] b, int[] output, int a_len, int b_len) {
    int index = 0;
    int left = 0;
    int right = 0;

    while (left < a_len && right < b_len) {
      if (a[left] < b[right]) {
        output[index++] = a[left++];
      } else {
        output[index++] = b[right++];
      }
    }
    while (left < a_len) {
      output[index++] = a[left++];
    }
    while (right < b_len) {
      output[index++] = b[right++];
    }
  }

}
