package com.code.ds.striver.graphs;

import java.util.ArrayList;
import java.util.List;

public class _0_DisjointSet_UnionFind {

  /**
   * Union-Find-Connected have O(log n) time complexity --> which boils down to
   * O(1) with Path Compression
   */

  /**
   * Parent of 1-based indexed nodes
   */
  private List<Integer> parent;
  /**
   * Rank of 1-based indexed nodes
   */
  private List<Integer> rank;
  /**
   * Size of 1-based indexed nodes
   */
  private List<Integer> size;

  public List<Integer> getSize() {
    return size;
  }

  public void setSize(List<Integer> size) {
    this.size = size;
  }

  /**
   * Initialize Disjoint Set
   * 
   * Time: O(n)
   * 
   * @param n
   */
  _0_DisjointSet_UnionFind(int n) {
    parent = new ArrayList<>();
    rank = new ArrayList<>();
    size = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      /**
       * Default parent of x = x
       */
      parent.add(i);
      /**
       * Default Rank of x = 0
       * 
       * as nodes get added under a node such that its level increases --> so does its
       * rank
       */
      rank.add(0);
      /**
       * Single node in a component --> size = 1
       */
      size.add(1);
    }
  }

  public int find(int x) {
    /**
     * if parent(x) == x
     * 
     * it is the root
     * 
     * return x
     */
    if (x == parent.get(x)) {
      return x;
    }
    /**
     * find recursively parent (path compression)
     */
    parent.set(x, find(parent.get(x)));
    return parent.get(x);
  }

  /**
   * Union By Rank
   */
  public void unionByRank(int u, int v) {
    /**
     * Find ultimate parent i.e. Root (or) Head
     */
    int findU = find(u);
    int findV = find(v);
    /**
     * if ultimate roots are same
     * 
     * exit
     */
    if (findU == findV) {
      return;
    }
    /**
     * Find ranks of ultimate roots
     */
    int rankU = rank.get(findU);
    int rankV = rank.get(findV);
    /**
     * Attach lower rank root node to higher rank root node
     * 
     * i.e. set parent of lower rank root node to higher rank root node
     */
    if (rankU > rankV) {
      parent.set(findV, findU);
    } else if (rankU < rankV) {
      parent.set(findU, findV);
    } else {
      /**
       * If equal, you can attach either way
       * 
       * increment the rank
       */
      parent.set(findV, findU);
      rank.set(findU, rank.get(findU) + 1);
    }
  }

  /**
   * Union By Size
   */
  public void unionBySize(int u, int v) {
    /**
     * Find ultimate parent i.e. Root (or) Head
     */
    int findU = find(u);
    int findV = find(v);
    /**
     * if ultimate roots are same
     * 
     * exit
     */
    if (findU == findV) {
      return;
    }
    /**
     * Find size of ultimate roots
     */
    int sizeU = size.get(findU);
    int sizeV = size.get(findV);
    /**
     * Attach lower size root node to higher size root node
     * 
     * i.e. set parent of lower size root node to higher size root node
     * 
     * increment the size accordingly
     * 
     * size(parent) += size(child)
     */
    if (sizeU < sizeV) {
      parent.set(findU, findV);
      size.set(findV, size.get(findV) + size.get(findU));
    } else {
      /**
       * If equal, you can attach either way
       */
      parent.set(findV, findU);
      size.set(findU, size.get(findV) + size.get(findU));
    }
  }

  /**
   * if ultimate parent i.e. root nodes are same --> the nodes are connected
   * 
   * @param u
   * @param v
   * @return
   */
  public boolean isConnected(int u, int v) {
    return find(u) == find(v);
  }

  public static void main(String[] args) {
    /**
     * Disjoint Set - Union By Rank
     */
    _0_DisjointSet_UnionFind obj = new _0_DisjointSet_UnionFind(7);
    obj.unionByRank(1, 2);
    obj.unionByRank(2, 3);
    obj.unionByRank(4, 5);
    obj.unionByRank(6, 7);
    obj.unionByRank(5, 6);

    /**
     * if 3 and 7 are connected or not
     */
    if (obj.isConnected(3, 7)) {
      System.out.println("Same");
    } else {
      System.out.println("Not Same");
    }

    obj.unionByRank(3, 7);
    if (obj.isConnected(3, 7)) {
      System.out.println("Same");
    } else {
      System.out.println("Not Same");
    }

    /**
     * Disjoint Set - Union By Size
     */
    _0_DisjointSet_UnionFind obj1 = new _0_DisjointSet_UnionFind(7);
    obj1.unionBySize(1, 2);
    obj1.unionBySize(2, 3);
    obj1.unionBySize(4, 5);
    obj1.unionBySize(6, 7);
    obj1.unionBySize(5, 6);

    /**
     * if 3 and 7 are connected or not
     */
    if (obj1.isConnected(3, 7)) {
      System.out.println("Same");
    } else {
      System.out.println("Not Same");
    }

    obj1.unionBySize(3, 7);
    if (obj1.isConnected(3, 7)) {
      System.out.println("Same");
    } else {
      System.out.println("Not Same");
    }

  }

}
