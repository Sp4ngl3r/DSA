package arrays;

import java.util.Arrays;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {

        int n = intervals.length;

        /// Sort in increasing order
        Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));

        int[][] merged = new int[n][2];

        int mergedIndex = 0;
        merged[0][0] = intervals[0][0];
        merged[0][1] = intervals[0][1];

        for (int i = 1; i < n; i++) {
            /// If the current interval overlaps with the
            /// last interval of merged
            if (intervals[i][0] <= merged[mergedIndex][1]) {
                /// Merge the intervals
                merged[mergedIndex][1] = Math.max(intervals[i][1], merged[mergedIndex][1]);
            }
            /// If there is no overlapping move to the next position.
            else {
                mergedIndex++;
                merged[mergedIndex][0] = intervals[i][0];
                merged[mergedIndex][1] = intervals[i][1];
            }
        }

        return Arrays.copyOf(merged, mergedIndex + 1);
    }
}
// @lc code=end
