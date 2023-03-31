package com.code.ds.striver.queue;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
 If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 

Constraints:

1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105
At most 2 * 105 calls will be made to get and put.
 * 
 * @author sukh
 *
 */
public class _6_LRU_Cache {

  /**
   * Doubly Linked List
   */
  class DNode {
    int key;
    int value;

    DNode prev;
    DNode next;

    DNode(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  // Cache
  private Map<Integer, DNode> cache;
  private DNode head;
  private DNode tail;

  private int capacity;
  private int size;

  public _6_LRU_Cache(int capacity) {
    this.capacity = capacity;
    cache = new HashMap<>();

    head = new DNode(0, 0);
    tail = new DNode(0, 0);

    head.next = tail;
    tail.prev = head;
  }

  /**
   * get == Move to head == Last Recently Used
   * @param key
   * @return
   */
  public int get(int key) {
    DNode node = cache.get(key);

    if (node == null) {
      return -1;
    } else {
      moveToHead(node);
    }
    return node.value;
  }

  private void moveToHead(DNode node) {
    removeNode(node);
    addNode(node);
  }

  private void removeNode(DNode node) {
    DNode next = node.next;
    DNode prev = node.prev;

    prev.next = next;
    next.prev = prev;
  }

  private void addNode(DNode node) {
    node.next = head.next;
    node.prev = head;
    head.next.prev = node;
    head.next = node;
  }

  /**
   * tail = LRU
   * @return
   */
  private DNode popTail() {
    DNode pop = tail.prev;
    removeNode(pop);
    return pop;
  }

  /**
   * put == add to head == Last Recently Used
   * @param key
   * @param value
   */
  public void put(int key, int value) {
    DNode node = cache.get(key);
    if (node == null) {
      node = new DNode(key, value);
      cache.put(key, node);
      addNode(node);
      ++size;
      if (size > capacity) {
        DNode pop = popTail();
        cache.remove(pop.key);
        size--;
      }

    } else {
      node.value = value;
      moveToHead(node);
    }
  }

}
