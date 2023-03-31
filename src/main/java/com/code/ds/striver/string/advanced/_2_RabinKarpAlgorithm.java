package com.code.ds.striver.string.advanced;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two strings, one is a text string and other is a pattern string. The task is to print the indexes of all the occurences of pattern string in the text string. 
 * For printing, Starting Index of a string should be taken as 1.

Example 1:

Input:
S = "batmanandrobinarebat", pat = "bat"
Output: 1 18
Explanation: The string "bat" occurs twice
in S, one starts are index 1 and the other
at index 18. 
â€‹Example 2:

Input: 
S = "abesdu", pat = "edu"
Output: -1
Explanation: There's not substring "edu"
present in S.

Your Task:
You don't need to read input or print anything. Your task is to complete the function search() which takes the string S and the string pat as inputs 
and returns an array denoting the start indices (1-based) of substring pat in the string S. 


Expected Time Complexity: O(|S|*|pat|).
Expected Auxiliary Space: O(1).


Constraints:
1<=|S|<=105
1<=|pat|<|S|
 * 
 * @author sukh
 *
 */
public class _2_RabinKarpAlgorithm {

  /**
   * Average Time: O(n + m) <br>
   * Worst Time: O(n * m) <br>
   * Space: O(1)
   * @param pat
   * @param s
   * @return
   */
  public List<Integer> search(String pat, String s) {
    final int p = 31;
    final long m = (long) 1e9 + 9;

    final int n = s.length();
    final int patt_len = pat.length();
    long hash = 0l;
    long pow = 1l;
    for (int i = 0; i < patt_len; i++) {
      hash = (hash * p % m + (pat.charAt(i) - 'a' + 1)) % m;
    }
    List<Integer> indexes = new ArrayList<>();
    long curr_hash = 0l;

    pow = 1l;
    for (int i = 0; i < n; i++) {
      curr_hash = (curr_hash * p + (s.charAt(i) - 'a' + 1)) % m;
      if (i >= patt_len) {
        curr_hash = (curr_hash - ((s.charAt(i - patt_len) - 'a' + 1) * pow % m) + m) % m;
      } else {
        pow = pow * p % m;
      }
      if (i >= patt_len - 1) {
        if (curr_hash == hash) {
          String curr = s.substring(i - patt_len + 1, i + 1);
          /**
           * check for collisions
           */
          if (curr.equals(pat)) {
            indexes.add(i - patt_len + 2);
          }
        }
      }
    }
    if (indexes.isEmpty()) {
      indexes.add(-1);
    }
    return indexes;
  }

  public static void main(String[] args) {
    _2_RabinKarpAlgorithm obj = new _2_RabinKarpAlgorithm();
    String s = "batmanandrobinarebat";
    String p = "bat";
    obj.search(p, s);
  }

}
