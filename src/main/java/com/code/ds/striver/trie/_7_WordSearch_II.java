package com.code.ds.striver.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. 
The same letter cell may not be used more than once in a word.

 

Example 1:


Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.
 * 
 * @author sukh
 *
 */
public class _7_WordSearch_II {

  /**
   * Time: O(n * m * 4 * 3 ^ (L-1))
   * 
   * we start from each node in the board
   * 
   * for each node we move in 4 directions
   * 
   * out of the 4 directions we further have chance to move in 3 directions
   * recursively
   * 
   * Why 3? as -1 is for the parent node (now marked as '#')
   * 
   * L = maximum string length --> which accounts to the depth of the recursive
   * tree
   * 
   * L -1 ? -1 due to the first matched character
   * 
   * Space: O(N)
   * 
   * N = total number of letters in the dictionary.
   * 
   * @param board
   * @param words
   * @return
   */
  public List<String> findWords(char[][] board, String[] words) {
    _7_Trie trie = new _7_Trie();
    /**
     * Put all words in the dictionary into the Trie
     */
    for (String word : words) {
      trie.insert(word);
    }
    List<String> list = new ArrayList<>();
    /**
     * Consider each node as the starting point
     * 
     * Start from the root of Trie
     */
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        search(board, row, col, list, trie.root);
      }
    }
    return list;
  }

  private static final int[] offset = { 0, 1, 0, -1, 0 };

  private void search(char[][] board, int row, int col, List<String> words,
      _7_Trie.Node parent) {
    /**
     * Base Case
     */
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
      return;
    }
    /**
     * Edge Case
     * 
     * for nodes visited in the current recursive branch
     */
    if (board[row][col] == '#') {
      return;
    }
    char ch = board[row][col];
    /**
     * if the parent Trie node doesn't contains the character --> it means the
     * prefix doesn't exist
     * 
     * no need to traverse further
     */
    if (!parent.containsKey(ch)) {
      return;
    }

    /**
     * marking the node as visited
     */
    board[row][col] = '#';

    /**
     * choose the child node as parent for further traversal
     */
    _7_Trie.Node node = parent.get(ch);
    /**
     * word exists in the trie node
     * 
     * consider it as word found in the dictionary
     * 
     * NOTE: mark the word as null in the Trie dictionary in order to avoid
     * duplicate results and thus overriding the need of Hashing (HashSet) which
     * have an overhead.
     */
    if (node.word != null) {
      words.add(node.word);
      node.word = null;
    }

    /**
     * Traverse in all 4 directions
     */
    for (int k = 0, r = 0, c = 0; k < 4; k++) {
      r = row + offset[k];
      c = col + offset[k + 1];
      search(board, r, c, words, node);
    }

    /**
     * unmark the node
     */
    board[row][col] = ch;

    /**
     * Prune the Trie on backtracking for leaf nodes
     * 
     * this is just an optimization to avoid duplicate traversals into the Trie
     */
    if (node.isEmpty()) {
      parent.remove(ch);
    }
  }
}

class _7_Trie {
  class Node {
    Map<Character, Node> links;
    String word;

    private Node() {
      this.links = new HashMap<>();
    }

    public boolean containsKey(char ch) {
      return links.containsKey(ch);
    }

    public void put(char ch, Node node) {
      links.put(ch, node);
    }

    public Node get(char ch) {
      return links.get(ch);
    }

    public boolean isEmpty() {
      return links.isEmpty();
    }

    public void remove(char ch) {
      links.remove(ch);
      word = null;
    }
  }

  Node root;

  public _7_Trie() {
    this.root = new Node();
  }

  public void insert(String word) {
    Node node = root;
    char ch;
    for (int i = 0; i < word.length(); i++) {
      ch = word.charAt(i);
      if (!node.containsKey(ch)) {
        node.put(ch, new Node());
      }
      node = node.get(ch);
    }
    /**
     * NOTE: completion of the word in the Trie is marked by saving the word in the
     * "word" field
     */
    node.word = word;
  }
}
