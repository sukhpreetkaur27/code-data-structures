package com.code.ds.striver.binaryTrees;

import java.util.List;

/**
 * You are given an array nodes. It contains 7 integers, which represents the value of nodes of the binary tree in level order traversal. 
 * You are also given a root of the tree which has a value equal to nodes[0].

Your task to construct a binary tree by creating nodes for the remaining 6 nodes.

Example:

Input: 
nodes = [1 2 3 4 5 6 7]
Output: 
         1
       /   \
     2       3
   /  \     /  \
   4  5    6   7
Explanation: 
The 7 node binary tree is represented above.
Your Task:

Complete the function void create_tree(node* root0, vector &vec), which takes a root of a Binary tree and vector array vec containing the values of nodes.

Expected Time Complexity: O(1).

Expected Auxiliary Space: O(1).

Constraints:

vec.length = 7

1<=vec[i]<=100


 * 
 * @author sukh
 *
 */
public class _2_TreeRepresentation {

  class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
      this.data = data;
    }
  }

  public void createTree(Node root0, List<Integer> v) {
    root0.left = new Node(v.get(1));
    root0.right = new Node(v.get(2));
    root0.left.left = new Node(v.get(3));
    root0.left.right = new Node(v.get(4));
    root0.right.left = new Node(v.get(5));
    root0.right.right = new Node(v.get(6));
  }

}
