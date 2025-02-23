package dynamic_programming;

/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {

        // Rob 1 : Robbing 2 houses before
        // Rob 2 : Robbing previous house
        int rob1 = 0, rob2 = 0;

        for (int n : nums) {
            // We can rob the current house and 2 houses before
            // or rob only the previous house
            int temp = Math.max(rob2, n + rob1);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }
}
// @lc code=end
