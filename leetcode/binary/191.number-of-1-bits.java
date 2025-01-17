package binary;

/*
 * @lc app=leetcode id=191 lang=java
 *
 * [191] Number of 1 Bits
 */

// @lc code=start
class Solution {
    public int hammingWeight(int n) {
        int bitCounter = 0;

        while (n != 0) {
            // This tries to remove the last set
            // 1-bit in the binary number.
            n = n & (n - 1);
            bitCounter++;
        }

        return bitCounter;
    }
}
// @lc code=end
