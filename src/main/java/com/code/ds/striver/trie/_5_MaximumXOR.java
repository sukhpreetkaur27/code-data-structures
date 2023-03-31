package com.code.ds.striver.trie;

/**
 * Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.

 

Example 1:

Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.
Example 2:

Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127
 

Constraints:

1 <= nums.length <= 2 * 105
0 <= nums[i] <= 231 - 1
 * 
 * @author sukh
 *
 */
public class _5_MaximumXOR {

  /**
   * Time: O(n * 32) + O(n * 32)
   * @param nums
   * @return
   */
  public int findMaximumXOR(int[] nums) {
    /**
     * Insert the numbers in binary form with the MSB first and so on.
     */
    _5_Trie trie = new _5_Trie();
    for (int i : nums) {
      trie.insert(i);
    }
    int max = 0;
    for (int i : nums) {
      max = Math.max(max, trie.maximumXOR(i));
    }
    return max;
  }

  public static void main(String[] args) {
    _5_MaximumXOR obj = new _5_MaximumXOR();
    int[] arr = { 3, 10, 5, 25, 2, 8 };
    obj.findMaximumXOR(arr);
  }

}

class _5_Trie {

  private class Node {

    private Node[] links;

    public Node() {
      links = new Node[2];
    }

    public boolean containsKey(int i) {
      return links[i] != null;
    }

    public void put(int i, Node node) {
      links[i] = node;
    }

    public Node get(int i) {
      return links[i];
    }

  }

  private static Node root;

  public _5_Trie() {
    root = new Node();
  }

  public void insert(int num) {
    Node node = root;
    for (int i = 31, bit = 0; i >= 0; i--) {
      /**
       * check if i-th bit is set or unset
       */
      bit = (num >> i) & 1;
      if (!node.containsKey(bit)) {
        node.put(bit, new Node());
      }
      node = node.get(bit);
    }
  }

  public int maximumXOR(int num) {
    int maxXOR = 0;
    Node node = root;
    for (int i = 31, bit = 0; i >= 0; i--) {
      bit = (num >> i) & 1;
      /**
       * To maximize the XOR value, we should have numbers with bits towards the
       * left-most side opposite to the number to be XOR-ed with
       * 
       * different bits when XOR-ed result into 1
       */
      if (node.containsKey(1 - bit)) {
        maxXOR |= (1 << i);
        node = node.get(1 - bit);
      } else {
        node = node.get(bit);
      }
    }
    return maxXOR;
  }

}