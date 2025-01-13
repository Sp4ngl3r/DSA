package dynamic_programming;

/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {

        // This is dynamic programming problem,
        // which can be solved by using the fibonacci series.

        if (n == 0 || n == 1) {
            return 1;
        }

        int first = 1, second = 1;

        for (int i = 2; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }
}
// @lc code=end
