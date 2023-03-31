package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
public class _32_WordLadder_II {

  /**
   * NOTE:
   * 
   * We perform DFS and backtrack to avoid TLE
   * 
   * Here, we start from the end word towards the begin word. As a result, we have
   * few comparisons to check.
   * 
   * Whereas, in BFS we had multiple comparisons to check at each level (actual
   * answer have few paths which lead to the end word). Hence, wastage of time.
   */

  /**
   * 
   * @param beginWord
   * @param endWord
   * @param wordList
   * @return
   */
  public List<List<String>> findLadders(String beginWord, String endWord,
      List<String> wordList) {
    List<List<String>> res = new ArrayList<>();
    /**
     * Map consists of each word with its level
     * 
     * this map consists of the shortest path such that the end word is at the
     * shortest path
     */
    Map<String, Integer> ladderLength = ladderLength(beginWord, endWord, wordList);
    if (ladderLength.isEmpty()) {
      return res;
    }
    List<String> temp = new ArrayList<>();
    temp.add(endWord);
    /**
     * Perform DFS and backtrack beginning from the end word with level as the
     * shortest path
     */
    dfs(res, temp, ladderLength, endWord, ladderLength.get(endWord));

    return res;
  }

  private void dfs(List<List<String>> res, List<String> list,
      Map<String, Integer> ladderLength, String word, int level) {
    /**
     * if level 1 is reached --> we have found our list
     */
    if (level == 1) {
      List<String> ans = new ArrayList<>(list);
      Collections.reverse(ans);
      res.add(ans);
      return;
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
        /**
         * if the proposed word is at the same level as per the map --> then it can lead
         * us to a probable solution
         */
        if (ladderLength.getOrDefault(temp, -1) == level - 1) {
          list.add(temp);
          dfs(res, list, ladderLength, temp, level - 1);
          /**
           * backtrack
           */
          list.remove(list.size() - 1);
        }
      }
      replaceWord[i] = ch;
    }
  }

  class Pair {
    String word;
    int level;

    Pair(String word, int level) {
      this.word = word;
      this.level = level;
    }
  }

  /**
   * Same as {@link com.code.ds.striver.graphs._30_WordLadder_I}
   */
  public Map<String, Integer> ladderLength(String beginWord, String endWord,
      List<String> wordList) {
    Map<String, Integer> ladderLength = new HashMap<>();
    Set<String> words = new HashSet<>(wordList);
    if (!words.contains(endWord)) {
      return ladderLength;
    }
    Deque<Pair> queue = new ArrayDeque<>();
    queue.offer(new Pair(beginWord, 1));
    ladderLength.put(beginWord, 1);
    if (words.contains(beginWord)) {
      words.remove(beginWord);
    }
    while (!queue.isEmpty()) {
      Pair pop = queue.poll();
      String word = pop.word;
      int level = pop.level;
      if (word.equals(endWord)) {
        break;
      }
      char[] replaceWord = word.toCharArray();
      for (int i = 0; i < word.length(); i++) {
        char ch = replaceWord[i];
        for (char a = 'a'; a <= 'z'; a++) {
          replaceWord[i] = a;
          String temp = new String(replaceWord);
          if (words.contains(temp)) {
            ladderLength.put(temp, level + 1);
            queue.offer(new Pair(temp, level + 1));
            words.remove(temp);
          }
          replaceWord[i] = ch;
        }
      }
    }

    return ladderLength;
  }

}
