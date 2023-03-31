package com.code.ds.hashtable.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays of strings list1 and list2, find the common strings with the least index sum.

A common string is a string that appeared in both list1 and list2.

A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.

Return all the common strings with the least index sum. Return the answer in any order.

 

Example 1:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
Output: ["Shogun"]
Explanation: The only common string is "Shogun".
Example 2:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
Output: ["Shogun"]
Explanation: The common string with the least index sum is "Shogun" with index sum = (0 + 1) = 1.
Example 3:

Input: list1 = ["happy","sad","good"], list2 = ["sad","happy","good"]
Output: ["sad","happy"]
Explanation: There are three common strings:
"happy" with index sum = (0 + 1) = 1.
"sad" with index sum = (1 + 0) = 1.
"good" with index sum = (2 + 2) = 4.
The strings with the least index sum are "sad" and "happy".
 

Constraints:

1 <= list1.length, list2.length <= 1000
1 <= list1[i].length, list2[i].length <= 30
list1[i] and list2[i] consist of spaces ' ' and English letters.
All the strings of list1 are unique.
All the strings of list2 are unique.
 * @author sukh
 *
 */
public class MinIndexSum_599 {

  /**
   * Time: O(n + m)<br>
   * Space: O(n)
   * @param list1
   * @param list2
   * @return
   */
  public String[] findCommonStrings(String[] list1, String[] list2) {
    Map<String, Integer> map1 = new HashMap<>();
    for (int i = 0; i < list1.length; i++) {
      map1.put(list1[i], i);
    }

    List<String> res = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    int s = 0;
    for (int i = 0; i < list2.length; i++) {
      if (map1.containsKey(list2[i])) {
        s = i + map1.get(list2[i]);
        if (s < min) {
          min = s;
          res.clear();
          res.add(list2[i]);
        } else if (s == min) {
          res.add(list2[i]);
        }
      }
    }
    return res.toArray(new String[res.size()]);
  }

}
