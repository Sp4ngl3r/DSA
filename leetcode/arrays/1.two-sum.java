package leetcode.arrays;

import java.util.HashMap;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> differenceMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (differenceMap.containsKey(nums[i])) {
                return new int[] { differenceMap.get(nums[i]), i };
            }

            differenceMap.put(target - nums[i], i);
        }

        return new int[] { -1, -1 };
    }
}
// @lc code=end
