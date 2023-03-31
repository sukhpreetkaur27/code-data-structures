package com.code.ds.linkedlist;

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
 * @author sukh
 *
 */
public class LRUCache {

  // maintain LRU cache using doubly linked list
  private class DLinkedNode {
    Integer key;
    Integer value;
    DLinkedNode prev;
    DLinkedNode next;
  }

  // HashMap to get and put values in O(1)
  private Map<Integer, DLinkedNode> cache;
  private int size;
  private int capacity;

  private DLinkedNode head;
  private DLinkedNode tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.size = 0;

    this.cache = new HashMap<>();

    this.head = new DLinkedNode();
    this.tail = new DLinkedNode();

    this.head.next = tail;
    this.tail.prev = head;
  }

  /**
   * Time: O(1)<br>
   * Space:O(1)
   * @param node
   */
  private void addNode(DLinkedNode node) {
    // Always add node to the head
    node.prev = head;
    node.next = head.next;

    head.next.prev = node;
    head.next = node;
  }

  /**
   * Time: O(1)<br>
   * Space:O(1)
   * @param node
   */
  private void removeNode(DLinkedNode node) {
    DLinkedNode prev = node.prev;
    DLinkedNode next = node.next;

    prev.next = next;
    next.prev = prev;
  }

  /**
   * Time: O(1)<br>
   * Space:O(1)
   * @param node
   */
  private void moveToHead(DLinkedNode node) {
    removeNode(node);
    addNode(node);
  }

  /**
   * Time: O(1)<br>
   * Space:O(1)
   * @return
   */
  private DLinkedNode popTail() {
    DLinkedNode node = tail.prev;
    removeNode(node);
    return node;
  }

  /**
   * Time: O(1)<br>
   * Space:O(1)
   * @param key
   * @return
   */
  public int get(int key) {
    DLinkedNode node = cache.get(key);
    if (node == null) {
      return -1;
    }
    moveToHead(node);
    return node.value;
  }

  /**
   * Time: O(1)<br>
   * Space:O(1)
   * @param key
   * @param value
   */
  public void put(int key, int value) {
    DLinkedNode node = cache.get(key);

    if (node == null) {
      node = new DLinkedNode();
      node.key = key;
      node.value = value;

      cache.put(key, node);
      addNode(node);

      ++size;

      if (size > capacity) {
        DLinkedNode tail = popTail();
        cache.remove(tail.key);
        --size;
      }
    } else {
      node.value = value;
      moveToHead(node);
    }
  }

}
