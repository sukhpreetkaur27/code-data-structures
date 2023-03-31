package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, 
or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation: There are 2 shortest transformation sequences:
"hit" -> "hot" -> "dot" -> "dog" -> "cog"
"hit" -> "hot" -> "lot" -> "log" -> "cog"
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: []
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 5
endWord.length == beginWord.length
1 <= wordList.length <= 500
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
The sum of all shortest transformation sequences does not exceed 105.
 * 
 * @author sukh
 *
 */
public class _31_WordLadder_II {

  /**
   * NOTE:
   * 
   * This approach is best for interviews
   * 
   * But it fails on LeetCode - TLE
   * 
   * Check for the optimized approach {@link com.code.ds.striver.graphs._32_WordLadder_II}
   */

  /**
   * Time: O(n * word_length) <br>
   * Space: O(n)
   * 
   * @param beginWord
   * @param endWord
   * @param wordList
   * @return
   */
  public List<List<String>> findLadders(String beginWord, String endWord,
      List<String> wordList) {
    /**
     * BFS
     */
    List<List<String>> res = new ArrayList<>();

    /**
     * Search from Set takes O(1) time
     * 
     * whereas, linear search from a List takes O(n) time
     */
    Set<String> words = new HashSet<>(wordList);

    /**
     * Queue stores the list of words in a chain
     * 
     * the size of the list = the level of the BFS
     */
    Deque<List<String>> queue = new ArrayDeque<>();
    List<String> start = new ArrayList<>();
    start.add(beginWord);
    queue.offer(start);

    /**
     * Set of used words per level
     * 
     * to be deleted after each level
     */
    Set<String> usedOnLevel = new HashSet<>();
    usedOnLevel.add(beginWord);

    /**
     * shortest path (level) in progress to destination
     */
    int shortest = 0;
    /**
     * Stores the shortest path till destination word
     */
    int flag = Integer.MAX_VALUE;

    while (!queue.isEmpty()) {
      List<String> pop = queue.poll();
      int level = pop.size();
      String word = pop.get(level - 1);

      /**
       * if level > the shortest path reached till destination word
       * 
       * exit from the BFS traversal
       */
      if (level > flag) {
        break;
      }

      /**
       * After each level remove the list of used words from the word list
       * 
       * this is a way of marking the visited words per level
       */
      if (level > shortest) {
        shortest = level;
        for (String toRemove : usedOnLevel) {
          words.remove(toRemove);
        }
        usedOnLevel.clear();
      }

      /**
       * if the destination is reached
       * 
       * mark the path length
       */
      if (word.equals(endWord)) {
        res.add(pop);
        flag = shortest;
        continue;
      }

      /**
       * Compare character by character each and every possible word in the word list
       * 
       * all scenarios being at the same level
       */
      /**
       * Time: O(word_length * 26)
       */
      char[] replaceWord = word.toCharArray();
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
             */
            List<String> list = new ArrayList<>(pop);
            list.add(temp);
            queue.offer(list);

            /**
             * Add the word to the used words per level list
             */
            usedOnLevel.add(temp);
          }
        }
        replaceWord[i] = ch;
      }

    }

    return res;
  }

}
