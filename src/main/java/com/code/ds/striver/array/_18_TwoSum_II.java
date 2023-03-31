package com.code.ds.striver.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two unsorted arrays A of size N and B of size M of distinct elements, the task is to find all pairs from both arrays whose sum is equal to X.

Note: All pairs should be printed in increasing order of u. For eg. for two pairs (u1,v1) and (u2,v2), if u12 then
(u1,v1) should be printed first else second.

Example 1:

Input:
A[] = {1, 2, 4, 5, 7}
B[] = {5, 6, 3, 4, 8} 
X = 9 
Output: 
1 8
4 5 
5 4
Explanation:
(1, 8), (4, 5), (5, 4) are the
pairs which sum to 9.
Example 2:
Input:
A[] = {-1, -2, 4, -6, 5, 7}
B[] = {6, 3, 4, 0} 
X = 8 
Output:
4 4 
5 3
 * 
 * @author sukh
 *
 */
public class _18_TwoSum_II {

  class pair {
    long first, second;

    pair(long first, long second) {
      this.first = first;
      this.second = second;
    }
  }

  /**
   * Time: O(n log n)<br>
   * Space: O(n)
   * @param a
   * @param b
   * @param target
   * @return
   */
  public pair[] allPairs(long[] a, long[] b, long target) {
    List<pair> pairList = new ArrayList<>();

    Arrays.sort(a);

    Map<Long, Integer> numIndexMap = new HashMap<>();
    for (int i = 0; i < b.length; i++) {
      numIndexMap.put(b[i], i);
    }

//    List<Long> bList=Arrays.stream(b).boxed().collect(Collectors.toList());

    for (long i : a) {
      long complement = target - i;
      if (numIndexMap.containsKey(complement)) {
        pairList.add(new pair(i, complement));
      }
    }

    pair[] pairs = new pair[pairList.size()];
    return pairList.toArray(pairs);
  }

}
