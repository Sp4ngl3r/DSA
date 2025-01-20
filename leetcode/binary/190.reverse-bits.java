package binary;

/*
 * @lc app=leetcode id=190 lang=java
 *
 * [190] Reverse Bits
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int leftmostBitInGivenBinary = (n >> i) & 1;
            // store the above bit in result from right
            result = result | (leftmostBitInGivenBinary << (31 - i));
        }

        return result;
    }
}
// @lc code=end
