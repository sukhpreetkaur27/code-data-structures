package com.code.ds.striver.trie;

/**
 * Implement Trie:
 * 
 * insert
 * 
 * count words equal to
 * 
 * count words starting with
 * 
 * erase
 * 
 * @author sukh
 *
 */
public class _1_Trie {

  class Node {

    /**
     * NOTE: we can also use Map<Character, Node>
     */
    private Node[] links;
    /**
     * counts words ending with
     */
    private int countEndWith;
    /**
     * counts words with prefix
     */
    private int countPrefixWith;

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

    public int getCountEndWith() {
      return countEndWith;
    }

    public void incrementEnd() {
      this.countEndWith++;
    }

    public void decrementEnd() {
      this.countEndWith--;
    }

    public int getCountPrefixWith() {
      return countPrefixWith;
    }

    public void incrementPrefix() {
      this.countPrefixWith++;
    }

    public void decrementPrefix() {
      this.countPrefixWith--;
    }

    public void erase(char ch) {
      links[ch - 'a'] = null;
    }

    public boolean isEnd() {
      return countEndWith > 0;
    }

  }

  private static Node root;

  public _1_Trie() {
        // Write your code here.
        root=new Node();
    }

  public void insert(String word) {
    Node node = root;
    char[] wordChars = word.toCharArray();
    for (char ch : wordChars) {
      if (!node.containsKey(ch)) {
        node.put(ch, new Node());
      }
      node = node.get(ch);
      node.incrementPrefix();
    }
    node.incrementEnd();
  }

  public int countWordsEqualTo(String word) {
    Node node = root;
    char[] wordChars = word.toCharArray();
    for (char ch : wordChars) {
      if (node.containsKey(ch)) {
        node = node.get(ch);
      } else {
        return 0;
      }
    }
    return node.getCountEndWith();
  }

  public int countWordsStartingWith(String word) {
    Node node = root;
    char[] wordChars = word.toCharArray();
    for (char ch : wordChars) {
      if (node.containsKey(ch)) {
        node = node.get(ch);
      } else {
        return 0;
      }
    }
    return node.getCountPrefixWith();
  }

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

  public void erase(String word) {
    Node node = root;
    if (!search(word)) {
      return;
    }
    // Node temp;
    char[] wordChars = word.toCharArray();
    for (char ch : wordChars) {
      node = node.get(ch);
      // if(temp.getCountEndWith()==1){
      // node.erase(ch);
      // }
      node.decrementPrefix();
      // node=temp;
    }
    node.decrementEnd();
  }

}
