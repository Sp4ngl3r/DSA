package arrays;

/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {

        int max = 0, left = 0, right = height.length - 1;

        while (left < right) {

            int currentArea = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
// @lc code=end
