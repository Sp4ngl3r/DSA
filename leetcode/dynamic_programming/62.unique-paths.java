package dynamic_programming;

import java.util.Arrays;

/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        // Time Complexity: O(m*n)
        // Space Complexity: O(m*n)
        // int[][] pathGrid = new int[m][n];

        // If either of the path is out of bounds,
        // store a single path.

        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // if (i == 0 || j == 0) {
        // pathGrid[i][j] = 1;
        // } else {
        // pathGrid[i][j] = pathGrid[i][j - 1] + pathGrid[i - 1][j];
        // }
        // }
        // }
        // return pathGrid[m - 1][n - 1];

        /// For Space Complexity: O(min(m,n))
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        // Store only the row, where we will compute the adjacent cells.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}
// @lc code=end
