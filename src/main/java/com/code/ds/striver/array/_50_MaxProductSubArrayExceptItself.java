package com.code.ds.striver.array;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 * 
 * @author sukh
 *
 */
public class _50_MaxProductSubArrayExceptItself {

  /**
   * Time: O(3n) <br>
   * Space: O(2n)
   * 
   * @param nums
   * @return
   */
  public int[] productExceptSelf_better(int[] nums) {
    /**
     * Intuition: Kadane's Algo (Max Product Sub-Array)
     * 
     * for i-th element : ans = left * right
     */
    int n = nums.length;
    int[] prefix = new int[n];
    prefix[0] = 1;
    for (int i = 1; i < n; i++) {
      prefix[i] = prefix[i - 1] * nums[i - 1];
    }
    int[] suffix = new int[n];
    suffix[n - 1] = 1;
    for (int i = n - 2; i >= 0; i--) {
      suffix[i] = suffix[i + 1] * nums[i + 1];
    }
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      res[i] = prefix[i] * suffix[i];
    }
    return res;
  }

  /**
   * Time: O(2n) <br>
   * Space: O(1)
   * 
   * @param nums
   * @return
   */
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    /**
     * for 0-th element : ans = 1
     * 
     * for (n-1)-th element : ans = prefix product
     */
    res[0] = 1;
    for (int i = 1; i < n; i++) {
      res[i] = res[i - 1] * nums[i - 1];
    }
    int prod = nums[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      res[i] *= prod;
      prod *= nums[i];
    }
    return res;
  }

}
