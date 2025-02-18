package arrays;

import java.util.Arrays;

/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        // Sort the array based on the second integer
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int previousInterval = 0;
        // Already we consider the initial interval
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {

            // If interval is not overlapping with its previous interval
            // we will travel to the next interval
            if (intervals[i][0] >= intervals[previousInterval][1]) {
                previousInterval = i;
                count++;
            }
        }

        return intervals.length - count;
    }
}
// @lc code=end
