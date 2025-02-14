package arrays;

import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {

        int longest = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {

            /// Check for previous number in the set
            if (!set.contains(num - 1)) {

                /// Check for next number in the series,
                /// until the series breaks
                int nextNumber = num + 1;
                int currentLength = 1;

                while (set.contains(nextNumber)) {
                    currentLength++;
                    nextNumber++;
                }

                /// Store the maximum occuring series
                longest = Math.max(longest, currentLength);
            }
        }

        return longest;
    }
}
// @lc code=end
