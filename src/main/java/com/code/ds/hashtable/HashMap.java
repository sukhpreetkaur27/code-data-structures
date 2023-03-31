package com.code.ds.hashtable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Design a Hashmap.
 * 
 * 
 * Time: O(n / k)<br>
 * Space: O(k + m)<br>
 * n = # of all possible values<br>
 * k = key range, i.e., predefined buckets in the hashmap<br>
 * here, k = 2069<br>
 * m = # of unique keys that have been inserted into the hashmap
 * @author sukh
 *
 */
public class HashMap {

  private int keyRange;
  private List<HashTable> buckets;

  public HashMap() {
    this.keyRange = 2069;
    buckets = new ArrayList<>();
    for (int i = 0; i < keyRange; i++) {
      buckets.add(new HashTable());
    }
  }

  private int _hash(int key) {
    return key % keyRange;
  }

  public void put(int key, int value) {
    int index = _hash(key);
    buckets.get(index).put(key, value);
  }

  public void remove(int key) {
    int index = _hash(key);
    buckets.get(index).remove(key);
  }

  public int get(int key) {
    int index = _hash(key);
    return buckets.get(index).get(key);
  }

}

class HashTable {

  private LinkedList<Pair<Integer, Integer>> container;

  public HashTable() {
    container = new LinkedList<>();
  }

  public void put(int key, int value) {
    boolean found = false;
    for (Pair<Integer, Integer> pair : container) {
      if (pair.key.equals(key)) {
        pair.value = value;
        found = true;
        break;
      }
    }
    if (!found) {
      container.addFirst(new Pair<Integer, Integer>(key, value));
    }
  }

  public void remove(int key) {
    for (Pair<Integer, Integer> pair : container) {
      if (pair.key.equals(key)) {
        container.remove(pair);
        break;
      }
    }
  }

  public int get(int key) {
    for (Pair<Integer, Integer> pair : container) {
      if (pair.key.equals(key)) {
        return pair.value;
      }
    }
    return -1;
  }

}

class Pair<K, V> {
  public K key;
  public V value;

  public Pair(K key, V value) {
    this.key = key;
    this.value = value;
  }
}
