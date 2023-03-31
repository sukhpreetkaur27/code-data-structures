package com.code.ds.striver.trie;

/**
 * A string is called a complete string if every prefix of this string is also
 * present in the array.
 * 
 * Find the longest complete string in the array.
 * 
 * If there are multiple strings with the same length, return the
 * lexicographically smallest one and if no string exists, return "None".
 * 
 * @author sukh
 *
 */
public class _3_CompleteString {

  private _3_Trie trie;

  public _3_CompleteString() {
    trie = new _3_Trie();
  }

  /**
   * Time: O(n * length of the longest string) <br>
   * Space: Difficult to estimate as for the first string there will be 26 objects
   * and so on, but generally we don't have 26 objects per character due t common
   * prefixes
   * 
   * @param a
   * @return
   */
  public String completeString(String[] a) {
    /**
     * Insert all words into the Trie
     * 
     * Time: O(n * length of the longest string)
     */
    for (String str : a) {
      trie.insert(str);
    }
    int longestIndex = -1;
    int max = 0;
    /**
     * Time: O(n * length of the longest string)
     */
    for (int i = 0; i < a.length; i++) {
      if (trie.searchPrefix(a[i])) {
        if (max < a[i].length()) {
          max = a[i].length();
          longestIndex = i;
        }
        /**
         * if the longest complete strings are of same length find the lexicographically
         * smallest (use compareTo())
         */
        else if (max == a[i].length() && a[i].compareTo(a[longestIndex]) < 0) {
          longestIndex = i;
        }
      }
    }
    return longestIndex != -1 ? a[longestIndex] : "None";
  }

  public static void main(String[] args) {
    String[] a = { "ak", "szhkb", "a", "g", "hy" };
    _3_CompleteString obja = new _3_CompleteString();
    String answera = obja.completeString(a);
    System.out.println(answera); // ak

    String[] b = { "vfjq", "kez", "vfj", "dotkr", "vfjqo" };
    _3_CompleteString objb = new _3_CompleteString();
    String answerb = objb.completeString(b);
    System.out.println(answerb); // None

    String[] c = { "n", "l", "i", "um", "ar", "xcfyc" };
    _3_CompleteString objc = new _3_CompleteString();
    String answerc = objc.completeString(c);
    System.out.println(answerc); // i
  }

}

class _3_Trie {

  private class Node {

    /**
     * NOTE: we can also use Map<Character, Node>
     */
    private Node[] links;
    private boolean end;

    public Node() {
      links = new Node[26];
    }

    public boolean containsKey(char ch) {
      return links[ch - 'a'] != null;
    }

    public void put(char ch, Node node) {
      links[ch - 'a'] = node;
    }

    public Node get(char ch) {
      return links[ch - 'a'];
    }

    public void setEnd(boolean end) {
      this.end = end;
    }

    public boolean isEnd() {
      return end;
    }

  }

  private static Node root;

  public _3_Trie() {
    root = new Node();
  }

  /**
   * Time: O(len)
   * 
   * @param word
   */
  public void insert(String word) {
    Node node = root;
    char[] words = word.toCharArray();
    for (char ch : words) {
      if (!node.containsKey(ch)) {
        node.put(ch, new Node());
      }
      // Moves to the reference Trie
      node = node.get(ch);
    }
    // marks completion of word
    // we are at the last reference Trie
    node.setEnd(true);
  }

  /**
   * Time: O(len)
   * 
   * @param word
   * @return
   */
  public boolean searchPrefix(String word) {
    Node node = root;
    char[] words = word.toCharArray();
    for (char ch : words) {
      node = node.get(ch);
      if (!node.isEnd()) {
        return false;
      }
    }
    return true;
  }
}
