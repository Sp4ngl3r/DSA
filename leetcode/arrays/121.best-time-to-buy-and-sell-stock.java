package leetcode.arrays;
/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {

        int left = 0;
        int right = 1;
        int maximumProfit = 0;

        while (right < prices.length) {

            if (prices[left] < prices[right]) {
                maximumProfit = Math.max(maximumProfit, prices[right] - prices[left]);
            } else {
                left = right;
            }

            right++;
        }

        return maximumProfit;
    }
}
// @lc code=end
