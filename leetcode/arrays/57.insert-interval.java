package arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        for (int[] slot : intervals) {

            // If the new interval is lesser than the current interval,
            // add the new interval before the current one and update the
            // new interval to the current one.
            if (newInterval[1] < slot[0]) {
                result.add(newInterval);
                newInterval = slot;
            }
            // If the new interval is greater than the current interval,
            // add the current interval.
            else if (newInterval[0] > slot[1]) {
                result.add(slot);
            }
            // If the new interval is colliding with the current interval,
            // set the new interval accordingly.
            else {
                newInterval[0] = Math.min(newInterval[0], slot[0]);
                newInterval[1] = Math.max(newInterval[1], slot[1]);
            }
        }

        // add the last interval
        result.add(newInterval);

        return result.toArray(new int[result.size()][]);
    }
}
// @lc code=end
