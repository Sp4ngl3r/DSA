package arrays;

/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {

        int redCounter = 0;
        int whiteCounter = 0;

        for (int i : nums) {
            if (i == 0) {
                redCounter++;
            }

            if (i == 1) {
                whiteCounter++;
            }
        }

        for (int i = 0; i < redCounter; i++) {
            nums[i] = 0;
        }

        for (int i = redCounter; i < whiteCounter + redCounter; i++) {
            nums[i] = 1;
        }

        for (int i = whiteCounter + redCounter; i < nums.length; i++) {
            nums[i] = 2;
        }
    }
}
// @lc code=end
