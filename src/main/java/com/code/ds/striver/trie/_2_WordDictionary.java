package com.code.ds.striver.trie;

/**
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' 
where dots can be matched with any letter.
 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 

Constraints:

1 <= word.length <= 25
word in addWord consists of lowercase English letters.
word in search consist of '.' or lowercase English letters.
There will be at most 3 dots in word for search queries.
At most 104 calls will be made to addWord and search.
 * 
 * @author sukh
 *
 */
public class _2_WordDictionary {

  /**
   * Time complexity: O(M) for the "well-defined" words without dots, where MM is
   * the key length, and NN is a number of keys, and O(N * 26 ^ M) for the
   * "undefined" words. That corresponds to the worst-case situation of searching
   * an undefined word M times {.........}
   * 
   * ​ which is one character longer than all inserted keys.
   * 
   * Space complexity:O(1) for the search of "well-defined" words without dots,
   * and up to O(M) for the "undefined" words, to keep the recursion stack.
   * 
   */

  class TrieNode {

    private TrieNode[] links;
    private boolean word;

    private TrieNode() {
      links = new TrieNode[26];
    }

    public boolean containsKey(char ch) {
      return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
      return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
      links[ch - 'a'] = node;
    }

    public boolean getWord() {
      return word;
    }

    public void setWord(boolean word) {
      this.word = word;
    }

    public TrieNode[] getLinks() {
      return links;
    }

  }

  private static TrieNode root;

  public _2_WordDictionary() {
    root = new TrieNode();
  }

  public void addWord(String word) {
    TrieNode node = root;
    for (char ch : word.toCharArray()) {
      if (!node.containsKey(ch)) {
        node.put(ch, new TrieNode());
      }
      node = node.get(ch);
    }
    node.setWord(true);
  }

  public boolean search(String word) {
    return search(word, root);
  }

  private boolean search(String word, TrieNode node) {
    char ch;
    for (int i = 0; i < word.length(); i++) {
      ch = word.charAt(i);
      if (ch == '.') {
        for (TrieNode subNode : node.getLinks()) {
          if (subNode != null && search(word.substring(i + 1), subNode)) {
            return true;
          }
        }
        return false;
      }
      if (!node.containsKey(ch)) {
        return false;
      }
      node = node.get(ch);
    }
    return node.getWord();
  }

}
