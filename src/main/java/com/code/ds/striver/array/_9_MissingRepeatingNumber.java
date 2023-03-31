package com.code.ds.striver.array;

/**
 * Example 1:
 * 
 * Input Format: array[] = {3,1,2,5,3}
 * 
 * Result: {3,4)
 * 
 * Explanation: A = 3 , B = 4 Since 3 is appearing twice and 4 is missing
 * Example 2:
 * 
 * Input Format: array[] = {3,1,2,5,4,6,7,5}
 * 
 * Result: {5,8)
 * 
 * Explanation: A = 5 , B = 8 Since 5 is appearing twice and 8 is missing
 * 
 * @author sukh
 *
 */
public class _9_MissingRepeatingNumber {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param arr
   */
  public static void getMissingRepeatingNumber(int[] arr) {
    int n = arr.length;

    int x = 0;
    int y = 0;

    /**
     * XOR of arr[1..n] and [1..n] == missing ^ repeating
     */
    int xor = arr[n - 1] ^ n;
    for (int i = 0; i < n - 1; i++) {
      xor ^= arr[i] ^ (i + 1);
    }

//    int setBit = -xor;
    int setBit = xor & (-xor);

    int check;
    for (int i = 0; i < n; i++) {
      check = arr[i] & setBit;

      if (check != 0) {
        x ^= arr[i];
      } else {
        y ^= arr[i];
      }

      check = (i + 1) & setBit;
      if (check != 0) {
        x ^= (i + 1);
      } else {
        y ^= (i + 1);
      }
    }

    int count = 0;
    for (int i = 0; i < n && count < 2; i++) {
      if (arr[i] == x) {
        count++;
      }
    }

    if (count == 2) {
      System.out.println("Repeating = " + x);
      System.out.println("Missing = " + y);
    } else {
      System.out.println("Missing = " + x);
      System.out.println("Repeating = " + y);
    }
  }

  public static void main(String[] args) {
//    int[] arr = { 3, 1, 2, 5, 3 };
//    getMissingRepeatingNumber(arr);
    int[] num = { 3, 1, 2, 5, 4, 6, 7, 5 };
    getMissingRepeatingNumber(num);
  }

}
