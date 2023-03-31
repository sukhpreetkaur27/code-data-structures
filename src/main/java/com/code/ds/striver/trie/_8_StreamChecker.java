package com.code.ds.striver.trie;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Design an algorithm that accepts a stream of characters and checks if a suffix of these characters is a string of a given array of strings words.

For example, if words = ["abc", "xyz"] and the stream added the four characters (one by one) 'a', 'x', 'y', and 'z', your algorithm should detect 
that the suffix "xyz" of the characters "axyz" matches "xyz" from words.

Implement the StreamChecker class:

StreamChecker(String[] words) Initializes the object with the strings array words.
boolean query(char letter) Accepts a new character from the stream and returns true if any non-empty suffix from the stream forms a word that is in words.
 

Example 1:

Input
["StreamChecker", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query"]
[[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], ["i"], ["j"], ["k"], ["l"]]
Output
[null, false, false, false, true, false, true, false, false, false, false, false, true]

Explanation
StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
streamChecker.query("a"); // return False
streamChecker.query("b"); // return False
streamChecker.query("c"); // return False
streamChecker.query("d"); // return True, because 'cd' is in the wordlist
streamChecker.query("e"); // return False
streamChecker.query("f"); // return True, because 'f' is in the wordlist
streamChecker.query("g"); // return False
streamChecker.query("h"); // return False
streamChecker.query("i"); // return False
streamChecker.query("j"); // return False
streamChecker.query("k"); // return False
streamChecker.query("l"); // return True, because 'kl' is in the wordlist
 

Constraints:

1 <= words.length <= 2000
1 <= words[i].length <= 200
words[i] consists of lowercase English letters.
letter is a lowercase English letter.
At most 4 * 104 calls will be made to query.
 * 
 * @author sukh
 *
 */
public class _8_StreamChecker {

  private _8_Trie trie;
  private Deque<Character> stream;

  public _8_StreamChecker(String[] words) {
    trie = new _8_Trie();
    for (String word : words) {
      trie.insert(word);
    }
    stream = new ArrayDeque<>();
  }

  public boolean query(char letter) {
    stream.push(letter);
    return trie.search(stream);
  }

}

class _8_Trie {
  class Node {
    private Map<Character, Node> links;
    private boolean word;

    private Node() {
      links = new HashMap<>();
    }

    public boolean containsKey(char ch) {
      return links.containsKey(ch);
    }

    public void put(char ch) {
      links.put(ch, new Node());
    }

    public Node get(char ch) {
      return links.get(ch);
    }

    public void setWord(boolean word) {
      this.word = word;
    }

    public boolean isWord() {
      return word;
    }
  }

  private Node root;

  public _8_Trie() {
    root = new Node();
  }

  public void insert(String word) {
    Node node = root;
    for (int i = word.length() - 1; i >= 0; i--) {
      char ch = word.charAt(i);
      if (!node.containsKey(ch)) {
        node.put(ch);
      }
      node = node.get(ch);
    }
    node.setWord(true);
  }

  public boolean search(Deque<Character> stream) {
    Node node = root;
    for (char ch : stream) {
      if (!node.containsKey(ch)) {
        return false;
      }
      node = node.get(ch);
      if (node.isWord()) {
        return true;
      }
    }
    return false;
  }
}
