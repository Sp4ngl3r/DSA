package dynamic_programming;
/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // Time Complexity: O(n)
        // Space Complexity: O(n)

        // int n = cost.length;
        // int minCost[] = new int[n];
        // minCost[0] = cost[0];
        // minCost[1] = cost[1];
        // for (int i = 2; i < n; i++) {
        // minCost[i] = Math.min(minCost[i - 1], minCost[i - 2]) + cost[i];
        // }
        // return Math.min(minCost[n-1], minCost[n-2]);


        // Space Complexity: O(1)
        int n = cost.length;
        int prev1 = cost[0];
        int prev2 = cost[1];

        for (int i = 2; i < n; i++) {
            int curr = Math.min(prev1, prev2) + cost[i];
            prev1 = prev2;
            prev2 = curr;
        }

        return Math.min(prev1, prev2);
    }
}
// @lc code=end
