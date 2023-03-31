package com.code.ds.hashtable;

import java.util.LinkedList;

/**
 * Design a HashSet.<br>
 * 
 * Used Linked List for collisions.<br>
 * 
 * Time: O(n / k)<br>
 * n = # of all possible values<br>
 * k = # of pre-defined buckets<br>
 * 
 * Space: O(m + k);<br>
 * k = # of pre-defined buckets<br>
 * m = # of unique values that have been inserted into the hash set
 * 
 * @author sukh
 *
 */
public class HashSet {

  private int keyRange;
  private Bucket[] buckets;

  public HashSet() {
    this.keyRange = 769;
    buckets = new Bucket[keyRange];
    for (int i = 0; i < keyRange; i++) {
      buckets[i] = new Bucket();
    }
  }

  protected int _hash(int key) {
    return key % keyRange;
  }

  public void add(int key) {
    int index = _hash(key);
    buckets[index].add(key);
  }

  public void remove(int key) {
    int index = _hash(key);
    buckets[index].remove(key);
  }

  public boolean contains(int key) {
    int index = _hash(key);
    return buckets[index].contains(key);
  }

}

class Bucket {
  private LinkedList<Integer> container;

  public Bucket() {
    container = new LinkedList<>();
  }

  public void add(Integer key) {
    int index = container.indexOf(key);
    if (index == -1) {
      container.addFirst(key);
    }
  }

  public void remove(Integer key) {
    container.remove(key);
  }

  public boolean contains(int key) {
    int index = container.indexOf(key);
    return (index != -1);
  }

}
