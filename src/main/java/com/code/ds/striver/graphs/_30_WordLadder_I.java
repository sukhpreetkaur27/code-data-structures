package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, 
or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
 * 
 * @author sukh
 *
 */
public class _30_WordLadder_I {

  class Pair {
    String word;
    int level;

    Pair(String word, int level) {
      this.word = word;
      this.level = level;
    }
  }

  /**
   * Time: O(n * word_length) <br>
   * Space: O(n)
   * 
   * @param beginWord
   * @param endWord
   * @param wordList
   * @return
   */
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    /**
     * BFS
     */
    /**
     * Search from Set takes O(1) time
     * 
     * whereas, linear search from a List takes O(n) time
     */
    Set<String> words = new HashSet<>(wordList);

    Deque<Pair> queue = new ArrayDeque<>();
    queue.offer(new Pair(beginWord, 1));

    while (!queue.isEmpty()) {
      Pair pop = queue.poll();
      String word = pop.word;
      int level = pop.level;
      /**
       * if the word is found
       */
      if (word.equals(endWord)) {
        return level;
      }
      char[] replaceWord = word.toCharArray();
      /**
       * Compare character by character each and every possible word in the word list
       * 
       * all scenarios being at the same level
       */
      /**
       * Time: O(word_length * 26)
       */
      for (int i = 0; i < word.length(); i++) {
        char ch = replaceWord[i];
        for (char a = 'a'; a <= 'z'; a++) {
          replaceWord[i] = a;
          String temp = new String(replaceWord);
          if (words.contains(temp)) {
            /**
             * if a matching word exists in the word list
             * 
             * add it to the queue
             * 
             * remove it from the word list (in order to mark it as visited)
             */
            queue.offer(new Pair(temp, level + 1));
            words.remove(temp);
          }
        }
        replaceWord[i] = ch;
      }
    }

    return 0;
  }

}
