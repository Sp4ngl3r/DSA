package dynamic_programming;

/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {

        // using dynamic programming approach
        int result[] = new int[n + 1];
        // offset is the highest valued bit
        int offset = 1;
        result[0] = 0;

        for (int i = 1; i <= n; i++) {
            // we reach the next offset, at the point
            // which is twice as its value.
            if (offset * 2 == i) {
                offset = i;
            }
            // since the series repeats between offsets,
            // we use those values.
            result[i] = 1 + result[i - offset];
        }

        return result;
    }
}
// @lc code=end
