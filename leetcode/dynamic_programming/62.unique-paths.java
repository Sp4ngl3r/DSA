package dynamic_programming;

/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {

        int[][] pathGrid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    pathGrid[i][j] = 1;
                } else {
                    pathGrid[i][j] = pathGrid[i][j - 1] + pathGrid[i - 1][j];
                }
            }
        }

        return pathGrid[m - 1][n - 1];
    }
}
// @lc code=end
