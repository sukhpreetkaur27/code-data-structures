package com.code.ds.striver.trie;

/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. 
 * There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 

Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, search, and startsWith.
 * 
 * @author sukh
 *
 */
public class _0_Trie {
  
  class Node {

    /**
     * NOTE: we can also use Map<Character, Node>
     */
    private Node[] links;
    private boolean flag;

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

    public void setEnd(boolean flag) {
      this.flag = flag;
    }

    public boolean isEnd() {
      return flag;
    }

  }

  private static Node root;

  public _0_Trie() {
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
  public boolean search(String word) {
    Node node = root;
    char[] words = word.toCharArray();
    for (char ch : words) {
      if (!node.containsKey(ch)) {
        return false;
      }
      node = node.get(ch);
    }
    return node.isEnd();
  }

  /**
   * Time: O(len)
   * 
   * @param prefix
   * @return
   */
  public boolean startsWith(String prefix) {
    Node node = root;
    char[] words = prefix.toCharArray();
    for (char ch : words) {
      if (!node.containsKey(ch)) {
        return false;
      }
      node = node.get(ch);
    }
    return true;
  }

}