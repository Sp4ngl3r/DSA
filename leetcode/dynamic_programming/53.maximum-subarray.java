package dynamic_programming;

/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        // assume the first element always would have the
        // highest sum.
        int maximumSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // the longest sum might be the present number
            // or the sum of current maximum with present number
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maximumSum = Math.max(currentSum, maximumSum);
        }

        return maximumSum;
    }
}
// @lc code=end
