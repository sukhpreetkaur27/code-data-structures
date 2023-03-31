package com.code.ds.array;

public class RunningSum {

  /**
   * Time:O(n)<br>
   * Space:O(n)
   * @param nums
   * @return
   */
  public int[] runningSum(int[] nums) {
    int[] runSum = new int[nums.length];
    runSum[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      runSum[i] = runSum[i - 1] + nums[i];
    }
    return runSum;
  }

}
