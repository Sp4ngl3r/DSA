package dynamic_programming;

/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {

        int max = Integer.MIN_VALUE, currentMax = 1, currentMin = 1;

        for (int i : nums) {

            // If the number is negative, reverse the minimum and maximum
            if (i < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            currentMax = Math.max(i, currentMax * i);
            currentMin = Math.min(i, currentMin * i);
            max = Math.max(currentMax, max);
        }

        return max;
    }
}
// @lc code=end
