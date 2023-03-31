package com.code.ds.hashtable.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Design a data structure that accepts a stream of integers and checks if it has a pair of integers that sum up to a particular value.

Implement the TwoSum class:

TwoSum() Initializes the TwoSum object, with an empty array initially.
void add(int number) Adds number to the data structure.
boolean find(int value) Returns true if there exists any pair of numbers whose sum is equal to value, otherwise, it returns false.
 

Example 1:

Input
["TwoSum", "add", "add", "add", "find", "find"]
[[], [1], [3], [5], [4], [7]]
Output
[null, null, null, null, true, false]

Explanation
TwoSum twoSum = new TwoSum();
twoSum.add(1);   // [] --> [1]
twoSum.add(3);   // [1] --> [1,3]
twoSum.add(5);   // [1,3] --> [1,3,5]
twoSum.find(4);  // 1 + 3 = 4, return true
twoSum.find(7);  // No two integers sum up to 7, return false
 

Constraints:

-105 <= number <= 105
-231 <= value <= 231 - 1
At most 104 calls will be made to add and find.
 * @author sukh
 *
 */
public class TwoSumIII_170 {

  /**
   * Space: O(n)<br>
   * N is the total number of unique numbers that we will see during the usage of the data structure.
   */
  private Map<Integer, Integer> num_freq;

  public TwoSumIII_170() {
    num_freq = new HashMap<>();
  }

  /**
   * Time: O(1)
   * @param num
   */
  public void add(int num) {
    num_freq.put(num, num_freq.getOrDefault(num, 0) + 1);
  }

  /**
   * Time: O(n)<br>
   * N is the total number of unique numbers that we will see during the usage of the data structure.
   * @param sum
   * @return
   */
  public boolean find(int sum) {
    for (Entry<Integer, Integer> entry : num_freq.entrySet()) {
      int key = entry.getKey();
      int freq = entry.getValue();

      int complement = sum - key;
      if (complement != key) {
        if (num_freq.containsKey(complement)) {
          return true;
        }
      } else {
        if (freq > 1) {
          return true;
        }
      }
    }
    return false;
  }

}
