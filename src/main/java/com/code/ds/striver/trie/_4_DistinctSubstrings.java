package com.code.ds.striver.trie;

/**
 * Given a string of length N of lowercase alphabet characters. The task is to complete the function countDistinctSubstring(), 
 * which returns the count of total number of distinct substrings of this string.

Input:
The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. Each test case contains a string str.

Output:
For each test case in a new line, output will be an integer denoting count of total number of distinct substrings of this string.

User Task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function countDistinctSubstring().

Constraints:
1 ≤ T ≤ 10
1 ≤ N ≤ 1000

Example(To be used only for expected output):
Input:
2
ab
ababa

Output:
4
10

Exaplanation:
Testcase 1: For the given string "ab" the total distinct substrings are: "", "a", "b", "ab".
 * 
 * @author sukh
 *
 */
public class _4_DistinctSubstrings {

  /**
   * Time: O(n * S) + O(n * S) <br>
   * S = maximum length of a string <br>
   * Space: O(S). In the worst-case newly inserted key doesn't share a prefix with
   * the keys already inserted in the trie. We have to add M new nodes, which
   * takes O(M) space.
   * 
   * NOTE: Space is hypothetical for Trie as if the strings share common prefix,
   * the existing space is used.
   * 
   * @param st
   * @return
   */
  public int countDistinctSubstring(String st) {
    int count = 1;
    _4_Trie trie = new _4_Trie();
    char[] string = st.toCharArray();
    for (int i = 0; i < string.length; i++) {
      count += trie.insertAndCount(string, i);
    }
    return count;
  }

}

class _4_Trie {
  private class Node {
    private Node[] links;

    Node() {
      links = new Node[26];
    }

    boolean containsKey(char ch) {
      return links[ch - 'a'] != null;
    }

    void put(char ch, Node node) {
      links[ch - 'a'] = node;
    }

    Node get(char ch) {
      return links[ch - 'a'];
    }
  }

  private Node root;

  public _4_Trie() {
    root = new Node();
  }

  public int insertAndCount(char[] word, int start) {
    int count = 0;
    int end = word.length;
    Node node = root;
    for (int i = start; i < end; i++) {
      if (!node.containsKey(word[i])) {
        node.put(word[i], new Node());
        count++;
      }
      node = node.get(word[i]);
    }
    return count;
  }
}
