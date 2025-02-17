package arrays;

import java.util.Arrays;

/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        /// We are dividing the value by 2 to avoid overflow.
        int closestSum = Integer.MAX_VALUE / 2;

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1, right = nums.length - 1;

            while (left < right) {

                int currentSum = nums[i] + nums[left] + nums[right];

                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    return currentSum;
                }
            }
        }

        return closestSum;
    }
}
// @lc code=end
