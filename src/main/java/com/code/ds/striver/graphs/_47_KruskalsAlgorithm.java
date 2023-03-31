package com.code.ds.striver.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a weighted, undirected and connected graph of V vertices and E edges.
 * The task is to find the sum of weights of the edges of the Minimum Spanning
 * Tree.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: 3 3 0 1 5 1 2 3 0 2 1
 * 
 * Output: 4 Explanation:
 * 
 * The Spanning Tree resulting in a weight of 4 is shown above. Example 2:
 * 
 * Input: 2 1 0 1 5
 * 
 * Output: 5 Explanation: Only one Spanning Tree is possible which has a weight
 * of 5.
 * 
 * 
 * Your task: Since this is a functional problem you don't have to worry about
 * input, you just have to complete the function spanningTree() which takes
 * number of vertices V and an adjacency matrix adj as input parameters and
 * returns an integer denoting the sum of weights of the edges of the Minimum
 * Spanning Tree. Here adj[i] contains a list of lists containing two integers
 * where the first integer a[i][0] denotes that there is an edge between i and
 * a[i][0][0] and second integer a[i][0][1] denotes that the distance between
 * edge i and a[i][0][0] is a[i][0][1].
 * 
 * In other words , adj[i][j] is of form { u , wt } . So,this denotes that i th
 * node is connected to u th node with edge weight equal to wt.
 * 
 * 
 * 
 * Expected Time Complexity: O(ElogV). Expected Auxiliary Space: O(V2).
 * 
 * 
 * Constraints: 2 ≤ V ≤ 1000 V-1 ≤ E ≤ (V*(V-1))/2 1 ≤ w ≤ 1000 Graph is
 * connected and doesn't contain self loops & multiple edges.
 * 
 * @author sukh
 *
 */
public class _47_KruskalsAlgorithm {

  class Edge {
    int src;
    int destn;
    int weight;

    Edge(int src, int destn, int weight) {
      this.src = src;
      this.destn = destn;
      this.weight = weight;
    }
  }

  class EdgeComparator implements Comparator<Edge> {
    public int compare(Edge a, Edge b) {
      return a.weight - b.weight;
    }
  }

  public int mst(int V, int E, int adj[][]) {
    /**
     * Kruskal's Algorithm - Find MST
     * 
     * Sort edges by weight
     * 
     * Use Disjoint Set + Union + isConnected
     * 
     * if nodes are not connected to DSU
     * 
     * perform union + add cost
     */
    int cost = 0;
//    List<Edge> edges = new ArrayList<>();
//    for (int[] edge : adj) {
//      edges.add(new Edge(edge[0], edge[1], edge[2]));
//    }
//    Collections.sort(edges, new EdgeComparator());
    Arrays.sort(adj, (int[] a, int[] b) -> {
      return a[2] - b[2];
    });
    _0_DisjointSet_UnionFind dsu = new _0_DisjointSet_UnionFind(V);
//    for (Edge edge : edges) {
//      if (!dsu.isConnected(edge.src, edge.destn)) {
//        cost += edge.weight;
//        dsu.unionByRank(edge.src, edge.destn);
//      }
//    }
    for (int[] edge : adj) {
      if (!dsu.isConnected(edge[0], edge[1])) {
        cost += edge[2];
        dsu.unionByRank(edge[0], edge[1]);
      }
    }
    return cost;
  }

  public static void main(String[] args) {
    _47_KruskalsAlgorithm obj = new _47_KruskalsAlgorithm();
    int[][] edges = { { 0, 1, 5 }, { 1, 2, 3 }, { 0, 2, 1 } };
    System.out.println(obj.mst(3, 3, edges));
  }

}
