package com.code.ds.striver.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the adjacency list of a bidirectional graph. Your task is to copy/clone the adjacency list for each vertex and return a new list.
 * 
 * For Input: 
5 7
0 1
0 4
1 2
1 3
1 4
2 3
3 4
Your Output: 
0-> 1-> 4
1-> 0-> 2-> 3-> 4
2-> 1-> 3
3-> 1-> 2-> 4
4-> 0-> 1-> 3
Expected Output: 
0-> 1-> 4
1-> 0-> 2-> 3-> 4
2-> 1-> 3
3-> 1-> 2-> 4
4-> 0-> 1-> 3
 * 
 * @author sukh
 *
 */
public class _2_BiDirectionalGraphPath {

  /**
   * Time: O(V + E) <br>
   * Space: O(V + E)
   * @param N
   * @param adj
   * @return
   */
  public List<List<Integer>> print(int N, List<List<Integer>> adj) {
    List<List<Integer>> adjacencyList = new ArrayList<>();

    // iterating over each vertex.
    for (int i = 0; i < N; i++) {
      List<Integer> nodeList = new ArrayList<>();

      // pushing the vertex at i-th index and all the
      // nodes connected to it in the output list.
      nodeList.add(i);

      List<Integer> temp = adj.get(i);
      for (int j = 0; j < temp.size(); j++) {
        nodeList.add(temp.get(j));
      }

      adjacencyList.add(nodeList);
    }

    return adjacencyList;
  }

}
