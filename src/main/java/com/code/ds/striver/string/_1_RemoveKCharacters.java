package com.code.ds.striver.string;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string s of lowercase alphabets and a number k, the task is to print the minimum value of the string after removal of k characters. The value of a string is defined as the sum of squares of the count of each distinct character.
 

Example 1:

Input: s = abccc, k = 1
Output: 6
Explaination:
We remove c to get the value as 12 + 12 + 22
 

Example 2:

Input: s = aabcbcbcabcc, k = 3
Output: 27
Explaination: We remove two 'c' and one 'b'. 
Now we get the value as 32 + 32 + 32.

Your Task:
You do not need to read input or print anything. Your task is to complete the function minValue() which takes s and k as input parameters and returns the minimum possible required value.

 

Expected Time Complexity: O(N+Klog(P))  where N is the length of string and P is number of distinct alphabets and K number of alphabets to be removed 
Expected Auxiliary Space: O(N)
 * 
 * @author sukh
 *
 */
public class _1_RemoveKCharacters {

  /**
   * Time: O(n + k log p) <br>
   * Space: O(n)
   * @param s
   * @param k
   * @return
   */
  public int solution(String s, int k) {
    /**
     * Space: O(n)
     */
    Map<Character, Integer> charFreqMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
    }

    /**
     * Time: O(n)<br>
     * Space: O(n)
     */
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    for (Map.Entry<Character, Integer> entry : charFreqMap.entrySet()) {
      maxHeap.offer(entry.getValue());
    }

    /**
     * Time: O(k log p)<br>
     * Space: O(1)
     */
    while (k > 0 && !maxHeap.isEmpty()) {
      int top = maxHeap.poll();
      top--;
      if (top > 0) {
        maxHeap.offer(top);
      }
      k--;
    }

    int min = 0;
    while (!maxHeap.isEmpty()) {
      int top = maxHeap.poll();
      min += (top * top);
    }
    return min;
  }

}
