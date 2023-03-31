package com.code.ds.hashtable.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:


Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
 * @author sukh
 *
 */
public class ValidSudoku_36 {

  /**
   * Time: O(n^2)<br>
   * Space: O(n^2)
   * @param board
   * @return
   */
  public boolean validSudoku(char[][] board) {
    final int N = 9;
    final char PERIOD = '.';

    Set<Character>[] rows = new Set[N];
    Set<Character>[] cols = new Set[N];
    Set<Character>[] boxes = new Set[N];

    for (int i = 0; i < N; i++) {
      rows[i] = new HashSet<Character>();
      cols[i] = new HashSet<Character>();
      boxes[i] = new HashSet<Character>();
    }

    char val;
    int idx;
    for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {
        val = board[r][c];

        if (val == PERIOD) {
          continue;
        }

        if (rows[r].contains(val)) {
          return false;
        }
        rows[r].add(val);

        if (cols[c].contains(val)) {
          return false;
        }
        cols[c].add(val);

        idx = r / 3 * 3 + c / 3;
        if (boxes[idx].contains(val)) {
          return false;
        }
        boxes[idx].add(val);
      }
    }

    return true;
  }

}
