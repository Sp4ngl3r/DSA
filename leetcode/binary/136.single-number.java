package binary;

/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {

        int result = 0;

        for (int num : nums) {
            // XOR has associative property
            // XOR with same number gives 0
            result = result ^ num;
        }

        return result;
    }
}
// @lc code=end
