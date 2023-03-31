package com.code.ds.striver.array;

/**
 * Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * 
 * @author sukh
 *
 */
public class _45_MaxProductSubArray {
  
  /**
   * Time: O(2n) <br>
   * Space: O(1)
   * 
   * @param nums
   * @return
   */
  public int maxProduct_better(int[] nums) {
    /**
     * Kadane's Algorithm
     * 
     * the ans can be from left or from right or the complete array
     * 
     * Proof:
     * 
     * a.1. +ve * (+ans) * +ve --> complete array
     * 
     * a.2. +ve * (-ans) * +ve --> max(left, right)
     * 
     * b.1. +ve * (+ans) * -ve --> left * ans
     *
     * b.1. +ve * (-ans) * -ve --> right * ans
     * 
     * b.2. -ve * (+ans) * +ve --> right * ans
     * 
     * b.2. -ve * (-ans) * +ve --> left * ans
     * 
     * c.1. -ve * (+ans) * -ve --> left * ans * right --> complete array
     * 
     * c.2. -ve * (-ans) * -ve --> max(left * ans, right * ans)
     * 
     * 
     * NOTE: if nums[i] = 0, discard it by considering the max(left, right)
     * 
     */
    /**
     * initialize as each element is a sub-array
     */
    int ans = nums[0];
    /**
     * Prefix product
     */
    for (int i = 0, prod = 1; i < nums.length; i++) {
      prod *= nums[i];
      ans = Math.max(ans, prod);
      if (prod == 0) {
        prod = 1;
      }
    }

    /**
     * Suffix Product
     */
    for (int i = nums.length - 1, prod = 1; i >= 0; i--) {
      prod *= nums[i];
      ans = Math.max(ans, prod);
      if (prod == 0) {
        prod = 1;
      }
    }
    return ans;
  }
  
  /**
   * Time: O(n) <br>
   * Space: O(1)
   * 
   * @param nums
   * @return
   */
  public int maxProduct_optimal(int[] nums) {
    int ans = nums[0];
    int n = nums.length;
    int left = 1;
    int right = 1;
    for (int i = 0; i < n; i++) {
      left = (left == 0 ? 1 : left) * nums[i];
      right = (right == 0 ? 1 : right) * nums[n - 1 - i];
      ans = Math.max(ans, Math.max(left, right));
    }
    return ans;
  }

}
