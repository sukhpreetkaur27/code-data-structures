package com.code.ds.striver.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, 
plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.

 

Example 1:


Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel 
(i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
Example 2:

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation: The starting pixel is already colored 0, so no changes are made to the image.
 

Constraints:

m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], color < 216
0 <= sr < m
0 <= sc < n
 * 
 * @author sukh
 *
 */
public class _11_FloodFill {

  class Pair {
    int r;
    int c;

    Pair(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  /**
   * Time: O(n * m) <br>
   * Space: O(n * m)
   * 
   * @param image
   * @param sr
   * @param sc
   * @param color
   * @return
   */
  public int[][] floodFill_bfs(int[][] image, int sr, int sc, int newColor) {

    /**
     * NOTE: BFS == Level Order Traversal
     * 
     * Since, we don't need to find the minimum time <br>
     * so we can skip BFS and proceed with DFS instead.
     */
    int color = image[sr][sc];
    if (color == newColor) {
      return image;
    }
    int m = image.length;
    int n = image[0].length;
    int[][] fill = Arrays.stream(image).map(int[]::clone).toArray(int[][]::new);

    int[] offset = { 0, 1, 0, -1, 0 };

    Deque<Pair> queue = new ArrayDeque<>();
    queue.offer(new Pair(sr, sc));
    fill[sr][sc] = newColor;

    while (!queue.isEmpty()) {
      Pair pop = queue.poll();
      for (int k = 0; k < offset.length - 1; k++) {
        int row = pop.r + offset[k];
        int col = pop.c + offset[k + 1];
        if (row >= 0 && row < m && col >= 0 && col < n) {
          if (fill[row][col] != newColor && image[row][col] == color) {
            fill[row][col] = newColor;
            queue.offer(new Pair(row, col));
          }
        }
      }
    }
    return fill;

  }

  /**
   * Time: O(n * m) <br>
   * Space: O(n * m)
   * 
   * @param image
   * @param sr
   * @param sc
   * @param color
   * @return
   */
  public int[][] floodFill_dfs(int[][] image, int sr, int sc, int newColor) {
    /**
     * NOTE: DFS == Recursive Depth Order Traversal
     */
    int color = image[sr][sc];
    if (color == newColor) {
      return image;
    }
    int[][] fill = Arrays.stream(image).map(int[]::clone).toArray(int[][]::new);

    int[] offset = { 0, 1, 0, -1, 0 };

    dfs(image, fill, offset, sr, sc, color, newColor);
    return fill;
  }

  private void dfs(int[][] image, int[][] fill, int[] offset, int sr, int sc, int color,
      int newColor) {
    fill[sr][sc] = newColor;
    int m = image.length;
    int n = image[0].length;

    for (int k = 0; k < offset.length - 1; k++) {
      int row = sr + offset[k];
      int col = sc + offset[k + 1];
      if (row >= 0 && row < m && col >= 0 && col < n) {
        if (fill[row][col] != newColor && image[row][col] == color) {
          dfs(image, fill, offset, row, col, color, newColor);
        }
      }
    }
  }

}
