package dynamic_programming;

/*
 * @lc app=leetcode id=516 lang=java
 *
 * [516] Longest Palindromic Subsequence
 */

// @lc code=start
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Fill the diagonal with 1, while rest with 0
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;

                // If the characters are same,
                // add 2 to the immediate bottom left cell
                // else, check the maximum of left and botton cells
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        /// This builds the DP Array in the following fashion
        /// input - TOTAL
        //
        // * | T O T A L
        // --------------
        // T | 1 1 3 3 3
        // O | 0 1 1 1 1
        // T | 0 0 1 1 1
        // A | 0 0 0 1 1
        // L | 0 0 0 0 1

        return dp[0][n - 1];
    }
}
// @lc code=end
