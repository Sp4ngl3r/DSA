/*
 * @lc app=leetcode id=1043 lang=java
 *
 * [1043] Partition Array for Maximum Sum
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    // public int maxSumAfterPartitioning(int[] arr, int k) {
    // int n = arr.length;
    // int[] dp = new int[n];
    // Arrays.fill(dp, -1);

    // return func(arr, dp, n, k, 0);
    // }

    // // DP Approach - Memoization (Top-Down) for Non-Constant Transition Problem
    // private int func(int[] arr, int[] dp, int n, int k, int index) {
    // // Base case
    // if (index >= n) {
    // return 0;
    // }

    // // Ignore if already traversed
    // if (dp[index] != -1) {
    // return dp[index];
    // }

    // int maxSum = Integer.MIN_VALUE;
    // int max = Integer.MIN_VALUE;

    // for (int j = index; j < Math.min(n, index + k); j++) {
    // // Calculate maximum element in the range
    // max = Math.max(max, arr[j]);

    // // Compute the sum of elements in the range, when all of its
    // // elements are ssubstituted with maximum element.
    // // Also compute the same value for the rest part of the array.
    // int sum = (max * (j - index + 1)) + func(arr, dp, n, k, j + 1);

    // maxSum = Math.max(maxSum, sum);
    // }

    // // dp[index] = maxSum;
    // // return dp[index];
    // return dp[index] = maxSum;
    // }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        // Base case
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int maxSum = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;

            for (int j = i; j < Math.min(n, i + k); j++) {
                max = Math.max(max, arr[j]);
                int sum = (max * (j - i + 1)) + dp[j + 1];
                maxSum = Math.max(maxSum, sum);
            }

            dp[i] = maxSum;
        }

        return dp[0];
    }
}
// @lc code=end
