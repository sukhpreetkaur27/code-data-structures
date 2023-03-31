package com.code.ds.hashtable.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.

 

Example 1:

Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]

Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 

Constraints:

-231 <= val <= 231 - 1
At most 2 * 105 calls will be made to insert, remove, and getRandom.
There will be at least one element in the data structure when getRandom is called.
 * @author sukh
 *
 */
public class InsertDeleteGetRandom_380 {

  private Random rand;
  /**
   * value - list index map
   */
  private Map<Integer, Integer> dictionary;
  /**
   * list of values
   */
  private List<Integer> list;

  public InsertDeleteGetRandom_380() {
    rand = new Random();
    dictionary = new HashMap<>();
    list = new ArrayList<>();
  }

  /**
   * Time: O(1)<br>
   * Space: O(n)
   * @param val
   * @return
   */
  public boolean insert(int val) {
    if (dictionary.containsKey(val)) {
      return false;
    }
    dictionary.put(val, list.size());
    list.add(list.size(), val);
    return true;
  }

  /**
   * Time: O(1)
   * @param val
   * @return
   */
  public boolean delete(int val) {
    if (!dictionary.containsKey(val)) {
      return false;
    }
    int last = list.get(list.size() - 1);
    int index = dictionary.get(val);

    list.set(index, last);
    dictionary.put(last, index);

    list.remove(list.size() - 1);
    dictionary.remove(val);

    return true;
  }

  /**
   * Time: O(1)
   * @return
   */
  public int get() {
    return list.get(rand.nextInt(list.size()));
  }

}
