package com.code.ds.striver.queue;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:

LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. 
When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. 
For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). 
The use counter for a key in the cache is incremented either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, 3, null, -1, 3, 4]

Explanation
// cnt(x) = the use counter for key x
// cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
LFUCache lfu = new LFUCache(2);
lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
lfu.get(1);      // return 1
                 // cache=[1,2], cnt(2)=1, cnt(1)=2
lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
                 // cache=[3,1], cnt(3)=1, cnt(1)=2
lfu.get(2);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,1], cnt(3)=2, cnt(1)=2
lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                 // cache=[4,3], cnt(4)=1, cnt(3)=2
lfu.get(1);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,4], cnt(4)=1, cnt(3)=3
lfu.get(4);      // return 4
                 // cache=[4,3], cnt(4)=2, cnt(3)=3
 

Constraints:

0 <= capacity <= 104
0 <= key <= 105
0 <= value <= 109
At most 2 * 105 calls will be made to get and put.
 * 
 * @author sukh
 *
 */
public class _7_LFU_Cache {

  class DNode {
    int key;
    int value;
    int freq;

    DNode prev;
    DNode next;

    DNode() {

    }

    DNode(int key, int value, int freq) {
      this.key = key;
      this.value = value;
      this.freq = freq;
    }
  }

  class DLinkedList {
    int size;
    DNode head;
    DNode tail;

    DLinkedList() {
      head = new DNode();
      tail = new DNode();

      head.next = tail;
      tail.prev = head;
    }

    // Add at head
    void add(DNode node) {
      node.next = head.next;
      node.prev = head;
      head.next.prev = node;
      head.next = node;
      size++;
    }

    // pop tail
    DNode popTail() {
      size--;
      DNode pop = tail.prev;
      tail.prev = pop.prev;
      pop.prev.next = tail;
      return pop;
    }

    // remove node from the list
    void remove(DNode node) {
      size--;
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }
  }

  private Map<Integer, DNode> cache;
  private Map<Integer, DLinkedList> freqCache;

  private int capacity;
  private int size;
  private int minFreq;

  public _7_LFU_Cache(int capacity) {
    this.capacity = capacity;
    cache = new HashMap<>();
    freqCache = new HashMap<>();
  }

  // O(1)
  public int get(int key) {
    DNode node = cache.get(key);
    if (node != null) {
      updateNode(node);
      return node.value;
    }
    return -1;
  }

  // O(1)
  public void put(int key, int value) {
    // edge case
    if (capacity == 0) {
      return;
    }

    DNode node = cache.get(key);
    if (node == null) {
      size++;

      // remove LRU of the LFU
      if (size > capacity) {
        DLinkedList list = freqCache.get(minFreq);
        DNode pop = list.popTail();
        cache.remove(pop.key);
        size--;
      }

      // reset min frequency to 1 because of adding new node
      minFreq = 1;

      node = new DNode(key, value, minFreq);
      cache.put(key, node);

      DLinkedList newList = freqCache.getOrDefault(minFreq, new DLinkedList());
      // add to head of the LRU of LFU
      newList.add(node);
      freqCache.put(minFreq, newList);
    } else {
      node.value = value;
      updateNode(node);
    }
  }

  // update frequency details for the currently used node
  private void updateNode(DNode node) {
    int freq = node.freq;
    DLinkedList list = freqCache.get(freq);
    // remove node from the frequency cache list
    list.remove(node);

    /**
     * if the updated(removed) node's frequency == minFreq and the minFreq list had
     * only this updated(removed) node <br>
     * increment minFreq
     */
    if (freq == minFreq && list.size == 0) {
      minFreq++;
    }

    node.freq++;
    DLinkedList newList = freqCache.getOrDefault(node.freq, new DLinkedList());
    // add to head of the LRU of LFU
    newList.add(node);
    freqCache.put(node.freq, newList);
  }

}
